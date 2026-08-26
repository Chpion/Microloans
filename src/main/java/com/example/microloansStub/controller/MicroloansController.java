package com.example.microloansStub.controller;

import com.example.microloansStub.model.reponse.CheckAccountResponse;
import com.example.microloansStub.model.reponse.ConfirmPayResponse;
import com.example.microloansStub.model.request.ConfirmPayRequest;
import com.example.microloansStub.service.MicroloansService;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@Tag(name = "Микрозаймы")
public class MicroloansController {

    private MicroloansService microloansService;

    @GetMapping(path="/v2/checkAccount")
    @Operation(description = "Получение информации об аккаунте")
    @Timed(value="checkAccount", description = "")
    public ResponseEntity<CheckAccountResponse> checkAccount(@RequestParam Integer acc, @RequestParam Integer days){
        log.info("Check Account");
        return ResponseEntity.status(HttpStatusCode.valueOf(202))
                .body(microloansService.getAccount(acc, days));
    }

    @PostMapping(path="/v2/payment")
    @Operation(description = "Подтвреждение платяжа")
    @Parameter(name = "BankCode", description = "BankCode", required = true, in = ParameterIn.HEADER)
    @Timed(value="confirmPay", description = "")
    public ResponseEntity<ConfirmPayResponse> confirmPay(@RequestBody ConfirmPayRequest confirmPayRequest, @RequestHeader("BankCode") Integer bankCode){
        log.info("Confirm Pay");
        return ResponseEntity.status(HttpStatusCode.valueOf(200))
                .body(microloansService.confirmPay(confirmPayRequest, bankCode));
    }

    @DeleteMapping(path="v1/transactions/cleare/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    @Operation(description = "Подтвреждение платяжа")
    @Timed(value="deleteTransaction", description = "")
    public ResponseEntity<String> deleteTransaction(@PathVariable String id) throws InterruptedException {
        log.info("Delete Transaction");
        return ResponseEntity.status(HttpStatus.OK).body(microloansService.deleteTransaction());
    }

}
