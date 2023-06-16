# Use a base image with Java 8 installed
FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-18-jdk -y
COPY . .

WORKDIR /app
#RUN mvn dependency:go-offline

#COPY src/ /app/src/
#RUN mvn package

# Expose the port your application is listening on (replace 8080 with your actual port number)
EXPOSE 8080

# Copy the JAR file into the container
COPY ./out/artifacts/portfolio_jar/portfolio.jar /app/portfolio.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

# Define the command to run your application
#CMD ["java", "-jar", "/app/portfolio.jar"]
