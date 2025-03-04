package uk.ac.le.soa.activityservice.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String helloStringService(){
        return "Hello from the service layer of the application";
    }
}
