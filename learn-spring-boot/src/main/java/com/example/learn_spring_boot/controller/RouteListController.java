package com.example.learn_spring_boot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
public class RouteListController {

    @Autowired
    @Qualifier("requestMappingHandlerMapping")
    private RequestMappingHandlerMapping handlerMapping;


    @GetMapping("/routes")
    public List<String> listRoutes() {
        return handlerMapping.getHandlerMethods()
                .keySet()
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
