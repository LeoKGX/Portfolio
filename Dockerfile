# Use a base image with Java 18 installed
FROM openjdk:18

WORKDIR /app

COPY ./portfolio.jar /app/portfolio.jar

EXPOSE 8080

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=release", "/app/portfolio.jar"]
