# BloggerBox Backend Application

This is the backend application for BloggerBox, a platform to manage blog categories and posts.

## Project Structure
- **Models**: `Category` and `Post` entities using JPA.
- **Controllers**: REST APIs for Categories (`/v1/categories`) and Posts (`/v1/posts`).
- **Services**: Business logic to manage categories and posts.
- **Repositories**: JPA repositories for data persistence.

## Technologies Used
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL** / **H2 Database**
- **OpenAPI / Swagger** for documentation.

## Running the Application

### 1. Database Configuration
By default, the application is configured to use a remote PostgreSQL on Supabase.
If you want to run it locally without an external database, you can use H2 (in-memory).

To use H2, update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

### 2. Launch
Run the application using your IDE or via command line:
```bash
./mvnw spring-boot:run
```

### 3. API Documentation
Once the app is running, access the Swagger UI:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Current Status
- Backend is fully functional with JPA persistence.
- REST endpoints are implemented for categories and posts.
- Global exception handling is in place.
