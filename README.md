# Pace-Link Auth Service 🏃‍♂️💨

The **Auth Service** is the identity provider for the **Pace-Link** ecosystem. It acts as the gatekeeper for the platform, managing user lifecycles and issuing secure "passports" (JWTs) that allow users to interact with the Event and AI services.

---

## 🛠 Tech Stack
* **Language:** Java 17
* **Framework:** Spring Boot 3
* **Security:** Spring Security (Stateless configuration)
* **Persistence:** Spring Data JPA
* **Database:** PostgreSQL
* **Token Standard:** JWT (JSON Web Token) using the `jjwt` library

---

## 🚀 Key Features
* **Stateless Authentication:** No sessions are stored on the server. All identity information is encapsulated in a signed JWT.
* **Role-Based Access Control (RBAC):** Differentiates between `ROLE_USER` (Usual users) and `ROLE_ORGANIZER`.
* **Security First:** Implements **BCrypt** password hashing—no plain-text passwords ever touch the database.
* **Microservice Ready:** Provides a validation mechanism for downstream services (Event Service & AI Module).

---

## 🔌 API Endpoints

### 1. Register User
`POST /api/auth/register`

**Request Body:**
```json
{
  "username": "gym_bro_22",
  "password": "securePassword",
  "email": "alex@example.com",
  "role": "ROLE_ORGANIZER"
}
```

### 1. Login
`POST /api/auth/login`

**Request Body:**
```json
{
  "username": "gym_bro_99",
  "password": "securePassword123"
}
```