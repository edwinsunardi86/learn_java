package sos.alsok.learn_spring_boot2.controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import sos.alsok.learn_spring_boot2.service.HaloService;

@RestController
@RequestMapping("/haloguardian")
public class MainController {
    // @Autowired
    private HaloService haloService;

    public MainController (HaloService haloService) {
        this.haloService = haloService;
    }

    @GetMapping
    public String sayHelloGuardian(){
        return haloService.HaloGuardian();
    }
}
