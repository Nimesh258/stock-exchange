# Stock Exchange
## Stock Market REST API Application 

## Main Technology Stack
 * Spring Boot 
 * Spring Data JPA
 * H2 Database Engine
 * RESTful API


## To run the application
You can execute this maven command: 'mvn spring-boot:run'. 

## Rules for stock exchange are given as comments in the below java classes: 

* com.iss.demo.dao.StockExchangeDao -> Rule5
* com.iss.demo.controller.StockExchangeController -> Rule1 to Rule4 and Rule6

## To test the application

 1. Web service endpoints:
	* To get available sellers based on Buyers options: \
		curl \
		--location \
		--request POST 'http://localhost:8080/seller' \
		--header 'Content-Type: application/json' \
		--data-raw '{
						"buyerName": "Buyer-1",
						"required": "8",
						"buyerRate": "550"
					}'
	
	* To get all the available sellers : \
		curl --location --request GET 'http://localhost:8080/sellers'
	
	* To get sellers by ID : \
		curl --location --request GET 'http://localhost:8080/sellers/1'
	
	
 2. Sample Request: \
	{ \
		"buyerName": "Buyer-1", \
		"required": "8", \
		"buyerRate": "550" \
	} 
 3. Sample response: \
	{ \
    "buyers": null, \
    "sellers": [ \
					{ \
						"sid": 4, \
						"sellerName": "Seller-4", \
						"sellerTime": "08:04:05", \
						"sellerRate": 600, \
						"available": 7 \
					}, \
					{ \
						"sid": 2, \
						"sellerName": "Seller-2", \
						"sellerTime": "08:03:02", \
						"sellerRate": 700, \
						"available": 2 \
					}, \
					{ \
						"sid": 3, \
						"sellerName": "Seller-3", \
						"sellerTime": "08:04:04", \
						"sellerRate": 800, \
						"available": 6 \
					} \
				] \
	} 
	
