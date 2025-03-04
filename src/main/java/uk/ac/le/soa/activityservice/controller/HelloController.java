package uk.ac.le.soa.activityservice.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.le.soa.activityservice.entity.Hello;
import uk.ac.le.soa.activityservice.service.HelloService;

import java.util.List;

@RestController
@RequestMapping("")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("")
    public String hello(){
        return "Hello";
    }
    @GetMapping("/all")
    public List<Hello> allHello(){
       return helloService.displayAllHello();
    }
    @PostMapping("")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful", content = @Content(mediaType = "application/json" )),
            @ApiResponse(responseCode = "400", description = "Invalid Data",content = @Content(mediaType = "application/json" )),
            @ApiResponse(responseCode = "404", description = "Hello Not Found",content = @Content(mediaType = "application/json" )),
            @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content(mediaType = "application/json" ))
    })
    public boolean saveHelloToDB(@RequestBody Hello helloBody){
        helloService.saveHello(helloBody);
        return true;
    }



}
