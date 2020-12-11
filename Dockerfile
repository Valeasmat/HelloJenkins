FROM openjdk:8
EXPOSE 8080
ADD target/primer-proyecto-jenkins.jar primer-proyecto-jenkins.jar
ENTRYPOINT ["java","-jar","/primer-proyecto-jenkins.jar"]