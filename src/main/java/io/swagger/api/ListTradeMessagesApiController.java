package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.TradeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-10T16:56:11.041Z")

@Controller
public class ListTradeMessagesApiController implements ListTradeMessagesApi {

    private final Logger logger = LoggerFactory.getLogger(ListTradeMessagesApiController.class);

    @Autowired
    private Hashtable<String, TradeMessage> tradeDataStore;

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ListTradeMessagesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
    public ResponseEntity<List<TradeMessage>> listTradeMessages(String searchString, Integer skip, Integer limit) {
        logger.info("-> listTradeMessage called....");
        List<TradeMessage> list = new ArrayList<>();
        // we search only one
        if(searchString != null) {
            list.add(tradeDataStore.get(searchString));
        // we search more than one
        // limit is filled but not skip
        } else if(limit != null && limit > 0 && (skip == null || skip.intValue() <= 0)) {
            list = tradeDataStore.values().stream().limit(limit).collect(Collectors.toList());
        // skip is filled but not limit
        } else if(skip != null && skip > 0 && (limit == null || limit.intValue() <= 0)) {
            list = tradeDataStore.values().stream().skip(skip).collect(Collectors.toList());
        // skip and limit are filled
        } else if(skip != null && skip > 0 && limit != null && limit.intValue() > 0) {
            list = tradeDataStore.values().stream().skip(skip).limit(limit).collect(Collectors.toList());
        // all is null -> we search for all
        } else {
            list = tradeDataStore.values().stream().collect(Collectors.toList());
        }

        logger.info("-> listTradeMessage end...");
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
