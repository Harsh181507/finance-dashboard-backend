# 💼 Finance Dashboard Backend

## 🚀 Overview

This project is a backend system for a finance dashboard that manages financial records and provides role-based access to data and analytics.

It is designed with a focus on clean architecture, secure APIs, and maintainable backend logic as per the assignment requirements.

---

## 🌐 Base URL

http://localhost:8080

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
* Fields: amount, type, category, date, notes
* Filtering support: type, category, date range
* Soft delete implementation

---

### 📊 Dashboard APIs

* Total income
* Total expenses
* Net balance
* Structured JSON response

---

### 🔐 Security

* JWT-based authentication
* Stateless session management
* Role-based authorization (RBAC)
* Secured endpoints

---

### ⚡ Advanced Backend Features

* Pagination (`/records/paginated`)
* Sorting (`/records?sortBy=amount&direction=desc`)
* User-specific records (`/records/my`)
* Search (`/records/search?category=Salary`)
* Rate limiting (time-window based, per IP)
* Input validation
* Global exception handling
* Consistent API response format

---

## 📦 API Response Format

### Success

```json
{
  "status": "success",
  "data": {}
}
```

### Error

```json
{
  "status": "error",
  "message": "Error message",
  "timestamp": "..."
}
```

---

## 🐳 Running the Application

```bash
docker-compose up -d
./mvnw spring-boot:run
```

---

## 📘 Swagger UI

http://localhost:8080/swagger-ui.html

---

## 🔐 Authentication Flow

1. Create user → `/users`
2. Login → `/auth/login`
3. Use token: `Bearer <token>`
4. Access secured APIs

---

## 📁 Project Structure

controller → service → repository → entity → config → dto

---

## 🧠 Design Decisions

* Layered architecture
* DTO-based responses
* Database-level filtering
* Centralized exception handling
* Security-first approach

---

## 🔮 Future Improvements

* Refresh tokens
* Redis-based rate limiting
* Caching
* Advanced analytics

---

## 🧑‍💻 Author

Harsh Raj
