FROM amazoncorretto:8-alpine-jdk
MAINTAINER EAG
COPY target/EAG-0.0.1-SNAPSHOT.jar eag-app.jar
ENTRYPOINT ["java", "-jar", "/eag-app.jar"]