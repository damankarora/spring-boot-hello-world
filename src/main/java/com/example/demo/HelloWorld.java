package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSOutput;

@RestController
public class HelloWorld {

    @Value("${OS}")
    private String OS;

    HelloWorld(){
        System.out.println("HEELO WORLD CONSTRUCTOR CALLED");
        System.out.println(OS);
    }

    @GetMapping("/")
    public String index(){

        return "Hello world with OS" + OS;
    }

    @GetMapping("/start")
    public String myEnd(@RequestParam(required = false) String name){
        return ("API's are fun, and so are you " + ((name == null)?("my friend"):(name)));
    }
}
