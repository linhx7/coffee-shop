1. Setup database
- Run Database by command
        docker-compose up
- Build image
        docker build -t coffee-shop:latest .
- Run container
        docker run -p 8080:8080 coffee-shop:latest

2. Request
+ Create Order Request
Param:
 - customerId: Customer Id
 - shopId: Shop Id
 - queueId: Queue Id
 - body:
		Map : <Id Item , quantity>
		
URL: 		
curl --location 'http://localhost:8080/api/orders?customerId=1&shopId=1&queueId=1' \
--header 'Content-Type: application/json' \
--data '{
        "1": 2,
        "2": 1
}'


+ Processing Order 
Param:
 - shopId: Shop Id
 - queueId: Queue Id
 - numberOfOrders: Number Of Order in queue to process
URL :  
curl --location --request POST 'http://localhost:8080/api/order-processing/process-orders?shopId=1&queueId=1&numberOfOrders=10' \
--header 'Content-Type: application/json'




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