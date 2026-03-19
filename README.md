# 📚 Bookstore & Order Management System API

A professional-grade RESTful backend developed as part of a Full Stack Java Developer Internship. This project demonstrates a complete integration between an inventory management system and a transactional ordering engine.

---

## 🕒 Project Development Roadmap
This project was executed in a specific linear sequence to ensure data integrity and architectural stability:

1.  **Environment Setup**: Initialized Spring Boot with Spring Data JPA and MySQL Connector.
2.  **Schema Design**: Created the `books` table to handle inventory.
3.  **Inventory CRUD**: Developed REST endpoints for full book management (Create, Read, Update, Delete).
4.  **Relational Mapping**: Created the `orders` entity and established a `@ManyToOne` relationship with the `Book` entity.
5.  **Transaction Logic**: Implemented `@Transactional` service methods to handle stock deduction and order creation simultaneously.
6.  **API Documentation**: Integrated Swagger UI (OpenAPI 3.0) for live endpoint testing.

---

## 🛠 Tech Stack
* **Language**: Java 21
* **Framework**: Spring Boot 3.x
* **Database**: MySQL 8.0
* **ORM**: Hibernate / Spring Data JPA
* **Documentation**: Swagger UI / OpenAPI
* **Testing**: Postman

---

## 📡 API Reference & Documentation

### 1. Book Inventory Management
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/api/books` | Returns a list of all available books. |
| **GET** | `/api/books/{id}` | Returns details of a specific book. |
| **POST** | `/api/books` | Adds a new book to the inventory. |
| **PUT** | `/api/books/{id}` | Updates details (price, stock, etc.) of an existing book. |
| **DELETE** | `/api/books/{id}` | Permanently removes a book from the record. |

**Sample Book JSON Payload:**
```json
{
  "title": "The Pragmatic Programmer",
  "author": "David Thomas, Andrew Hunt",
  "genre": "Technology",
  "isbn": "978-0135957059",
  "price": 45.99,
  "description": "A journey to mastery in software engineering.",
  "stockQuantity": 50,
  "imageUrl": "[https://example.com/pragmatic.jpg](https://example.com/pragmatic.jpg)"
}


Method,Endpoint,Description
POST,/api/orders,Place an order using bookId and quantity params.


FULL STACK JAVA DEVELOPER INTERN
Custom Gem
FULL STACK JAVA DEVELOPER INTERN said
You're right—let's make this README truly "internship-grade" with all the technical details, field descriptions, and the exact sequence of how you built this from the ground up. This version is designed to show your mentor that you understand the full lifecycle of a Spring Boot application.

Here is the complete, high-detail Markdown source:

Markdown
# 📚 Bookstore & Order Management System API

A professional-grade RESTful backend developed as part of a Full Stack Java Developer Internship. This project demonstrates a complete integration between an inventory management system and a transactional ordering engine.

---

## 🕒 Project Development Roadmap
This project was executed in a specific linear sequence to ensure data integrity and architectural stability:

1.  **Environment Setup**: Initialized Spring Boot with Spring Data JPA and MySQL Connector.
2.  **Schema Design**: Created the `books` table to handle inventory.
3.  **Inventory CRUD**: Developed REST endpoints for full book management (Create, Read, Update, Delete).
4.  **Relational Mapping**: Created the `orders` entity and established a `@ManyToOne` relationship with the `Book` entity.
5.  **Transaction Logic**: Implemented `@Transactional` service methods to handle stock deduction and order creation simultaneously.
6.  **API Documentation**: Integrated Swagger UI (OpenAPI 3.0) for live endpoint testing.

---

## 🛠 Tech Stack
* **Language**: Java 21
* **Framework**: Spring Boot 3.x
* **Database**: MySQL 8.0
* **ORM**: Hibernate / Spring Data JPA
* **Documentation**: Swagger UI / OpenAPI
* **Testing**: Postman

---

## 📡 API Reference & Documentation

### 1. Book Inventory Management
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/api/books` | Returns a list of all available books. |
| **GET** | `/api/books/{id}` | Returns details of a specific book. |
| **POST** | `/api/books` | Adds a new book to the inventory. |
| **PUT** | `/api/books/{id}` | Updates details (price, stock, etc.) of an existing book. |
| **DELETE** | `/api/books/{id}` | Permanently removes a book from the record. |

**Sample Book JSON Payload:**
```json
{
  "title": "The Pragmatic Programmer",
  "author": "David Thomas, Andrew Hunt",
  "genre": "Technology",
  "isbn": "978-0135957059",
  "price": 45.99,
  "description": "A journey to mastery in software engineering.",
  "stockQuantity": 50,
  "imageUrl": "[https://example.com/pragmatic.jpg](https://example.com/pragmatic.jpg)"
}
2. Order Management (Integration Logic)
This module handles the core business logic. When an order is placed, the system automatically checks stock levels and updates the inventory.

Method	Endpoint	Description
POST	/api/orders	Place an order using bookId and quantity params.
Order Logic Flow:

Verify bookId exists in the database.

Compare requested quantity against stockQuantity.

If valid: Deduct stock, calculate totalPrice, and save the transaction.

If invalid: Return 400 Bad Request with an error message.

🚀 Installation & Setup
1. Database Configuration
Create a schema named bookstore_db in MySQL. Update your src/main/resources/application.properties:

Properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookstore_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
2. Running the Application
Clone the repository.

Import as a Maven Project in STS (Spring Tool Suite).

Run the project as a Spring Boot App.

3. Live API Testing (Swagger)
Access the interactive documentation once the server is running:
👉 http://localhost:8080/swagger-ui/index.html

📂 Project Structure
com.example.bookstore.model: Contains Book.java and Order.java (Entities).

com.example.bookstore.repository: JPA Repositories for DB communication.

com.example.bookstore.service: Business logic and Transactional management.

com.example.bookstore.controller: REST Controllers for handling HTTP requests.

