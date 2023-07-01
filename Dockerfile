# Stage 1: Build the application
FROM azul/zulu-openjdk-alpine:17-latest AS builder

WORKDIR /app

# Copy the source code and build files
COPY . .

# Build the application
RUN ./gradlew clean assemble

# Stage 2: Run the application
FROM azul/zulu-openjdk-alpine:17-latest

WORKDIR /app

# Copy the built application from the builder stage
COPY --from=builder /app/build/libs/*.jar ./accountservice.jar

# Expose the default port for the Spring Boot application
EXPOSE 8080
EXPOSE 8086

# Run the Spring Boot application
CMD ["java", "-jar", "accountservice.jar"]
