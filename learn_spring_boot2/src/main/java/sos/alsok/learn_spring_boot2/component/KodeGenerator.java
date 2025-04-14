package sos.alsok.learn_spring_boot2.component;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class KodeGenerator {
    
    public String generateKode(){
        Random random = new Random();
        int number = 1000 + random.nextInt(8999);
        String kode = String.valueOf(number);
        return "KODE-"+kode;
    }
}
