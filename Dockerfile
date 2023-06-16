# Use a base image with Java 18 installed
FROM openjdk:18 AS build

VOLUME ["/home"]

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=release", "/home/portfolio.jar"]
