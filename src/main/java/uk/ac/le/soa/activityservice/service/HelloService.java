package uk.ac.le.soa.activityservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.le.soa.activityservice.entity.Hello;
import uk.ac.le.soa.activityservice.repository.HelloRepository;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;

    public List<Hello> displayAllHello(){
       return helloRepository.findAll();
    }
    public void saveHello(Hello hello) {
        System.out.println(hello.getMessage());
        helloRepository.save(hello);
    }

}
