package sos.alsok.learn_spring_boot2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationUser {
    
    @Autowired
    private UserService userService;

    public String notifyUser(){
        return "Notifying user: " +userService.getUser();
    }
}
