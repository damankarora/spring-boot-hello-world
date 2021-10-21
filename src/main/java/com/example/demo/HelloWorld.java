package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Value("${server.port}")
    private String port;



    @GetMapping("/")
    public String index(){
        System.out.println(port);
        System.out.println(System.getenv("message"));
        return "Hello world";
    }

    @GetMapping("/start")
    public String myEnd(@RequestParam(required = false) String name){
        return ("API's are fun, and so are you " + ((name == null)?("my friend"):(name)));
    }
}
