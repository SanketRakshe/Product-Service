# Product-Service

The Product Service microservice provides product information, including details such as loan types, eligibility criteria, and loan limits.

## Getting Started

This service is developed using Spring Boot and provides endpoints for retrieving product information. It registers with Eureka for service discovery and uses the Config Server for configuration.

### Prerequisites

- Java 17
- Maven
- Docker (optional)

### Local Setup Without Docker

1. **Clone the repository**:
    ```bash
    git clone <repository-url>
    cd product-service
    ```

2. **Configure application properties**: Update `src/main/resources/application.properties` to include any necessary environment-specific settings:
    ```properties
    spring.application.name=product-service
    server.port=8000
    ```

3. **Build the application**:
    ```bash
    mvn clean install
    ```

4. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

### Local Setup With Docker

1. **Build the Docker image**:
    ```bash
    docker build -t product-service .
    ```

2. **Run the Docker container**:
    ```bash
    docker run -p 8000:8000 product-service
    ```

Your Product Service should now be available at `http://localhost:8000`.
