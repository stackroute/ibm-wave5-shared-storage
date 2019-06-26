FROM openjdk:11-jdk-stretch

WORKDIR /src/app/loginjar

ADD /target/user-service-0.0.1-SNAPSHOT.jar  /src/app/jar/user-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","user-service-0.0.1-SNAPSHOT.jar"]