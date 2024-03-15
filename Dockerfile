# Stage 1: Build the application
FROM azul/zulu-openjdk-alpine:17 AS builder

WORKDIR /app

# Copy the source code and build files
COPY . .

# Build the application
RUN ./gradlew clean assemble

# Stage 2: Run the application
FROM azul/zulu-openjdk-alpine:17

WORKDIR /app

# Copy the built application from the builder stage
COPY --from=builder /app/build/libs/*.jar ./accountservice.jar

# Expose the default port for the Spring Boot application
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "accountservice.jar"]
