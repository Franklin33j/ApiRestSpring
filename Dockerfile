FROM openjdk:17
ADD target/ensayo-0.0.1-SNAPSHOT.jar /app/ensayo.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "ensayo.jar"]