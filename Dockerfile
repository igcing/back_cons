## IMAGE FOR BUILD ##
FROM maven:3.6.3-jdk-11 AS builder

COPY src /build/src
COPY pom.xml /build

WORKDIR /build

RUN mvn -B package -Dmaven.test.skip=true -Djar.name=app

## IMAGE FOR DEPLOY ##
FROM adoptopenjdk/openjdk11-openj9:alpine-jre

ARG name=app
ARG version
ARG build

COPY --from=builder /build/target/app.jar /opt/${name}/${version}/

WORKDIR /opt/${name}/${version}

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]