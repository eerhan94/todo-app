FROM openjdk:11-jdk
MAINTAINER Eyup Erhan KARAASLAN <eyuperhankaraaslan94@gmail.com>
VOLUME /tmp
EXPOSE 9300
ADD target/todoapp-0.0.1-SNAPSHOT.jar todoapp.jar
ENTRYPOINT ["java","-jar","/todoapp.jar"]