FROM amazoncorretto:8-alpine-jdk

MAINTAINER AbigailGuzman

COPY target/EAG-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080