package uk.ac.le.soa.activityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.le.soa.activityservice.service.HelloService;

@RestController
@RequestMapping("")
public class HelloController {

    @Autowired
    HelloService hello;

    @GetMapping("")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/hello")
        public String helloFromService(){
        return hello.helloStringService();
    }

}
