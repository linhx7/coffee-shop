FROM openjdk:17
MAINTAINER linhdx
ENV TZ="Asia/Ho_Chi_Minh"
COPY target/coffee-shop-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]