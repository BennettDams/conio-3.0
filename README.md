# CONIO 3.0
### Java application with microservices
### developed with Spring Boot, Eureka, MySQL, Hibernate, Zuul & Thymeleaf 

## Add Docker setting
Path e. g.   C:\Coding\Tools\Maven\apache-maven-3.5.3\conf\settings.xml

```
<settings>
    <pluginGroups>
        <pluginGroup>com.spotify</pluginGroup>
    </pluginGroups>
</settings>
```

## Run application
* mvn clean install in top level folder (e.g. C:\Coding\Git\conio-3.0)
* run discovery-server as Spring Boot Application
* run gateway-service as Spring Boot Application
* run other services as Spring Boot Application

## Check Eureka at http://localhost:8761/
all services should be running
