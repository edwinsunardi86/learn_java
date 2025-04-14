package sos.alsok.learn_spring_boot2.config;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {
    @Bean
    public SimpleDateFormat simpleDateFormat () {
        return new SimpleDateFormat("dd-MM-yyyy");
    }
}
