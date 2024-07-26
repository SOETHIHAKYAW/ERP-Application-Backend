# Backend Setup Guide

## Description

This document provides instructions for setting up and running the backend for the project.

## Prerequisites

Before setting up the backend, ensure you have the following installed:

- **Java 17** or later
- **Gradle 8** or later (if not using the Gradle wrapper provided)

## Database

### Development and Testing

For development and testing purposes, this project uses the **H2 database**, which is an in-memory database. H2 is convenient for development due to its lightweight nature and ease of setup.

### Configuration

The H2 database is configured in `src/main/resources/application.properties`:

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
