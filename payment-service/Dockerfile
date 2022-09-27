FROM openjdk:11
EXPOSE  9090
ADD target/payment-service.jar payment-service.jar
ENTRYPOINT ["java","-jar","/payment-service.jar"]