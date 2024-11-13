# Use the official Java image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file to the container
COPY build/libs/employee-0.0.1-SNAPSHOT.jar

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "employee-application.jar"]

# Expose the port (same as in TestContainers)
EXPOSE 8080
