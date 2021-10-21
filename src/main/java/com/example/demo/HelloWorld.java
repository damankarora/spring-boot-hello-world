package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public String index(){
        return "Hello world";
    }

    @GetMapping("/start")
    public String myEnd(@RequestParam(required = false) String name){
        return ("API's are fun, and so are you " + ((name == null)?("my friend"):(name)));
    }
}
