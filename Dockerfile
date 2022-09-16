FROM openjdk:11
ADD target/micro-streaming-analytics-0.0.1-SNAPSHOT.jar docker-app.jar
ENTRYPOINT ["java", "-jar", "docker-app.jar"]