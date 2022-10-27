# syntax=docker/dockerfile:1

FROM openjdk:16-alpine3.13
WORKDIR /syte
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src
EXPOSE 2222:2222
RUN ./mvnw dependency:go-offline
CMD ["./mvnw", "spring-boot:run"]