FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/*.jar demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar", "--server.port=8080"]
