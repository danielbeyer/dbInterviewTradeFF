package db.interview;

import io.swagger.api.AddTradeMessageApiController;
import io.swagger.api.ListTradeMessagesApiController;
import io.swagger.model.SendTradeMessage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {Swagger2SpringBoot.class})
public class AddTradeMessagesApiControllerTest {

    private final Logger log = LoggerFactory.getLogger(AddTradeMessagesApiControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListTradeMessagesApiController listTradeMessagesApiController;

    @MockBean
    private AddTradeMessageApiController addTradeMessageApiController;

    private List<SendTradeMessage> inputList = new ArrayList<>();


    private static final String TEST_INPUT_1 = "s00009699631;2020-04-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000";
    private static final String TEST_INPUT_2 = "s00009699632;2020-04-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000";
    private static final String TEST_INPUT_3 = "s00009699633;2020-04-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000";
    private static final String TEST_INPUT_4 = "s00009699634;2020-04-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000";
    private static final String TEST_INPUT_5 = "s00009699635;2020-04-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000";
    private static final String TEST_INPUT_6 = "s00009699636;2020-04-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000";
    private static final String TEST_INPUT_7 = "s00009699637;2020-04-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000";
    private static final String TEST_INPUT_8 = "s00009699638;2020-04-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000";
    private static final String TEST_INPUT_9 = "s00009699639;2020-04-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000";


    //@Autowired
    //public Hashtable<String, TradeMessage> tradeDataStore;

    @Before
    public void createTradeMessages() {
        SendTradeMessage stm1 = new SendTradeMessage();
        stm1.setTradeMessage(TEST_INPUT_1);
        SendTradeMessage stm2 = new SendTradeMessage();
        stm2.setTradeMessage(TEST_INPUT_2);
        SendTradeMessage stm3 = new SendTradeMessage();
        stm3.setTradeMessage(TEST_INPUT_3);
        SendTradeMessage stm4 = new SendTradeMessage();
        stm4.setTradeMessage(TEST_INPUT_4);
        SendTradeMessage stm5 = new SendTradeMessage();
        stm5.setTradeMessage(TEST_INPUT_5);
        SendTradeMessage stm6 = new SendTradeMessage();
        stm6.setTradeMessage(TEST_INPUT_6);
        SendTradeMessage stm7 = new SendTradeMessage();
        stm7.setTradeMessage(TEST_INPUT_7);
        SendTradeMessage stm8 = new SendTradeMessage();
        stm8.setTradeMessage(TEST_INPUT_8);
        SendTradeMessage stm9 = new SendTradeMessage();
        stm9.setTradeMessage(TEST_INPUT_9);

        inputList.add(stm1);
        inputList.add(stm2);
        inputList.add(stm3);
        inputList.add(stm4);
        inputList.add(stm5);
        inputList.add(stm6);
        inputList.add(stm7);
        inputList.add(stm8);
        inputList.add(stm9);
    }

    @Test
    public void contexLoadsAdd() throws Exception {
        assertThat(addTradeMessageApiController).isNotNull();
    }

    @Test
    public void listTradeMessagesTest() throws Exception {

        //given(addTradeMessageApiController.addTradeMessage()
        mockMvc.perform(get("/c5764/dbInterviewShowcase/1.0.0/listTradeMessages")
                .header("accept", "application/json"))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$", hasSize(0)));

        mockMvc.perform(post("/c5764/dbInterviewShowcase/1.0.0/addTradeMessage")
                        .contentType(MediaType.APPLICATION_JSON)
                        .requestAttr("tradeMessage", TEST_INPUT_1)
                        .param("tradeMessage", TEST_INPUT_1)
                        .content("{\"tradeMessage\":\"" + TEST_INPUT_1 + "\"}"))
                        .andDo(print())
                        .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(get("/c5764/dbInterviewShowcase/1.0.0/listTradeMessages")
                                  .header("accept", "application/json"))
                                  .andReturn();

        log.info("the result: " + result.getResponse().getContentAsString());
        log.info("the result: " + result.getResponse().getStatus());

        assertEquals(200, result.getResponse().getStatus());
    }

}