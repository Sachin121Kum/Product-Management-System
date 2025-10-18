# Product Management System - Complete Suite

A comprehensive collection of Spring Boot applications for managing products and categories with different authentication approaches.

**Author:** Sachin Kumar  
**Email:** sk31817@gmail.com

## 📋 Overview

This repository contains two Spring Boot applications that demonstrate different approaches to product management and user authentication:

1. **Main Product App** - Database-backed authentication with user registration
2. **Basic Auth App** - In-memory authentication with pre-configured users

## 🚀 Technologies Used

- **Java 21** - Programming language
- **Spring Boot 3.5.6** - Application framework
- **Spring Security** - Authentication and authorization
- **Spring Data JPA** - Data persistence layer
- **MySQL 8.0** - Database
- **Lombok** - Reduces boilerplate code
- **SpringDoc OpenAPI 2.8.13** - API documentation
- **Maven** - Build tool and dependency management

## 📁 Project Structure

```
product/
├── product/                          # Main Product Application
│   ├── README.md                     # Detailed documentation
│   ├── pom.xml                       # Maven configuration
│   ├── src/                          # Source code
│   │   ├── main/java/com/product/product/
│   │   │   ├── controller/           # REST controllers
│   │   │   ├── entity/              # JPA entities
│   │   │   ├── dto/                 # Data Transfer Objects
│   │   │   ├── repository/          # Data access layer
│   │   │   ├── service/             # Business logic
│   │   │   ├── security/            # Security configuration
│   │   │   ├── mapper/              # Entity-DTO mappers
│   │   │   ├── exception/           # Exception handling
│   │   │   └── ProductApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── target/                       # Compiled classes
├── product - Basic Auth App/         # Basic Auth Application
│   ├── README.md                     # Detailed documentation
│   ├── pom.xml                       # Maven configuration
│   ├── Spring Boot.postman_collection.json  # Postman collection
│   ├── src/                          # Source code
│   │   ├── main/java/com/product/product/
│   │   │   ├── controller/           # REST controllers
│   │   │   ├── entity/              # JPA entities
│   │   │   ├── dto/                 # Data Transfer Objects
│   │   │   ├── repository/          # Data access layer
│   │   │   ├── service/             # Business logic
│   │   │   ├── security/            # Security configuration
│   │   │   ├── mapper/              # Entity-DTO mappers
│   │   │   ├── exception/           # Exception handling
│   │   │   └── ProductApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── target/                       # Compiled classes
└── README.md                         # This file
```

## 🔄 Applications Comparison

| Feature | Main Product App | Basic Auth App |
|---------|------------------|----------------|
| **Authentication** | Database-backed | In-memory |
| **User Management** | Dynamic registration | Pre-configured users |
| **User Storage** | MySQL database | Memory only |
| **User Registration** | ✅ Available | ❌ Not available |
| **User Controller** | ✅ Present | ❌ Not present |
| **User Entity** | ✅ Present | ❌ Not present |
| **Setup Complexity** | Medium | Low |
| **Production Ready** | ✅ Yes | ⚠️ Development only |
| **Scalability** | ✅ High | ❌ Limited |

## 🚀 Quick Start

### Prerequisites
- Java 21 or higher
- Maven 3.6+
- MySQL 8.0+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Database Setup
```sql
-- Create database for both applications
CREATE DATABASE mydb;
```

### Running the Applications

#### Option 1: Main Product App (Database Authentication)
```bash
cd product
mvn spring-boot:run
```
- **Port:** 8090
- **Features:** User registration, database authentication
- **Documentation:** [product/README.md](product/README.md)

#### Option 2: Basic Auth App (In-Memory Authentication)
```bash
cd "product - Basic Auth App"
mvn spring-boot:run
```
- **Port:** 8090
- **Features:** Pre-configured users, simple setup
- **Documentation:** [product - Basic Auth App/README.md](product%20-%20Basic%20Auth%20App/README.md)

## 🔐 Authentication Methods

### Main Product App - Database Authentication
- **User Registration:** `POST /user`
- **Authentication:** HTTP Basic Auth with database validation
- **User Storage:** Persistent in MySQL
- **Password Security:** BCrypt encryption

### Basic Auth App - In-Memory Authentication
- **Pre-configured Users:**
  - `admin` / `admin` (ADMIN role)
  - `seller` / `seller` (SELLER role)
- **Authentication:** HTTP Basic Auth with in-memory validation
- **User Storage:** Temporary (lost on restart)

## 📚 API Documentation

Both applications provide interactive API documentation:

- **Swagger UI:** http://localhost:8090/swagger-ui.html
- **OpenAPI JSON:** http://localhost:8090/v3/api-docs

## 🔧 Common API Endpoints

Both applications share the same core API structure:

### Products
- `GET /api/products` - Get all products (public)
- `POST /api/products` - Create product (authenticated)
- `GET /api/products/{id}` - Get product by ID (public)
- `PUT /api/products/{id}` - Update product (authenticated)
- `DELETE /api/products/{id}` - Delete product (authenticated)

### Categories
- `GET /api/categories` - Get all categories (public)
- `POST /api/categories` - Create category (authenticated)
- `GET /api/categories/{id}` - Get category by ID (public)
- `PUT /api/categories/{id}` - Update category (authenticated)
- `DELETE /api/categories/{id}` - Delete category (authenticated)

## 🎯 Use Cases

### Choose Main Product App When:
- Building a production application
- Need dynamic user registration
- Require persistent user data
- Planning to scale the application
- Need role-based access control with database storage

### Choose Basic Auth App When:
- Quick prototyping or demos
- Simple development environment
- Don't need user registration
- Want minimal setup complexity
- Testing API functionality

## 🛠️ Development Workflow

### 1. Database Setup
1. Install and configure MySQL 8.0
2. Create `mydb` database
3. Update connection details in `application.properties`

### 2. Application Selection
1. **For Production:** Use Main Product App
2. **For Development/Testing:** Use Basic Auth App

### 3. Running and Testing
1. Start the chosen application
2. Access Swagger UI for API testing
3. Use provided Postman collection (Basic Auth App)
4. Test authentication and CRUD operations

## 📦 Deployment

### Production Deployment
- Use **Main Product App** for production
- Configure proper database credentials
- Set up environment variables for sensitive data
- Enable proper logging and monitoring

### Development/Testing
- Use **Basic Auth App** for quick testing
- No database setup required for basic functionality
- Perfect for CI/CD pipelines and automated testing

## 🧪 Testing

Both applications include comprehensive test suites:

```bash
# Test Main Product App
cd product
mvn test

# Test Basic Auth App
cd "product - Basic Auth App"
mvn test
```

## 📝 Additional Resources

- **Main Product App Documentation:** [product/README.md](product/README.md)
- **Basic Auth App Documentation:** [product - Basic Auth App/README.md](product%20-%20Basic%20Auth%20App/README.md)
- **Postman Collection:** [product - Basic Auth App/Spring Boot.postman_collection.json](product%20-%20Basic%20Auth%20App/Spring%20Boot.postman_collection.json)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License.

## 🆘 Support

For support and questions:
- **Email:** sk31817@gmail.com
- **Author:** Sachin Kumar
- Check individual application README files for specific guidance
- Review application logs for debugging
- Ensure proper database connectivity and configuration

---

**Note:** Both applications run on port 8090 by default. If running both simultaneously, change the port in one of the `application.properties` files to avoid conflicts.
