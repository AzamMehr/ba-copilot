package com.copilot.chat.config;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class ConversationalConfig{

    @Bean
    McpSyncClient mcpSyncClient(@Value("${jira-mcp-server.url}") String mcpServerUrl) {
        var mcpClient = McpClient
                .sync(new HttpClientSseClientTransport(mcpServerUrl))
                .build();
        mcpClient.initialize();
        return mcpClient;
    }

    @Bean
    ChatClient chatClient(McpSyncClient mcpSyncClient, ChatClient.Builder chatClientBuilder) {
        var system = """
                You are an AI Assistant acting as a Business Analyst. Your primary responsibility is to help users interact with JIRA via an MCP server.
            
          
               \s""";
        return chatClientBuilder
                .defaultSystem(system)
                .defaultTools(new SyncMcpToolCallbackProvider(mcpSyncClient))
                .build();
    }
}