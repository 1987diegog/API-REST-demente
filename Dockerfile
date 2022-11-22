# First stage: complete build environment
FROM adoptopenjdk/maven-openjdk11 AS builder

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package jar
RUN mvn clean package

# Second stage: minimal runtime environment
# For Java 11
FROM adoptopenjdk/openjdk11:alpine-jre

# Port expose
EXPOSE 8080

# cd /opt/app
WORKDIR /opt/app

# Refer to Maven build -> finalName
ARG JAR_FILE=target/api-rest-demente-0.0.1-SNAPSHOT.jar

# copy jar from the first stage
COPY --from=builder ${JAR_FILE} /app/api-rest-demente.jar

CMD ["java", "-jar", "/app/api-rest-demente.jar"]
