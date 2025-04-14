package sos.alsok.learn_spring_boot2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sos.alsok.learn_spring_boot2.service.NotificationUser;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/notify")
public class NotifyController {
    
    private final NotificationUser notificationUser;

    public NotifyController(NotificationUser notificationUser){
        this.notificationUser = notificationUser;
    }

    @GetMapping
    public String notifyUser() {
        return notificationUser.notifyUser();
    }
}
