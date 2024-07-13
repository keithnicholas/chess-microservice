package com.baneff.gameroom.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hi/")
public class HelloWorldController {

    @GetMapping("/1")
    public String getHello(){
        return "Hello";
    }

    @GetMapping()
    public List<?> getAvailbleRooms(){
        return List.of("Room 1", "Room 2", "Room 3");
    }
}
