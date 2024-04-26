package com.example.server_register.controller;

import com.example.server_register.commons.RegisterRespone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/events")
public class TestController {

    @GetMapping()
    public ResponseEntity<?> getEvents(){
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("id", 123);
        responseBody.put("name", "My Event");
        responseBody.put("date", "2023-04-01");
        // Add other custom attributes as needed

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
