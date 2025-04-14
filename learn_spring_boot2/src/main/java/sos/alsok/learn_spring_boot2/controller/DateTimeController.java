package sos.alsok.learn_spring_boot2.controller;

import org.springframework.web.bind.annotation.*;


import sos.alsok.learn_spring_boot2.service.WaktuService;

@RestController
@RequestMapping("/datenow")
public class DateTimeController {

    private WaktuService waktuService;

    public DateTimeController (WaktuService waktuService) {
        this.waktuService = waktuService;
    }

    @GetMapping
    public String getDateNow(){
        return "Tanggal sekarang: " + waktuService.getWaktuSekarang();
    }
}
