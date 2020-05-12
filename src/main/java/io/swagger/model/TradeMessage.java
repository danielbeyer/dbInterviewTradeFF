package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * TradeMessage
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-10T10:10:46.560Z")

public class TradeMessage   {
  @JsonProperty("stmtId")
  private String stmtId = null;

  @JsonProperty("dbTimestamp")
  private OffsetDateTime dbTimestamp = null;

  @JsonProperty("tradeDate")
  private LocalDate tradeDate = null;

  @JsonProperty("acctNo")
  private Integer acctNo = null;

  @JsonProperty("secNo")
  private String secNo = null;

  @JsonProperty("numbers")
  private String numbers = null;

  public TradeMessage stmtId(String stmtId) {
    this.stmtId = stmtId;
    return this;
  }

  /**
   * Get stmtId
   * @return stmtId
  **/
  @ApiModelProperty(example = "s00009699633", required = true, value = "")
  @NotNull


  public String getStmtId() {
    return stmtId;
  }

  public void setStmtId(String stmtId) {
    this.stmtId = stmtId;
  }

  public TradeMessage dbTimestamp(OffsetDateTime dbTimestamp) {
    this.dbTimestamp = dbTimestamp;
    return this;
  }

  /**
   * Get dbTimestamp
   * @return dbTimestamp
  **/
  @ApiModelProperty(example = "2020-03-16T15:40:00.000Z", required = true, value = "")
  @NotNull

  @Valid

  public OffsetDateTime getDbTimestamp() {
    return dbTimestamp;
  }

  public void setDbTimestamp(OffsetDateTime dbTimestamp) {
    this.dbTimestamp = dbTimestamp;
  }

  public TradeMessage tradeDate(LocalDate tradeDate) {
    this.tradeDate = tradeDate;
    return this;
  }

  /**
   * Get tradeDate
   * @return tradeDate
  **/
  @ApiModelProperty(example = "2020-05-08T00:00:00.000Z", required = true, value = "")
  @NotNull

  @Valid

  public LocalDate getTradeDate() {
    return tradeDate;
  }

  public void setTradeDate(LocalDate tradeDate) {
    this.tradeDate = tradeDate;
  }

  public TradeMessage acctNo(Integer acctNo) {
    this.acctNo = acctNo;
    return this;
  }

  /**
   * Get acctNo
   * @return acctNo
  **/
  @ApiModelProperty(example = "1000303857", required = true, value = "")
  @NotNull


  public Integer getAcctNo() {
    return acctNo;
  }

  public void setAcctNo(Integer acctNo) {
    this.acctNo = acctNo;
  }

  public TradeMessage secNo(String secNo) {
    this.secNo = secNo;
    return this;
  }

  /**
   * Get secNo
   * @return secNo
  **/
  @ApiModelProperty(example = "514000", required = true, value = "")
  @NotNull
  public String getSecNo() {
    return secNo;
  }

  public void setSecNo(String secNo) {
    this.secNo = secNo;
  }

  public TradeMessage numbers(String numbers) {
    this.numbers = numbers;
    return this;
  }

  /**
   * Get numbers
   * @return numbers
  **/
  @ApiModelProperty(example = "+0000000000021,0000", required = true, value = "")
  @NotNull


  public String getNumbers() {
    return numbers;
  }

  public void setNumbers(String numbers) {
    this.numbers = numbers;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TradeMessage tradeMessage = (TradeMessage) o;
    return Objects.equals(this.stmtId, tradeMessage.stmtId) &&
        Objects.equals(this.dbTimestamp, tradeMessage.dbTimestamp) &&
        Objects.equals(this.tradeDate, tradeMessage.tradeDate) &&
        Objects.equals(this.acctNo, tradeMessage.acctNo) &&
        Objects.equals(this.secNo, tradeMessage.secNo) &&
        Objects.equals(this.numbers, tradeMessage.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stmtId, dbTimestamp, tradeDate, acctNo, secNo, numbers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeMessage {\n");
    
    sb.append("    stmtId: ").append(toIndentedString(stmtId)).append("\n");
    sb.append("    dbTimestamp: ").append(toIndentedString(dbTimestamp)).append("\n");
    sb.append("    tradeDate: ").append(toIndentedString(tradeDate)).append("\n");
    sb.append("    acctNo: ").append(toIndentedString(acctNo)).append("\n");
    sb.append("    secNo: ").append(toIndentedString(secNo)).append("\n");
    sb.append("    numbers: ").append(toIndentedString(numbers)).append("\n");
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

