package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Value("${server.port}")
    private String port;

    @Value("${message}")
    private String messageFromApplication;

    @GetMapping("/")
    public String index(){
        System.out.println(port);
//        Unable to access system.properties.
//        System.out.println(System.getenv("message"));

//        Accessing application.properties apart from port on heroku.
        System.out.println(messageFromApplication);
        return "Hello world";
    }

    @GetMapping("/start")
    public String myEnd(@RequestParam(required = false) String name){
        return ("API's are fun, and so are you " + ((name == null)?("my friend"):(name)));
    }
}
