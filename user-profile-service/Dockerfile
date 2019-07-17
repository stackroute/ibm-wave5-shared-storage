FROM openjdk:11-jdk-stretch

WORKDIR /src/app/loginjar

ADD /target/user-profile-service-1.0-SNAPSHOT.jar  /src/app/jar/user-profile-service-1.0-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","user-profile-service-1.0-SNAPSHOT.jar"]