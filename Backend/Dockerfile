FROM openjdk:24-jdk AS build2
WORKDIR /app/backend
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","./app.jar"]