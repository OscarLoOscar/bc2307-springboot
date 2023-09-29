package com.vtxlab.demofinnhub;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.vtxlab.demofinnhub.controller.impl.DtoController;
import com.vtxlab.demofinnhub.model.CompanyReqDto;
import com.vtxlab.demofinnhub.model.QuoteReqDto;
import com.vtxlab.demofinnhub.services.CompanyService;
import com.vtxlab.demofinnhub.services.QuoteService;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DtoController.class)
public class DtoControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private QuoteService quoteService;

  @MockBean
  private CompanyService companyService;

  /*
   * CompanyReqDto(String country, String currency, String exchange, String finnhubIndustry, String ipo, String logo, long marketCapitalization, String name, String phone, double shareOutstanding,
   * String ticker, String weburl
   */
  /*
   * double c, double d, double dp, double h, double l, double o, double pc, int t
   */
  @Test
  void testGetData() throws Exception {
    CompanyReqDto companyReqDto = new CompanyReqDto("US", "USD", "Exchange",
        "Industry", "1980-12-12", "https://logo.com/logo.jpg", 1000000L,
        "Company", "1234567890", 1000.0, "TICKER", "https://company.com");
    //
    QuoteReqDto quoteReqDto = new QuoteReqDto(100.0, 110.0, 90.0, 120.0, 80.0,
        105.0, 95.0, 1631904000);

    Mockito.when(companyService.getCompanyData("TICKER"))
        .thenReturn(companyReqDto);
    Mockito.when(quoteService.getCompanyPrice("TICKER"))
        .thenReturn(quoteReqDto);

    mockMvc.perform(get("/api/v1/stock").param("symbol", "TICKER"))
        .andExpect(status().isOk());
    // .andExpect(/* add more assertions here if needed */);
  }
}
