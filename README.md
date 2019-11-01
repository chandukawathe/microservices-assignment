# Micro-service For Inserting and Retriving  Orders from DB 


This project is deals with two services with api gateway service which is registered with eureka-server by through which we access the services.

# Project Components:

1.	API –Gateway – Spring boot, Netflix Zuul
2.	Service Discovery – Spring boot ,Netflix Eureka 
3.	Order-service – Spring boot , JPA, Hibernate
4.	Order-details-service – Spring boot , JPA , Hibernate

# Important Endpoint 
•	http://localhost:8300/{cust_id}/placeOrder - Order Service - Placing Order
•	http://localhost:8200/{cust_id}/getOrders/ -Order-Details-Service –to get Order details
•	http://localhost:8761 – Eureka Dashboard

# URI Endpoints from API Gateway 

GET	http://localhost:8400/order-details-service/{cust_ID}/getOrders	Cust_id – provide customer id	Get the orders for provided customer id.

POST	http://localhost:8400/order-service/{cust_id}/placeOrder	Cust_id – provide customer id,To add order to the customer ID
Request Body :-
        {
            "source_address": "Bankok",
            "dest_address": "Newyork",
            "order_date": "2019-02-11",
            "shipment_date": "2019-04-11",
            "product": [
                  {
                  "product_id":"5",
                  "product_name": "Detergent",
                  "product_price": "333.0"
                  },
                  {
                  "product_id":"6",
                  "product_name": "Detergent",
                  "product_price": "333.0"
                  }
                  ]
}	


