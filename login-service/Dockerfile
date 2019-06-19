FROM openjdk:11-jdk-stretch

WORKDIR /src/app/loginjar

ADD /target/LoginService-0.0.1-SNAPSHOT.jar  /src/app/loginjar/LoginService-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","LoginService-0.0.1-SNAPSHOT.jar"]