package db.interview;

import io.swagger.model.TradeMessage;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Converter for the message we received to a TradeMessage
 */
public class MessageToTradeMessageConverter {

     private static final Integer MAX_LENGTH = 89; // length of the message
     private static final Integer MAX_SiZE_LIST = 6; // elements in a message

    /**
     * Converts a <code>String</code> to a <code>TradeMessage</code>
     * @param message
     * @return db.interview.model.TradeMessage
     */
     public static TradeMessage convertMessage(final String message) throws ConvertMessageException {
        if(message != null) {

            // test if length is ok
            Supplier<Integer> messageLength = message::length;
            if (messageLength.get() != MAX_LENGTH)
                throw new ConvertMessageException("Length to correct!");

            // convert from semicolon to TradeMessage
            //StmtId; DBTimestamp;TradeDate;AcctNo;SecNo;Numbers
            //StringTokenizer stringTokenizer = new StringTokenizer(message, ";");

            List<String> list = Collections.list(new StringTokenizer(message, ";")).stream()
                    .map(t -> (String) t)
                    .collect(Collectors.toList());

            // we should now have exact 6 elements
            if (list.size() != MAX_SiZE_LIST)
                throw new ConvertMessageException("Elements in List not matching!");

            try {
                // convertion to a TradeMessage
                TradeMessage tm = new TradeMessage();
                tm.setStmtId(list.get(0));
                tm.setDbTimestamp(OffsetDateTime.parse(list.get(1)));
                tm.setTradeDate(LocalDate.parse(list.get(2)));
                tm.acctNo(Integer.valueOf(list.get(3)));
                tm.setSecNo(list.get(4));
                tm.setNumbers(list.get(5));

                return tm; // end
            } catch (Exception ex) {
                throw new ConvertMessageException("Inputdata could not be converted to TradeMessage!");
            }
        }
        return null;
    }

}
