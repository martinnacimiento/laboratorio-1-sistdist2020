FROM openjdk:15-jdk

COPY ./app/target /my_app/

ENTRYPOINT ["java","-jar", "/my_app/app-1.0-SNAPSHOT.jar"]