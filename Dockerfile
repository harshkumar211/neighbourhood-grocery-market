FROM openjdk:8
COPY target/neighbourhood-grocery-market-0.0.1-SNAPSHOT.jar neighbourhood-grocery-market.jar
ENTRYPOINT ["java","-jar","/neighbourhood-grocery-market.jar"]