FROM openjdk:26-ea-trixie AS build2
WORKDIR /app/backend
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","./app.jar"]