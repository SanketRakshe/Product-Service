# Stage 1: Building the application
FROM maven:3.8.5-openjdk-17 AS build

# Seting the working directory inside the container
WORKDIR /app

# Copying the pom.xml and download dependencies first
COPY pom.xml .

# Downloading dependencies to cache them, allowing faster builds if dependencies haven't changed
RUN mvn dependency:go-offline -B

# Copying the source code into the working directory
COPY src ./src

# Building the application, skipping tests for faster builds
RUN mvn clean package -DskipTests

# Stage 2: Runing the application
FROM openjdk:17-jdk-slim

# Seting working directory
WORKDIR /app

# Copying the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Exposing the application port (8761 for Eureka)
EXPOSE 8000

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
