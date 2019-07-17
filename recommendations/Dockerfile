FROM openjdk:11

WORKDIR /app


ADD ./target/recommendations-0.0.1-SNAPSHOT.jar ./recommendations-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java","-jar", "recommendations-0.0.1-SNAPSHOT.jar"]