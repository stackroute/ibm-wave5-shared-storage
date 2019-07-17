FROM openjdk:11

WORKDIR /app


ADD ./target/warehouse-service-0.0.1-SNAPSHOT.jar ./warehouse-service-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java","-jar", "warehouse-service-0.0.1-SNAPSHOT.jar"]