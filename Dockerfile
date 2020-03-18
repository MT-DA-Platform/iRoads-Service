FROM java:8-jdk-alphine

COPY target/iroads-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "iroads-0.0.1-SNAPSHOT.jar"]