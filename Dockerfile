FROM openjdk:17-jdk-alpine
WORKDIR /app
LABEL authors="samsothy"
ARG JAR_FILE=target/D387_sample_code-0.0.2-SNAPSHOT.jar
COPY ${JAR_FILE} /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
EXPOSE 8080