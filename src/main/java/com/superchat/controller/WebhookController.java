package com.superchat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("superchat/v1")
public class WebhookController {

    @GetMapping("/webhook")
    public ResponseEntity<String> respondToWebhook() {
        System.out.println("This is so cool");
        return ResponseEntity.ok("Hello from Twilio!");
    }


}