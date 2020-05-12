package db.interview;

import io.swagger.api.ListTradeMessagesApiController;
import io.swagger.model.TradeMessage;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Hashtable;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
@SpringBootTest(classes = Swagger2SpringBoot.class)
public class ListTradeMessagesApiControllerTest {

    //@Autowired
    //private MockMvc mockMvc;

    @Autowired
    private ListTradeMessagesApiController tradesApiController;

    @Bean
    public Hashtable<String, TradeMessage> tradeDataStore() {
        return new Hashtable<>();
    }


    @Before
    public void fillTradeDate() {
        TradeMessage tm = new TradeMessage();
        tm.setStmtId("12341234FFFF");
        tm.setDbTimestamp(OffsetDateTime.now());
        tm.setTradeDate(LocalDate.now());
        tm.acctNo(1234567);
        tm.setSecNo("514000");
        tm.setNumbers("+0000021,000");

        tradeDataStore().put(tm.getStmtId(), tm);
    }

    @Test
    public void contexLoads() throws Exception {
        assertThat(tradesApiController).isNotNull();
    }


    //@MockBean
    //private ListTradeMessagesApiController tradeMessagesApiController;

//    @Test
//    public void listTradeMessagesTest() throws Exception {
//        TradeMessage tm = new TradeMessage();
//        tm.setStmtId("12341234FFFF");
//        tm.setDbTimestamp(OffsetDateTime.now());
//        tm.setTradeDate(LocalDate.now());
//        tm.acctNo(1234567);
//        tm.setSecNo("514000");
//        tm.setNumbers("+0000021,000");
//
//        List<TradeMessage> allTrades = singletonList(tm);
//        ResponseEntity<List<TradeMessage>> response = new ResponseEntity(allTrades, HttpStatus.OK);
//
//
//        given(tradeMessagesApiController.listTradeMessages(null, null, null)).willReturn(response);
//
//        mvc.perform(get("/listTradeMessages")
//                .contentType(APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)));
//
//    }

    //@Test
    //public void shouldReturnDefaultMessage() throws Exception {
        //this.mockMvc.perform(get("/listTradeMessages").contentType("application/json")).andExpect(status().isOk());

        //ResultActions perform = this.mockMvc.perform(get("/listTradeMessages"));

        //perform.toString();
        //        .andExpect(content().string(containsString("Hello, World")));
    //}
}