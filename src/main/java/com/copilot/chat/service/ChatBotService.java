package com.copilot.chat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatBotService {

    private final ChatClient chatClient;

    private static final Logger logger = LoggerFactory.getLogger(ChatBotService.class);

    public ChatBotService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public Flux<String> generateResponse(String message) {
        logger.debug("generateResponse: Message received : {}", message);
        return chatClient.prompt()
                .user(message)
                .stream()
                .content();
    }

    public String createTickets(String message) {
        logger.debug("createTickets: Message received : {}", message);
        return chatClient.prompt()
                .user(message)
                .advisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .call()
                .content();
    }

} 