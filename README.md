# Business Analyst AI Assistant

A Spring AI-powered client application that demonstrates how to create AI assistants for business analysts by connecting to a Jira MCP (Model Context Protocol) server. This project serves as a learning example of how to leverage Spring AI to create MCP servers and clients that can effectively communicate with LLMs through defined tools.

## Overview

This project is a client application that connects to a Jira MCP server, enabling AI assistants to interact with Jira through a standardized protocol. It demonstrates the practical implementation of:

- Spring AI integration
- MCP (Model Context Protocol) client implementation
- Server-Sent Events (SSE) communication
- Integration with Jira API through MCP server (developed in a separate project : https://github.com/AzamMehr/jira-mcp-server)

## Prerequisites

- Java 21 or later
- Gradle
- Access to a running Jira MCP server (see [jira-mcp-server](https://github.com/AzamMehr/jira-mcp-server))

## Dependencies

The project has a clear dependency on the Jira MCP server. Key dependencies include:

- Spring AI
- Spring Boot
- Spring WebFlux
- Spring AI Core

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/ba/copilot/
│   │       ├── config/
│   │       ├── controller/
│   │       ├── model/
│   │       └── service/
│   └── resources/
│       └── application.properties
```

## Configuration

Configure the application using environment variables or application.properties:

```properties
# MCP Server Configuration
mcp.server.url=${MCP_SERVER_URL}

# Application Configuration
server.port=8080
```

## Building the Project

```bash
./gradlew build
```

## Running the Application

```bash
./gradlew bootRun
```

## Features

- Connects to Jira MCP server using SSE communication
- Enables AI assistants to interact with Jira through defined tools
- Demonstrates Spring AI integration with MCP protocol
- Provides a learning example of MCP server-client architecture

## Learning Objectives

This project serves as a practical example of:

1. Creating MCP servers using Spring AI
2. Implementing MCP clients that connect to these servers
3. Enabling LLMs to use tools defined in MCP servers
4. Implementing SSE-based communication between client and server

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

## License

This project is licensed under the Apache License 2.0 - see the LICENSE file for details.

## Acknowledgments

- [jira-mcp-server](https://github.com/AzamMehr/jira-mcp-server) - The MCP server implementation this client connects to
- Spring AI team for providing the framework
- Atlassian for Jira API 