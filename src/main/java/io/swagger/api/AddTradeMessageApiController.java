package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import db.interview.ConvertMessageException;
import db.interview.MessageToTradeMessageConverter;
import db.interview.TradeOutdatedException;
import io.swagger.model.SendTradeMessage;
import io.swagger.model.TradeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Hashtable;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-10T16:56:11.041Z")

@Controller
public class AddTradeMessageApiController implements AddTradeMessageApi {

    private final Logger log = LoggerFactory.getLogger(AddTradeMessageApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private Hashtable<String, TradeMessage> tradeDataStore;

    @org.springframework.beans.factory.annotation.Autowired
    public AddTradeMessageApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    @Override
    public ResponseEntity<String> addTradeMessage(SendTradeMessage inventoryItem) {
        log.info("--> received message....");
        if((inventoryItem != null) && (inventoryItem.getTradeMessage() != null) && (inventoryItem.getTradeMessage().length() > 0)) {
            TradeMessage tm = null;
            try {
                String message = inventoryItem.getTradeMessage();

                log.info("--> message: " + message);
                tm = MessageToTradeMessageConverter.convertMessage(message);
            } catch (ConvertMessageException cme) {
                log.error("-x-> Error in convertion: " + cme.getMessage());
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if(tm != null) {
                try {
                    addOrUpdateTradeToStore(tm);
                    log.info("--> added message: " + tm.getStmtId() + " stored: " + tradeDataStore.size());
                } catch (TradeOutdatedException e) {
                    log.error("-x> " + e.toString());
                    return new ResponseEntity<>("trade allready there", HttpStatus.valueOf(409));
                }
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        log.info("--> endTradeMessage ....");
        return new ResponseEntity<>("added or updated Trade", HttpStatus.OK);
    }

    private void addOrUpdateTradeToStore(final TradeMessage tm) throws TradeOutdatedException {
        if(tm != null) {
            // if empty we put it in
            if(!tradeDataStore.containsKey(tm.getStmtId())) {
                tradeDataStore.put(tm.getStmtId(), tm);
            }
            // if it allready exists we check date, if stored data is newer -> we throw an exception
            // outherwise we update
            else if(tradeDataStore.containsKey(tm.getStmtId())) {
                TradeMessage tradeMessage = tradeDataStore.get(tm.getStmtId());

                // update
                if(tradeMessage.getDbTimestamp().isEqual(tm.getDbTimestamp()) || tradeMessage.getDbTimestamp().isBefore(tm.getDbTimestamp())) {
                    tradeDataStore.put(tm.getStmtId(), tm);
                }
                // throw Exception
                else if(tradeMessage.getDbTimestamp().isAfter(tm.getDbTimestamp())) {
                    throw new TradeOutdatedException("Data requested is outdated.");
                }

            }
        }
    }
}
