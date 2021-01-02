FROM openjdk:11-jdk-alpine
MAINTAINER chrys exaucet

RUN addgroup -S keapser && adduser -S keapser-manager -G keapser
USER keapser-manager:keapser

RUN apt-get update \
    && apt-get install -y curl \
    && rm -rf /var/lib/apt/lists/*

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} keapser-service.jar

VOLUME /tmp
ENTRYPOINT ["java","-jar","/keapser-service.jar"]