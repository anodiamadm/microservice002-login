FROM openjdk:11
EXPOSE 8445
ADD target/microservice002-login.jar microservice002-login.jar
ENTRYPOINT ["java","-jar","/microservice002-login.jar"]