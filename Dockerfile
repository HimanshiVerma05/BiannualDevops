FROM  openjdk:8-jdk-alpine
RUN mkdir /app
WORKDIR /app
COPY target/devopsAssignment-0.0.1-SNAPSHOT.jar  /app
EXPOSE 8100 
ENTRYPOINT ["java","-jar","devopsAssignment-0.0.1-SNAPSHOT.jar"]