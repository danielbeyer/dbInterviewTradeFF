# Swagger generated server

Spring Boot Server 


## Overview  
This server was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.  
By using the [OpenAPI-Spec](https://github.com/swagger-api/swagger-core), you can easily generate a server stub.  
This is an example of building a swagger-enabled server in Java using the SpringBoot framework.  

The underlying library integrating swagger to SpringBoot is [springfox](https://github.com/springfox/springfox)  

Start your server as an simple java application  

You can view the api documentation in swagger-ui by pointing to  
http://localhost:8080/  

Change default port value in application.properties
# .......................
# user swagger ui to test the serviec
http://127.0.0.1:8080/c5764/dbInterviewShowcase/1.0.0/swagger-ui.html

# .......................
# Test the application
The following code was used to test the application
insert data:
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://127.0.0.1:8080/c5764/dbInterviewShowcase/1.0.0/c5764/dbInterviewShowcase/1.0.0/addTradeMessage?tradeMessage=s00009699633;2020-03-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000'
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://127.0.0.1:8080/c5764/dbInterviewShowcase/1.0.0/c5764/dbInterviewShowcase/1.0.0/addTradeMessage?tradeMessage=s00009699634;2020-03-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000'
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://127.0.0.1:8080/c5764/dbInterviewShowcase/1.0.0/c5764/dbInterviewShowcase/1.0.0/addTradeMessage?tradeMessage=s00009699635;2020-03-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000'
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://127.0.0.1:8080/c5764/dbInterviewShowcase/1.0.0/c5764/dbInterviewShowcase/1.0.0/addTradeMessage?tradeMessage=s00009699636;2020-03-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000'
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://127.0.0.1:8080/c5764/dbInterviewShowcase/1.0.0/c5764/dbInterviewShowcase/1.0.0/addTradeMessage?tradeMessage=s00009699637;2020-03-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000'
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://127.0.0.1:8080/c5764/dbInterviewShowcase/1.0.0/c5764/dbInterviewShowcase/1.0.0/addTradeMessage?tradeMessage=s00009699638;2020-03-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000'

# update data
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://127.0.0.1:8080/c5764/dbInterviewShowcase/1.0.0/c5764/dbInterviewShowcase/1.0.0/addTradeMessage?tradeMessage=s00009699638;2020-04-16T15:40:00.000000Z;2020-05-08;1000303857;514000;+0000000000021,0000'

# select data
curl -X GET --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://127.0.0.1:8080/c5764/dbInterviewShowcase/1.0.0/c5764/dbInterviewShowcase/1.0.0/listTradeMessages' 
