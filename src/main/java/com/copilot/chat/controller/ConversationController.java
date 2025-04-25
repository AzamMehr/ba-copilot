package com.copilot.chat.controller;

import com.copilot.chat.service.ChatBotService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@Configuration
public class ConversationController {
    private final ChatBotService chatBotService;


    public ConversationController(ChatBotService chatBotService) {
        this.chatBotService = chatBotService;
    }


    @GetMapping("/stream")
    public Flux<String> stream(@RequestParam String message) {
        return chatBotService.generateResponse(message);
    }
}
