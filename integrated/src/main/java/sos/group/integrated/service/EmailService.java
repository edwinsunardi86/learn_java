package sos.group.integrated.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
}
