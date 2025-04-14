package sos.alsok.learn_spring_boot2.service;

import org.springframework.stereotype.Service;

import sos.alsok.learn_spring_boot2.component.KodeGenerator;

@Service
public class TransactionService {
    
    private KodeGenerator kodeGenerator;

    public TransactionService(KodeGenerator kodeGenerator) {
        this.kodeGenerator = kodeGenerator;
    }

    public String showTransactionKode(){
        return kodeGenerator.generateKode();
    }
}
