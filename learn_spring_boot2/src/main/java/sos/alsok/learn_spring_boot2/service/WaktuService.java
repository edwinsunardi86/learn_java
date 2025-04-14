package sos.alsok.learn_spring_boot2.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class WaktuService {
    
    private final SimpleDateFormat sdf;

    public WaktuService(SimpleDateFormat simpleDateFormat){
        this.sdf = simpleDateFormat;
    }

    public String getWaktuSekarang() {
        return sdf.format(new Date());
    }

}
