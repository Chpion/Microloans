package com.example.microloansStub.service;

import com.example.microloansStub.model.Contact;
import com.example.microloansStub.model.Debt;
import com.example.microloansStub.model.reponse.CheckAccountResponse;
import com.example.microloansStub.model.reponse.ConfirmPayResponse;
import com.example.microloansStub.model.request.ConfirmPayRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class MicroloansService {

    @Value("${X}")
    private int X;

    public CheckAccountResponse getAccount(Integer acc, Integer days){
        CheckAccountResponse checkAccountResponse = new CheckAccountResponse();
        checkAccountResponse.setAccount(acc.toString());
        checkAccountResponse.setVip_client(acc % 2 != 0);
        checkAccountResponse.setBlocked(false);
        checkAccountResponse.setInn(acc + "111");
        checkAccountResponse.setDebt(randomizedDebts(days));
        return checkAccountResponse;
    }

    public ConfirmPayResponse confirmPay(ConfirmPayRequest request, Integer bankCode){
        ConfirmPayResponse confirmPayResponse = new ConfirmPayResponse();
        confirmPayResponse.setTransactionId(request.getTransactionId());
        confirmPayResponse.setBankBik(String.valueOf(1_000_000_000L + new Random().nextLong(9_000_000_000L)));
        confirmPayResponse.setStatus("accepted");
        confirmPayResponse.setContact(randomizedContact(bankCode));
        return confirmPayResponse;
    }

    public String deleteTransaction() throws InterruptedException {
        try {
            Thread.sleep(X * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "deleted success";
    }

    private List<Contact> randomizedContact(Integer count){
        List<String> telecom = new ArrayList<>();
        for(int i = 0; i < count; i++){
            telecom.add(i%2==0?"sdf3453dg":"jklm34sdf");
        }
        return new ArrayList<>(List.of(new Contact("HL pay company", telecom)));
    }



    private List<Debt> randomizedDebts(Integer days){
        ArrayList<Debt> debts = new ArrayList<>();
        for(int i = 0; i < days; i++){
            Debt debt = new Debt();
            debt.setSum(1000 + new Random().nextInt(9001));
            debt.setDescription(i%2==0?"gkh":"parking");
            debts.add(debt);
        }
        return debts;
    }

}
