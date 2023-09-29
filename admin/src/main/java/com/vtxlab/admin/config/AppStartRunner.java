package com.vtxlab.admin.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.vtxlab.admin.entity.Stock;
import com.vtxlab.admin.entity.StockPrice;
import com.vtxlab.admin.entity.StockSymbol;
import com.vtxlab.admin.exception.FinnhubException;
import com.vtxlab.admin.model.mapper.FinnhubMapper;
import com.vtxlab.admin.repository.StockPriceRepository;
import com.vtxlab.admin.repository.StockRepository;
import com.vtxlab.admin.service.CompanyService;
import lombok.extern.slf4j.Slf4j;

/*
 * Spring Boot提供了兩個介面：CommandLineRunner、ApplicationRunner，用於啟動應用程式時做特殊處理，
 * 
 * 這些程式碼會在SpringApplication的run()方法運行完成之前執行。
 * 
 * 相對於Spring的ApplicationListener介面自訂監聽器、Servlet的ServletContextListener監聽器。
 * 
 * 使用二者的好處在於，可以方便的使用應用程式啟動參數，根據參數不同做不同的初始化操作。
 */

// 實作CommandLineRunner、ApplicationRunner介面。 通常用於應用程式啟動前的特殊程式碼執行，例如：
// 將系統常用的資料載入到內存
// 應用上一次運行的垃圾資料清理
// 系統啟動成功後的通知的發送

// 在應用程式啟動時將系統內常用的設定資料。 從資料庫載入到內存，
// 以後使用該資料的時候只需要呼叫getSysConfigList方法，不需要每次使用該資料都去資料庫載入。
// 節省系統資源、縮減資料載入時間。

// @Profile("!test"): This annotation ensures that this component is only active when the Spring profile is not set to "test."
// Profiles are used to configure different behavior for different
// environments (e.g., development, production, testing).
@Component
@Slf4j
@Profile("!test")//目的：防止database 有野，要確保isEmpty
public class AppStartRunner implements CommandLineRunner {
  // 公司做報價既setUp，唔係人比乜用乜，自己set up List 做buffer -> 人地增加你唔一定增加
  // if唔final，自己寫api，自己call自己Api update條list，server唔洗restart
  // final -> 唔比任何人改，除非重新compile jar
  public static final List<String> stocksInventory =
      List.of("AAPL", "MSFT", "TSLA");

  @Autowired
  StockPriceService stockPriceService;

  @Autowired
  CompanyService companyService;

  @Autowired
  StockSymbolService stockSymbolService;

  @Autowired
  StockRepository stockRepository;

  @Autowired
  StockPriceRepository stockPriceRepository;

  @Autowired
  FinnhubMapper finnhubMapper;

  @Override
  public void run(String... args) throws FinnhubException {// 啟動時由database

    // Before Server Start:
    // 0. Get all symbols (US) from the below API.
    // https://finnhub.io/api/v1/stock/symbol?exchange=US&token=cju3it9r01qr958213c0cju3it9r01qr958213cg 0. Creat one more Entity StockSymbol 1.Get Company Profile 2 and insert into database 2.Get Stock
    // 0. Create one more Entity StockSymbol
    // Clear the tables
   // stockPriceRepository.deleteAll(); // ddl-update
    companyService.deleteAll();
    stockSymbolService.deleteAll();
    // Call API to get all symbols
    // List<Symbol> symbols = stockSymbolService.getStockSymbol();
    // System.out.println("All Symbols are inserted.");
    // 1.Save all symbols
    // Limit first symbols only
    //
    // Approach 1
    List<StockSymbol> symbols = stockSymbolService.getStockSymbol().stream()//
        .limit(10L)//
        // .filter(symbol -> "AAPL".equals(symbol.getSymbol()) || //
        // "MSFT".equals(symbol.getSymbol()))// 自選40隻股票
        .collect(Collectors.toList());
    //
    // Approach 2 :
    List<StockSymbol> newSymbolsList = stockSymbolService.getStockSymbol().stream()//
        .filter(symbol -> stocksInventory.contains(symbol.getSymbol()))//
        .collect(Collectors.toList());
    log.info("All symbols are inserted.No. of Symbols = " + symbols.size());

    System.out.println("First " + symbols.size() + "  Symbols are inserted.");

    stockSymbolService.save(newSymbolsList).stream()//
        .limit(10L)//
        .forEach(symbol -> {
          try {
            CompanyProfile companyProfile = //最raw , API DATA
                companyService.getCompanyProfile(symbol.getSymbol());

            Stock stock = finnhubMapper.map(companyProfile);
            stock.setStockSymbol(symbol);

            Stock storedStock = stockRepository.save(stock);// 落database
            log.info("completed symbol = " + symbol.getSymbol());
            // 3.Get Stock Price and insert into database

            Quote quote = stockPriceService.getQuote(symbol.getSymbol());

            StockPrice stockPrice = finnhubMapper.map(quote);
            stockPrice.setStock(storedStock);
            stockPriceRepository.save(stockPrice);
            log.info("complete symbol = " + symbol.getSymbol());
          } catch (FinnhubException e) {
            log.info("RestClientException: Symbol" + symbol.getSymbol());
          }
        });
    ScheduleTaskConfig.start = true;
    log.info("Stocks in Inventory stock are inserted");
    log.info("CommandLineRunner Completed");

  }

}
