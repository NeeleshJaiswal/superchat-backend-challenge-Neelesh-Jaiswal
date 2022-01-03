package com.superchat.controller;

import com.superchat.model.Conversation;
import com.superchat.services.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/superchat/v1")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @GetMapping("/conversations")
    public ResponseEntity<List<Conversation>> getAllConversations() {
        return ResponseEntity.ok(conversationService.getAllConversations());
    }

    @PostMapping("/conversations")
    public ResponseEntity<Void> endConversation(Long conversationId) {
        conversationService.endConversation(conversationId);
        return ResponseEntity.ok().build();
    }

}