# Use the official openjdk 18 image as the base image
FROM openjdk:18

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY /target/portfolio-0.0.1-SNAPSHOT.jar /app/portfolio-0.0.1-SNAPSHOT.jar

# Expose the port your application is listening on (replace 8080 with your actual port number)
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "/app/portfolio-0.0.1-SNAPSHOT.jar"]
