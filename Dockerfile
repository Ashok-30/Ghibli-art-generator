# Use a base image with Java
FROM openjdk:21-jdk

# Set working directory
WORKDIR /app

# Copy the JAR file (replace with your actual jar name if different)
COPY target/artgenerator-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
