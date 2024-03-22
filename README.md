1. Setup database
- Run Database by command
 docker-compose up

2. Request
+ Create Order Request
Param:
 - customerId: Customer Id
 - shopId: Shop Id
 - queueId: Queue Id
 - body:
		Map : Id Item , quantity
		
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
