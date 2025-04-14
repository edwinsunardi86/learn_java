package sos.alsok.learn_spring_boot2.controller;

import org.springframework.web.bind.annotation.*;

import sos.alsok.learn_spring_boot2.service.TransactionService;

@RestController
@RequestMapping("/generatecode")
public class GenerateCodeController {
    
    private TransactionService transactionService;
    
    public GenerateCodeController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping
    public String showGenerateCode(){
        return "Transaction Code : " + transactionService.showTransactionKode();
    }
}
