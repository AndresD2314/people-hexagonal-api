FROM openjdk:17-jdk-alpine
LABEL authors="Andres"
ARG JAR_FILE=target/people-hexagonal-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_hexagonal_people.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app_hexagonal_people.jar"]