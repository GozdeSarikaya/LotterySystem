# Lottery System

The example lottery service is developed by Java and Spring framework.

**Development specs:**
- Programming Language: Java
- Framework: Spring Framework (Boot, Web, JPA, MVC, Security)
- Web: Thymeleaf, HTML, CSS
- Database: H2
- Test: JUnit, Spring Framework Test

**Service properties:**
- The service allows anyone to register as a lottery participant.
- Lottery participants are able to submit as many lottery ballots for any lottery that isn't yet finished.
- Each day at midnight the lottery event is considered closed and a random lottery winner is selected from all participants for the day.
- All users are able to check the winning ballot for any specific date.
- The service persists the data regarding the lottery.

## Project Hierarchy

The following listed files and folders are part of the project:

- README.md : current file
- pom.xml : Maven project main file
- src/main/java :  Source files of the code.
- src/main/resources :  Sample input json file
- src/test/java :  Source files for the JUNIT5 unit tests
- src/test/resources :  input json files used by the unit tests
- logs/log.log : Application log file

#### Prerequisites

You will need `maven v3.6.3+` and `jdk11` to be able to compile and run this application.


### Logger Initialization

For logger type, logback implementation is used and set `info` log level by default.
If you want to change the log level, you can find `src/main/resources/logback.xml` file and change `info` level to `debug, trace or off` level.

#### Compile and run the application

After cloning the project, open a commandline (cmd.exe) at the main folder that contains project `pom.xml` file and build the application by using following commands:

```
mvn clean install
mvn spring-boot:run
```

#### Test the application

```
http://localhost:8080
```


