FROM openjdk:17 AS build
WORKDIR /drools-poc

# Copy the Maven wrapper files
COPY .mvn/ .mvn/
COPY mvnw mvnw

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application using the Maven wrapper
RUN ./mvnw clean package -DskipTests

# === Stage 2: Run the app ===

FROM openjdk:17-jdk-slim
WORKDIR /drools-poc

# Copy the JAR file from the build stage
COPY --from=build /drools-poc/target/drools-poc-0.0.1-SNAPSHOT.jar app.jar


# Expose the port the application runs on
EXPOSE 8080
# Add startup delay
ENTRYPOINT ["/bin/sh", "-c", "sleep 30 && java -jar app.jar"]
