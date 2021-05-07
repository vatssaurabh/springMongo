How to run springMongo spring boot project-

Prerequisite-
1) Jdk 11 or above
2) Maven
3) Running MongoDB
4) Below properties in application.properties
spring.data.mongodb.database=userdb
spring.data.mongodb.port=27017

How to run this project
1) Can Run on any IDE(mvn clean install this includes excecution of test cases as well)
2) java -jar command after executing mvn clean install under(springMongo pom is here) via cmd
   a. Jar file can be found after executing mvn clean install
   \springMongo\target\springMongo-0.0.1-SNAPSHOT.jar
    java -jar springMongo-0.0.1-SNAPSHOT.jar

2) Swagger API can be accessed localhost:8080/swagger-ui.html