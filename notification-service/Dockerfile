FROM openjdk:11
EXPOSE  9191
ADD target/notification-service.jar notification-service.jar
ENTRYPOINT ["java","-jar","/notification-service.jar"]