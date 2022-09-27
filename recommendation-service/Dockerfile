FROM openjdk:11
EXPOSE  8282
ADD target/recommendation-service.jar recommendation-service.jar
ENTRYPOINT ["java","-jar","/recommendation-service.jar"]