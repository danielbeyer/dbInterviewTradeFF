package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * SendTradeMessage
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-10T10:10:46.560Z")
public class SendTradeMessage   {
  @JsonProperty("tradeMessage")
  private String tradeMessage = null;

  public SendTradeMessage tradeMessage(String tradeMessage) {
    this.tradeMessage = tradeMessage;
    return this;
  }

  /**
   * Get tradeMessage
   * @return tradeMessage
  **/
  @ApiModelProperty(example = "db trade message", value = "")
  public String getTradeMessage() {
    return tradeMessage;
  }

  public void setTradeMessage(String tradeMessage) {
    this.tradeMessage = tradeMessage;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendTradeMessage sendTradeMessage = (SendTradeMessage) o;
    return Objects.equals(this.tradeMessage, sendTradeMessage.tradeMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendTradeMessage {\n");
    
    sb.append("    tradeMessage: ").append(toIndentedString(tradeMessage)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

