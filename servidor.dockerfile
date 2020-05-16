FROM maven:3.6.3-openjdk-15


COPY ./server/target /my_server/

ENTRYPOINT ["java","-jar", "/my_server/server-1.0-SNAPSHOT.jar"]