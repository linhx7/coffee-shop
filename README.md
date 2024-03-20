### Requirements
- Maven 3+
- Java 17
- Postgresql Database

### Dependency
- Spring Boot 3.0.3
- Liquibase Maven Plugin 4.19.0

### Use cases
#### Start the service
```
mvn spring-boot:run
```
#### Generate diff changelog 
```
mvn liquibase:diff -Ddiff.version=1.0