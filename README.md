# 💼 Finance Dashboard Backend

## 🚀 Overview

This project is a backend system for a finance dashboard that manages financial records and provides role-based access to data and analytics.

It is designed with a focus on clean architecture, secure APIs, and maintainable backend logic as per the assignment requirements.

---

## 🌐 Base URL

```
http://localhost:8080
```

---

## 🧱 Tech Stack

* Java Spring Boot
* Spring Security (JWT Authentication)
* MySQL (Dockerized)
* JPA / Hibernate
* Swagger (OpenAPI)
* Lombok

---

## 🎯 Core Features

### 👤 User & Role Management

* Create and manage users
* Assign roles:

  * **ADMIN** → Full access
  * **ANALYST** → View records + insights
  * **VIEWER** → Dashboard only
* Active/inactive user support
* Role-based access control using `@PreAuthorize`

---

### 💰 Financial Records Management

* Create, update, delete records
* Each record is linked to the authenticated user
* Fields:

  * Amount
  * Type (INCOME / EXPENSE)
  * Category
  * Date
  * Notes
* Filtering support:

  * By type
  * By category
  * By date range
* Soft delete implementation

---

### 📊 Dashboard APIs

* Total income
* Total expenses
* Net balance
* Recent transactions
* Structured JSON response for better API design

---

### 🔐 Security

* JWT-based authentication
* Stateless session management
* Role-based authorization (RBAC)
* Secured endpoints using `@PreAuthorize`

---

### ⚡ Advanced Backend Features

* Pagination (`/records/paginated`)
* Sorting support (`/records?sortBy=amount&direction=desc`)
* User-specific records (`/records/my`)
* Search support (`/records/search?category=Salary`)
* Input validation (`@Valid`, constraints)
* Global exception handling (structured error responses)
* Consistent API response format
* Password encryption (BCrypt)
* Optimized database queries (no unnecessary in-memory filtering)

---

## 📦 API Response Format

### ✅ Success

```json
{
  "status": "success",
  "data": {}
}
```

### ❌ Error

```json
{
  "status": "error",
  "message": "Error message",
  "timestamp": "2026-04-02T12:00:00"
}
```

---

## 🐳 Running the Application (Docker Setup)

This project uses **Docker for database setup**, making it easy to run locally without manual configuration.

### 1️⃣ Start MySQL using Docker

```bash
docker-compose up -d
```

---

### 2️⃣ Run the Spring Boot Application

```bash
./mvnw spring-boot:run
```

---

### 3️⃣ Access the Application

```
http://localhost:8080
```

---

## 📘 Swagger UI (API Testing)

```
http://localhost:8080/swagger-ui.html
```

Use Swagger to:

* Explore APIs
* Test endpoints
* Add JWT token via **Authorize 🔐 button**

---

## 🔐 Authentication Flow

1. Create a user via `/users`
2. Login using `/auth/login` to receive JWT token
3. Click **Authorize 🔐** in Swagger
4. Enter: `Bearer <your-token>`
5. Access secured endpoints

---

## 🧪 Testing Flow

1. Create an ADMIN user
2. Login → get JWT token
3. Add token in Authorization (Bearer Token)
4. Access secured APIs

---

## 🧪 Example API Request

### Create User

**POST /users**

```json
{
  "name": "Admin",
  "email": "admin@test.com",
  "password": "1234",
  "role": "ADMIN"
}
```

---

## 🔑 Role-Based Access Summary

| Role    | Permissions                               |
| ------- | ----------------------------------------- |
| ADMIN   | Full access (users + records + dashboard) |
| ANALYST | View records + analytics                  |
| VIEWER  | Dashboard only                            |

---

## 📁 Project Structure

* controller → API endpoints
* service → business logic
* repository → database access
* entity → data models
* config → security & configurations
* dto → response objects

---

## 🧠 Assumptions

* First user (ADMIN) is created without authentication for initial setup
* JWT is used for stateless authentication
* MySQL runs locally via Docker
* Focus is on clean backend design and logical structure

---

## 📈 Design Decisions

* Layered architecture (Controller → Service → Repository)
* DTO-based responses for clarity and consistency
* Database-level filtering for performance
* Centralized exception handling
* Security-first approach using JWT + RBAC

---

## 🔮 Future Improvements

* Refresh tokens for authentication
* Redis caching for performance optimization
* Advanced analytics (monthly trends, category insights)
* Audit logging for tracking user actions

---

## 🧑‍💻 Author

**Harsh Raj**
