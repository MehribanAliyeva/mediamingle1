FROM openjdk:11
LABEL maintainer="maliyeva123"
COPY target/musicapp-demo-0.0.1-SNAPSHOT.jar musicapp-demo.jar
ENTRYPOINT ["java", "-jar", "musicapp-demo.jar"]