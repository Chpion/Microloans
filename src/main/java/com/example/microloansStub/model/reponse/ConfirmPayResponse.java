package com.example.microloansStub.model.reponse;

import com.example.microloansStub.model.Contact;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ConfirmPayResponse {
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("bank_bik")
    private String bankBik;
    private String status;
    private List<Contact> contact;
}
