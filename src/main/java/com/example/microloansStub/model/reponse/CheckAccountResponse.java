package com.example.microloansStub.model.reponse;

import com.example.microloansStub.model.Debt;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CheckAccountResponse {
    private String account;
    @JsonProperty("vip-client")
    private Boolean vip_client;
    private Boolean blocked;
    private String inn;
    private List<Debt> debt;
}
