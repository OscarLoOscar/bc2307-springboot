package com.hkjava.demo.demofinnhub;

import java.time.LocalDate;
import java.util.List;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;
import com.hkjava.demo.demofinnhub.repository.StockRepository;
import com.hkjava.demo.demofinnhub.service.callAPI.CompanyService;

// 唔關心json，postman controller 對外
@SpringBootTest
public class CompanyServiceTest {
  // Hamcrest , hasItem() -> test Array
  // mock 走Jpa

  @MockBean // service autowird repository
  private StockRepository stockRepository;

  /*
   * when i use @Autowired ,not use @MockBean ,is has Exception
   * 
   * when() requires an argument which has to be 'a method call on a mock'.
   * 
   * For example: when(mock.getArticles()).thenReturn(articles);
   */
  @MockBean // 模擬RestTemplate.getForObject,
  // 是否最後thenReturn(mocekCompanyProfile)
  private RestTemplate restTemplate;

  @Autowired // 拎真既野黎用
  private String finnhubToken = "cju3it9r01qr958213c0cju3it9r01qr958213cg";

  @Autowired // thats why no need InjectMock
  private CompanyService companyService;


  @Test
  void testFindAll() {

    Stock stock1 = Stock.builder()//
        .id(1L)//
        .country("US")//
        .build();
    Stock stock2 = Stock.builder()//
        .id(2L)//
        .country("HK")//
        .build();

    Mockito.when(stockRepository.findAll()).thenReturn(List.of(stock1, stock2));

    List<Stock> stocks = companyService.findAll(); // 真call -> stockRepository.findAll()
    assertThat(stocks, hasItem(hasProperty("country", equalTo("HK"))));
    assertThat(stocks, hasItem(hasProperty("country", equalTo("US"))));
    // assertThat(stocks, hasItem(hasProperty("country", equalTo("HK"))));
    assertThat(stocks, not(hasItem(hasProperty("country", equalTo("CN")))));

  }

  @Test
  void testRestTemplateUrl() throws FinnhubException {
    // test 有冇砌?symbol=上去，有冇加"/""
    // we are checking this url
    String expectedUrl =
        "HTTPS://finnhub.io/api/v1/stock/profile2?symbol=TSLA&token="
            .concat(finnhubToken);// <- 我expect 啱既野 , 砌到先call到

    CompanyProfile mockCompanyProfile = CompanyProfile.builder()//
        .country("HK")//
        .ipoDate(LocalDate.of(1988, 12, 31))//
        .build();// mocked CompanyProfile
    System.out.println(mockCompanyProfile.toString());
    // Mock the RestTemplate to return the mockedCompanyProfile when called with the expected URL
    // test Mock link
    Mockito.when(restTemplate.getForObject(expectedUrl, CompanyProfile.class))//
        .thenReturn(mockCompanyProfile);
    // 有人call呢個situation，return ： mockCompanyProfile
    // 得到我既mock result 自然match到assertThat

    // Call the service method to retrieve the CompanyProfile
    // 真link
    CompanyProfile profile = companyService.getCompanyProfile("TSLA");

    // Verify that the returned CompanyProfile matches the mockedCompanyProfile
    assertThat(profile, is(hasProperty("country", equalTo("HK"))));
  }
}
