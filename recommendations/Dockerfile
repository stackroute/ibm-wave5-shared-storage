FROM openjdk:11-jdk-stretch

WORKDIR /src/app/neo4j

ADD  target/myneo-0.0.1-SNAPSHOT.jar   /src/app/neo4j/myneo-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","myneo-0.0.1-SNAPSHOT.jar"]

