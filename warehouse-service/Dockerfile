FROM openjdk:11-jdk-stretch

WORKDIR /src/app/warehouse

ADD /target/warehouse-service-0.0.1-SNAPSHOT.jar  /src/app/warehouse/warehouse-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","warehouse-service-0.0.1-SNAPSHOT.jar"]