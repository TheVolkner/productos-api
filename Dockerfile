FROM openjdk:19
COPY out/artifacts/productos_jar/productos.jar productos.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/productos.jar"]
