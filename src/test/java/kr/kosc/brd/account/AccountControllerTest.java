package kr.kosc.brd.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by kiost on 2017-07-20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class AccountControllerTest {

    @Autowired
    WebApplicationContext wac;

    @Autowired
    public ObjectMapper objectMapper;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void createAccount() throws Exception {
        AccountDto.Create create = new AccountDto.Create();
        create.setUsername("bhsss");
        create.setPassword("password");

        ResultActions result = mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(create)));

        result.andDo(print());
        result.andExpect(status().isCreated());
    }

    @Test
    public void createAccount_BadRequest() throws Exception {
        AccountDto.Create create = new AccountDto.Create();
        create.setUsername("  ");
        create.setPassword("12345");

        ResultActions result = mockMvc.perform(post("/accounts").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(create)));

        result.andDo(print());
        result.andExpect(status().isBadRequest());
    }
}