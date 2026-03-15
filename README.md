# 🚖 Uber Backend – Ride Booking System

Uber Backend is a ride-hailing backend service that manages **user authentication, ride requests, drivers, and ride lifecycle**.
The project is built using **Spring Boot** and **PostgreSQL** and exposes REST APIs for riders and drivers.

---

## 🟢 API Documentation

You can test the APIs using **Postman**.

Main API categories:

* Authentication APIs
* Rider APIs
* Driver APIs
* Ride Management APIs

---

## 🏗 Project Structure

```
uber-backend/
└── src/main/java/com/ravi/uber
    ├── config/            # Security and application configurations
    ├── controllers/       # REST API controllers
    ├── dto/               # Data Transfer Objects
    ├── entities/          # JPA Entities
    ├── enums/             # Enums (Role, RideStatus)
    ├── repositories/      # Spring Data JPA repositories
    ├── security/          # JWT authentication and filters
    ├── services/          # Service interfaces
    ├── servicesImpl/      # Service implementations
    └── utils/             # Utility classes
```

---

## 🚀 Key Features

### 🔐 Authentication & Authorization

* User signup and login
* JWT-based authentication
* Role-based access (Rider / Driver)

### 🚗 Ride Management

* Riders can request rides
* Drivers can accept rides
* Drivers can start and complete rides
* Ride status tracking

### 📊 Ride History

* Riders can view ride history
* Drivers can view completed rides

---

## 🛠 Tech Stack

**Backend Framework**

* Spring Boot

**Security**

* Spring Security
* JWT Authentication

**Database**

* PostgreSQL
* Spring Data JPA

**Build Tool**

* Maven

**Other Libraries**

* Lombok
* Hibernate Validator

---

## 📝 Environment Setup

### Prerequisites

* Java 21
* Maven 3.8+
* PostgreSQL
* Postman (optional)

---

### Application Configuration

Configure `application.properties`:

```
spring.application.name=uber

spring.datasource.url=jdbc:postgresql://localhost:5432/uber
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always
spring.sql.init.data-locations=classpath:data.sql

server.port=8080
```

---

## 🎉 Getting Started

### 1 Clone Repository

```
git clone https://github.com/ravi2552/uber-backend-springboot.git
cd uber-backend-springboot
```

### 2 Build Project

```
mvn clean install
```

### 3 Run Application

```
mvn spring-boot:run
```

Application will start at:

```
http://localhost:8080
```

---

## 📮 API Endpoints

### Authentication

```
POST /auth/signup
POST /auth/login
POST /auth/refresh
POST /auth/onBoardNewDriver/{userId}
```

### Rider APIs

```
POST /riders/requestRide
POST /riders/cancelRide/{rideId}
POST /riders/rateDriver
GET  /riders/getMyProfile
GET  /riders/getMyRides
```

### Driver APIs

```
POST /drivers/acceptRide/{rideRequestId}
POST /drivers/startRide/{rideRequestId}
POST /drivers/endRide/{rideId}
POST /drivers/cancelRide/{rideId}
POST /drivers/rateRider
GET  /drivers/getMyProfile
GET  /drivers/getMyRides
```

[//]: # (---)

[//]: # ()
[//]: # (## 🧪 Running Tests)

[//]: # ()
[//]: # (Run tests using:)

[//]: # ()
[//]: # (```)

[//]: # (mvn test)

[//]: # (```)

---

## 👨‍💻 Author

**Ravi Pandey**
