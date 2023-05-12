FROM amazoncorretto:11-alpine-jdk
MAINTAINER JH
COPY target/apjoaquin-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
