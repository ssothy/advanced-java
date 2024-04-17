FROM openjdk:17-jdk-alpine
WORKDIR /app
LABEL authors="samsothy"
COPY /Users/samsothy/IdeaProjects/d387-advanced-java/target/D387_sample_code-0.0.2-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080