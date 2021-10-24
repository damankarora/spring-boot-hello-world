package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSOutput;

import java.util.Map;

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

    @GetMapping("/getvars")
    public String getvars(){
        StringBuilder result = new StringBuilder();
        Map<String, String> ourEnvVars = System.getenv();
        for (Map.Entry<String, String> entry : ourEnvVars.entrySet()){
            result.append(entry.getKey()).append(" = ").append(entry.getValue()).append("<br>");
        }

        return result.toString();
    }

    @GetMapping("/start")
    public String myEnd(@RequestParam(required = false) String name){
        return ("API's are fun, and so are you " + ((name == null)?("my friend"):(name)));
    }
}
