FROM openjdk:15-jdk


COPY ./server/target /my_server/

ENTRYPOINT ["java","-jar", "/my_server/server-1.0-SNAPSHOT.jar"]