# Use a base image with Java 17 and Maven installed
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /full

COPY . /full

RUN mvn dependency:go-offline -B

# RUN mvn package -X -DskipTests -e

ADD target/full-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "app.jar"]



# # Vaadin Docs
# FROM openjdk:17

# WORKDIR /full
# COPY target/*.jar /full/app.jar
# EXPOSE 8090
# ENTRYPOINT [ "java" ,"-jar", "app.jar" ]