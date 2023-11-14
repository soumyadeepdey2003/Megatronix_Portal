FROM openjdk:17
#EXPOSE 5000
#WORKDIR /app
#ADD target/megatronix_portal.jar /app/megatronix_portal.jar
#ENTRYPOINT ["java","-jar","/megatronix_portal.jar"]
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} megatronix_portal.jar
ENTRYPOINT ["java","-jar","/megatronix_portal.jar"]

