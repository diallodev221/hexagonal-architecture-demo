# 🚀 Bank Account Management System (Hexagonal Architecture)

## 🏗️ Overview
This project is a **Bank Account Management System** built using **Hexagonal Architecture (Ports & Adapters)** in **Spring Boot**. It demonstrates clean code practices, separation of concerns, and flexibility by decoupling the business logic from external dependencies.

## 🔥 Features
- ✅ Create a bank account
- ✅ Deposit money
- ✅ Withdraw money
- ✅ Retrieve account details
- ✅ Implements **Hexagonal Architecture**
- ✅ In-memory database (can be replaced with JPA, MongoDB, etc.)

## 🛠️ Architecture
The system follows **Hexagonal Architecture**, ensuring loose coupling between the core business logic and infrastructure layers.

### **Layers:**
1. **Core (Domain Layer)** → Business logic (BankAccount entity)
2. **Ports (Application Layer)** → Defines how external components interact (BankAccountRepository, BankAccountService)
3. **Adapters (Infrastructure Layer)** → Implements the ports (REST API, Database Adapter)

📌 **This allows easy switching of databases, APIs, or frameworks without affecting the business logic.**

## 📂 Project Structure
```
📦 bank-account-system
├── 📂 src/main/java/com/diallodev/bank_account_system/bank
│   ├── 📂 domain            # Core Business Logic (Entities)
│   ├── 📂 application       # Application Layer (Ports & Services)
│   ├── 📂 adapter          # Infrastructure Layer (Adapters)
│   │   ├── 📂 persistence  # Database Implementation
│   │   ├── 📂 web          # REST Controller
│   ├── 📜 BankApplication.java # Main Application Entry
├── 📜 README.md            # Documentation
├── 📜 pom.xml              # Maven Dependencies
```

## 🛠️ Technologies Used
- ☕ **Java 17**
- 🔥 **Spring Boot 3.x**
- 🌱 **Spring Web (REST API)**
- 💾 **In-Memory Storage (ConcurrentHashMap)**
- 🛠️ **Maven**

## 🚀 Getting Started

### 1️⃣ Clone the repository
```sh
git clone https://github.com/hexagonal-architecture-demo.git
cd hexagonal-architecture-demo
```

### 2️⃣ Build and Run
```sh
mvn spring-boot:run
```

### 3️⃣ Test the API Endpoints
Use **Postman** or **cURL** to interact with the API:

✅ **Create an Account**
```sh
curl -X POST "http://localhost:8080/accounts/123/create?initialBalance=1000"
```
✅ **Deposit Money**
```sh
curl -X POST "http://localhost:8080/accounts/123/deposit?amount=500"
```
✅ **Withdraw Money**
```sh
curl -X POST "http://localhost:8080/accounts/123/withdraw?amount=300"
```
✅ **Get Account Details**
```sh
curl -X GET "http://localhost:8080/accounts/123"
```

## 🏗️ Extending the Project
- **Switch Database**: Replace the in-memory repository with **JPA, PostgreSQL, MongoDB**
- **Add Security**: Integrate **Spring Security, JWT Authentication**
- **Introduce Event-Driven Architecture**: Use **Kafka or RabbitMQ** for async processing

## 🎯 Why Hexagonal Architecture?
✔️ **Separation of Concerns** – Business logic is independent of persistence and API
✔️ **Flexible** – Easily replace database, API type (REST, GraphQL), or messaging system
✔️ **Testable** – Business logic can be tested without a database
✔️ **Scalable** – Can be adapted to **microservices** or **monolithic** architectures

## 📜 License
This project is **open-source** under the **MIT License**.

## 🙌 Contributing
Feel free to **fork** this repo, submit PRs, or suggest improvements!

## 📢 Feedback
Have questions or suggestions? Open an **issue** or connect with me!

🚀 **Happy Coding!**

