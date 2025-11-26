# Spring Boot Ticketing REST API

Small REST API **backend-only** application for managing users, events, and tickets.  
Can be tested using Postman or any other HTTP client.

### Features
- **Users**: CRUD operations, DTOs, validation, unit tests
- **Events**: CRUD operations  
- **Tickets**: CRUD operations + `buy` endpoint to purchase tickets  
- **Global exception handling** for consistent error responses  

### Technologies
- Java
- Spring Boot (REST)
- Spring Data JPA / Hibernate  
- PostgreSQL
- Docker for DB

### Example Endpoints
- `POST /users` – create user  
- `GET /users` – list users  
- `GET /users/{id}` – get user by ID  
- `POST /events` – create event  
- `GET /events` – list events  
- `POST /tickets/buy?userId=1&eventId=1&seat=B1` – buy ticket  
- `GET /tickets` – list tickets  
