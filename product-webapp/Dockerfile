FROM openjdk:11
EXPOSE  4200
ADD target/product-webapp.jar product-webapp.jar
ENTRYPOINT ["java","-jar","/product-webapp.jar"]