# Use a base image with Java 18 installed
FROM openjdk:18 AS build

RUN apt-get install -y tzdata

ENV tz America/Buenos_Aires

VOLUME ["/home"]

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=release", "/home/portfolio.jar"]
