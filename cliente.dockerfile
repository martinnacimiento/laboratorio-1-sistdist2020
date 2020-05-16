FROM maven:3.6.3-openjdk-15

COPY ./app/target /my_app/

ENTRYPOINT ["java","-jar", "/my_app/app-1.0-SNAPSHOT.jar"]