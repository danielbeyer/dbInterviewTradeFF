package db.interview;

import io.swagger.api.ListTradeMessagesApiController;
import io.swagger.model.TradeMessage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Hashtable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {Swagger2SpringBoot.class})
public class ListTradeMessagesApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListTradeMessagesApiController listTradeMessagesApiController;

    @Autowired
    public Hashtable<String, TradeMessage> tradeDataStore;

    @Before
    public void fillTradeDate() {
        TradeMessage tm = new TradeMessage();
        tm.setStmtId("12341234FFFF");
        tm.setDbTimestamp(OffsetDateTime.now());
        tm.setTradeDate(LocalDate.now());
        tm.acctNo(1234567);
        tm.setSecNo("514000");
        tm.setNumbers("+0000021,000");

        tradeDataStore.put(tm.getStmtId(), tm);
    }

    @Test
    public void contexLoadsList() throws Exception {
        assertThat(listTradeMessagesApiController).isNotNull();
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/c5764/dbInterviewShowcase/1.0.0/listTradeMessages")
                             .header("accept", "application/json"))
                             .andDo(print())
                             .andExpect(status().isOk());
    }
}