# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

# Refer to Maven build -> finalName
ARG JAR_FILE=target/api-rest-demente-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} /app/api-rest-demente.jar

# java -jar /opt/app/api-rest-demente.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/api-rest-demente.jar"]

###########################################################
########### Build Image and Run Docker commands ###########
###########################################################
# docker build -t api-rest-demente-v1.0.0 .
# docker run -it -p 8080:8080 api-rest-demente-v1.0.0
###########################################################