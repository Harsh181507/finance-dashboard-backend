# 💼 Finance Dashboard Backend

## 🚀 Overview

This project is a backend system for a finance dashboard that manages financial records and provides role-based access to data and analytics.

It is designed with a focus on clean architecture, secure APIs, and maintainable backend logic as per the assignment requirements.

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

---

### 🔐 Security

* JWT-based authentication
* Stateless session management
* Role-based authorization (RBAC)
* Secured endpoints

---

### ⚡ Advanced Backend Features

* Pagination (`/records/paginated`)
* Input validation (`@Valid`, constraints)
* Global exception handling
* Consistent API response format
* Password encryption (BCrypt)
* Optimized database queries (no unnecessary in-memory filtering)

---

## 📦 API Response Format

All successful responses follow:

```json
{
  "status": "success",
  "data": {}
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

```plaintext
http://localhost:8080
```

---

### 📘 Swagger UI (API Testing)

```plaintext
http://localhost:8080/swagger-ui.html
```

Use Swagger to:

* Explore APIs
* Test endpoints
* Add JWT token via **Authorize 🔐 button**

---

## 🧪 Testing Flow

1. Create an ADMIN user
2. Login → get JWT token
3. Add token in Authorization (Bearer Token)
4. Access secured APIs

---

## 🔑 Role-Based Access Summary

| Role    | Permissions                               |
| ------- | ----------------------------------------- |
| ADMIN   | Full access (users + records + dashboard) |
| ANALYST | View records + analytics                  |
| VIEWER  | Dashboard only                            |

---

## 🧠 Assumptions

* First user (ADMIN) is created without authentication
* JWT is used for stateless authentication
* MySQL runs locally via Docker
* Focus is on clean backend design and logical structure

---

## 📈 Design Decisions

* Layered architecture (Controller → Service → Repository)
* DTO-based responses for clarity
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
