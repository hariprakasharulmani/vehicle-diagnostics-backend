# Use lightweight OpenJDK 17
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Give permission to maven wrapper
RUN chmod +x mvnw

# Build the project (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "target/vehicle-diagnostics-0.0.1-SNAPSHOT.jar"]
