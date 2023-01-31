FROM openjdk:19
COPY target/*.jar productos.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/productos.jar"]