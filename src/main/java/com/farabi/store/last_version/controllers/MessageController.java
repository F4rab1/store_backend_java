package com.farabi.store.last_version.controllers;

import com.farabi.store.last_version.entities.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @RequestMapping("/hello")
    public ResponseEntity<Message> sayHello() {
        return ResponseEntity.ok(new Message("Hello Farabi"));
    }
}
