FROM openjdk:11-jdk-alpine
MAINTAINER chrys exaucet

ENV APP_ROOT /app
ARG JAR_FILE=target/*.jar

RUN addgroup -S keapser && adduser -S keapser-manager -G keapser
USER keapser-manager:keapser

RUN apt-get update \
    && apt-get install -y curl \
    && rm -rf /var/lib/apt/lists/*

RUN mkdir ${APP_ROOT}
WORKDIR ${APP_ROOT}
COPY ${JAR_FILE} ${APP_ROOT}/app.jar

VOLUME /tmp
ENTRYPOINT ["java","-jar","app.jar"]