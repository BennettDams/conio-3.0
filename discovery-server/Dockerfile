FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ./target/discovery-server-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/discovery-server-0.0.1-SNAPSHOT.jar"] discovery-server