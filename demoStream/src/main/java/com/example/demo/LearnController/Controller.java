package com.example.demo.LearnController;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class Controller {

    @GetMapping("/student/{id}")
    public String getUser(@PathVariable("id") Long id) {
        return "Student id " + id;
    }

    @GetMapping("/studentParam")
    public String getUserByParam(@PathParam("id") Long id) {
        return "Student id param " + id;
    }

    @PostMapping("/requestForm")
    public String requestForm(@ModelAttribute StudentRequest student) {
        return student.toString();
    }

    @PostMapping("/requestJson")
    public String requestJson(@RequestBody StudentRequest student) {
        return student.toString();
    }

}
