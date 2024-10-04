FROM openjdk:21
LABEL authors="MoGreene"

COPY ./build/libs/boot-jar-0.0.1-SNAPSHOT.jar /usr/local/bin/app.jar
RUN chmod +x /usr/local/bin/app.jar

CMD ["java", "-jar", "/usr/local/bin/app.jar"]