# Start from OpenJDK image with Maven installed
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy the project files
COPY . .

# Build the project
RUN mvn clean package -DskipTests

# Use a smaller image for running the app
FROM openjdk:21-jdk
WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=build /app/target/artgenerator-0.0.1-SNAPSHOT.jar app.jar

# Expose port and run
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
