FROM openjdk:17
LABEL maintainer="maliyeva123"

WORKDIR /app
ADD build/libs/mediamingle-0.0.1-SNAPSHOT.jar mediamingle.jar

ENTRYPOINT ["java", "-jar", "mediamingle.jar"]