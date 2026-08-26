package com.example.microloansStub.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConfirmPayRequest {
    @JsonProperty("transaction_id")
    private String transactionId;
    private Double sum;
    @JsonProperty("need_processing")
    private Boolean needProcessing;
}
