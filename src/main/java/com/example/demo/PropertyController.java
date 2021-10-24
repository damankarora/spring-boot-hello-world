package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

    @Value("${OS}")
    private String OS;

    PropertyController(){
        System.out.println("Object of Property controller created");
        System.out.println(OS);
    }

    void showOS(){
        System.out.println("ourOS is " + this.OS);
    }
}
