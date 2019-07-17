FROM openjdk:11

WORKDIR /app


ADD ./target/config-server-0.0.1-SNAPSHOT.jar ./config-server-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java","-jar", "config-server-0.0.1-SNAPSHOT.jar"]