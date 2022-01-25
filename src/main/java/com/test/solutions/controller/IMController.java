package com.test.solutions.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.solutions.MessageService;
import com.test.solutions.beans.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IMController {

    @Autowired
    MessageService messageService;

    static ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/send/message/")
    public ResponseEntity<String> sendMessage(String channel, String sender, String message) {
        Message response = messageService.sendMessage(channel, sender, message);
        String responseStr = response.getMessageText();
        return ResponseEntity.ok().body(responseStr);
    }

    @GetMapping("/receive/message/")
    public ResponseEntity<String> receiveMessage(String channel) {
        List<Message> response = messageService.receiveMessage(channel);
        try {
            if(response != null) {
                String repsonseStr = objectMapper.writeValueAsString(response);
                return ResponseEntity.ok().body(repsonseStr);
            }
            return ResponseEntity.notFound().build();
        } catch (JsonProcessingException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
