# iapps demo task

Spring boot application with following  Rest APIs:
- Read XML file validate against XSD and extract infomation to store in DB using JAXB
- List all the extracted POJO class - Epaper

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)


## Running the application locally

Before starting application you must need to build the project using following command.

```shell
mvn clean install
```

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.tatva.iapps.IappsApplication` class from your IDE.


Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```