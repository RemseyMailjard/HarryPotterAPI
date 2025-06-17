# 🧙‍♂️ Harry Potter Character API

A simple RESTful API built with Spring Boot to manage a database of Harry Potter characters.  
This project provides endpoints to list and create characters, connecting to a Microsoft SQL Server database.

---

## 📚 Table of Contents

- [✅ Features](#-features)
- [🛠️ Technology Stack](#️-technology-stack)
- [📋 Prerequisites](#-prerequisites)
- [🚀 Getting Started](#-getting-started)
  - [1. Clone the Repository](#1-clone-the-repository)
  - [2. Configure the Database](#2-configure-the-database)
  - [3. Build the Project](#3-build-the-project)
  - [4. Run the Application](#4-run-the-application)
- [🔌 API Endpoints](#-api-endpoints)
  - [🧙‍♂️ Get All Characters](#-get-all-characters)
  - [✍️ Create a Character](#️-create-a-character)
- [🗂️ Project Structure](#️-project-structure)
- [⚠️ Security Warning](#️-security-warning)

---

## ✅ Features

- List all characters from the database.
- Create new characters by sending a POST request.
- Built with Spring Boot and Spring Data JPA.
- Uses Maven Wrapper for a consistent build environment.

---

## 🛠️ Technology Stack

- Java 17  
- Spring Boot 3.5.0  
- Spring Web  
- Spring Data JPA  
- Hibernate  
- Microsoft SQL Server  
- Maven  

---

## 📋 Prerequisites

- Java Development Kit (JDK) 17 or later  
- Maven (or use the included Maven Wrapper `mvnw`)  
- An accessible Microsoft SQL Server with a `GTA.Characters` table  

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <your-repository-url>
cd remseymailjard-harrypotterapi
```

### 2. Configure the Database

Edit the file:  
`src/main/resources/application.properties`

Replace with your credentials:

```properties
spring.application.name=demo

# MS SQL Server Datasource Configuration
spring.datasource.url=jdbc:sqlserver://<your-db-host>:<port>;database=<your-db-name>;encrypt=true;trustServerCertificate=false;loginTimeout=30;
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

### 3. Build the Project

**Linux/macOS:**

```bash
chmod +x mvnw
./mvnw clean install
```

**Windows:**

```cmd
mvnw.cmd clean install
```

### 4. Run the Application

**Linux/macOS:**

```bash
./mvnw spring-boot:run
```

**Windows:**

```cmd
mvnw.cmd spring-boot:run
```

The application will be available at:  
http://localhost:8080

---

## 🔌 API Endpoints

**Base URL:** `/characters`

---

### 🧙‍♂️ Get All Characters

**GET** `/characters`

Returns all characters stored in the database.

#### Example Response

```json
[
  {
    "id": "c0a80121-7ac0-192b-817a-c08ab0a12345",
    "name": "Harry Potter",
    "house": "Gryffindor",
    "species": "human",
    "gender": "male",
    "dateOfBirth": "31-07-1980",
    "wizard": true,
    "ancestry": "half-blood",
    "eyeColour": "green",
    "hairColour": "black",
    "patronus": "stag",
    "hogwartsStudent": true,
    "hogwartsStaff": false,
    "actor": "Daniel Radcliffe",
    "alive": true,
    "image": "http://hp-api.herokuapp.com/images/harry.jpg"
  }
]
```

---

### ✍️ Create a Character

**POST** `/characters`

#### Request Body Example

```json
{
  "name": "Draco Malfoy",
  "house": "Slytherin",
  "species": "human",
  "gender": "male",
  "dateOfBirth": "1980-06-05",
  "wizard": true,
  "ancestry": "pure-blood",
  "eyeColour": "grey",
  "hairColour": "blonde",
  "patronus": null,
  "hogwartsStudent": true,
  "hogwartsStaff": false,
  "actor": "Tom Felton",
  "alive": true,
  "image": "http://hp-api.herokuapp.com/images/draco.jpg"
}
```

> ℹ️ A `DELETE /{id}` endpoint exists in the controller, but is currently commented out.

---

src
└── main
    ├── java/com/example/hpapi/demo
    │   ├── DemoApplication.java          # App entry point
    │   ├── controller/
    │   │   └── CharacterController.java  # API endpoints
    │   ├── dto/
    │   │   ├── CharacterResponseDto.java # DTO for API responses
    │   │   └── CreateCharacterRequestDto.java # DTO for creating characters
    │   ├── model/
    │   │   └── Character.java            # JPA Entity model
    │   ├── repository/
    │   │   └── CharacterRepository.java  # JPA Repository
    │   └── service/
    │       ├── CharacterMapper.java      # Maps between Entity and DTO
    │       └── CharacterService.java     # Business logic
    └── resources/
        └── application.properties        # Configuration
---

## ⚠️ Security Warning

Your current `application.properties` contains hardcoded credentials:

```properties
spring.datasource.username=gtareader
spring.datasource.password=StrongPass!2025
```

🔐 **This is not secure!** Use environment variables instead:

```properties
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

### Set environment variables before running the app:

```bash
export DB_USERNAME="your-secure-username"
export DB_PASSWORD="your-secure-password"
./mvnw spring-boot:run
```

### 🔒 Other secure alternatives:

- Spring Cloud Config  
- HashiCorp Vault  
- AWS Secrets Manager  
- Azure Key Vault  

---

🧙‍♂️ Built with wizardry and code by **Remsey Mailjard**

