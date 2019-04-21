FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD leaf-api-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS="-Xmx256m -Xms256m"
EXPOSE 8080
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT [ "sh", "-c", "java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar --spring.profiles.active=testing" ]