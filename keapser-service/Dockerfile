FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
MAINTAINER chrys exaucet

ENV APP_ROOT /app
ARG JAR_FILE=target/*.jar

RUN addgroup -S keapser && adduser -S keapser-manager -G keapser
RUN   apk add --update  curl \
    &&  rm -rf /var/lib/apt/lists/*
RUN mkdir ${APP_ROOT}
WORKDIR ${APP_ROOT}
COPY ${JAR_FILE} ${APP_ROOT}/app.jar
USER keapser-manager:keapser
VOLUME /tmp
ENTRYPOINT ["java"]
CMD ["java","-jar","app.jar"]