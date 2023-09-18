package com.vtxlab.demo.demoresttemplate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.vtxlab.demo.demoresttemplate.model.User;
import com.vtxlab.demo.demoresttemplate.services.UserService;

// this is another testing environment
// which may not require a full context
@WebMvcTest // 帶一D夠用功能入嚟 , 唔放多餘既Bean
// @AutoConfigureMockMvc
public class UserControllerTest {

        @Autowired
        private MockMvc mockMvc;
        // @Autowired//cant use Autowired , no bean
        // @Mock just mock 普通java project
        @MockBean // @mock緊一個帶Bean既class
        private UserService userService;

        @Test
        void testFindAllUsers() throws Exception {
                User user1 = new User(1, "John", "johnlau", "johnlau@gmail.com",
                                null, null, null, null);
                User user2 = new User(2, "Mary", "marylau", "marylau@gmail.com",
                                null, null, null, null);
                Mockito.when(userService.findAllUsers())
                                .thenReturn(List.of(user1, user2));
                // Mockito.verify(null, null)

                // ResultActions mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users"))
                                .andExpect(status().isOk()) // HTTP 200
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.code").value(20000))//
                                .andExpect(jsonPath("$.message").value(20000))//
                                .andExpect(jsonPath("$.data[0].id").value("OK"))
                                .andExpect(jsonPath("$.data[0].name")
                                                .value("John"))
                                .andExpect(jsonPath("$.data[1].id").value(1))
                                .andExpect(jsonPath("$.data[1].name")
                                                .value("Mary"))
                                .andDo(MockMvcResultHandlers.print());

        }

        @Test
        void testFindEmptyUsers() throws Exception {
                Mockito.when(userService.findAllUsers()).thenReturn(null);

                mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users"))
                                .andExpect(status().isBadRequest()) // HTTP 400
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.code").value(40001))//
                                .andExpect(jsonPath("$.message").value(
                                                "JsonPlaceHolder RestClientException"))
                                .andExpect(jsonPath("$.data").doesNotExist())
                                .andDo(MockMvcResultHandlers.print());
        }
}// 模仿start 左server 黎做test

