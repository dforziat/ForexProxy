# ForexProxy

This is the Forex Proxy project created by Daniel Forziat.

# Project Overview

Dev Software: 
- Netbeans 13 IDE
- Insomnia API
- Docker Desktop

Libraries used:
- Javaee on Java 1.8 JDK 
- JUnit (*For testing*)
- Jersey (*For testing*)

Server:
- Payara Server 5.2022.1

# Project Setup
The Java project is built with Maven and deployed locally on a Payara Server. 
The project should be deployable on most common Java servers, but becareful with conflicting port numbers with Docker.

**Important** - 
I changed the port of my local Docker container to 8082 to fix a conflict with my local installation.
If you need to changed your port too, the URL of the Docker container is located within the [ForexProxyClient.java](https://github.com/dforziat/ForexProxy/blob/main/src/main/java/com/mycompany/forexproxy/client/ForexProxyClient.java) class on line 21.

I have created an importable list of API's that can be run in common API testing tools like Insomnia, Postman, Swagger 2.0 and OpenAPI. If you would like to use it, it can be downloaded here: [Insomnia_ForexProxy.zip](https://github.com/dforziat/ForexProxy/files/8504166/Insomnia_ForexProxy.zip)


Once the Java project has been successfully been built and deployed, you can "ping" the server using: 
GET http://localhost:8080/ForexProxy/resources/javaee8

A successful response will return response code 200 and the body text "ping".

Once the java project and the Docker container have been deployed, you can now test the Exchange Rate API.
GET http://localhost:8080/ForexProxy/resources/forexproxy/exchangerate?currencyPair={currency_pair1}&currencyPair={currency_pair2}

# Assumptions
Since no response body format for the user was specified, I am using the same response body from the Docker One Frame API and passing it back to the user.

The specifications state that a rate that is not older than 5 minutes is returned, but the Docker One Frame API returns a rate that is always within that time. Assuming that this does not need to be double checked.

Allow requests with multiple of the same currency pair to be sent. For example (USDJPY,USDJPY)

# Potential Additional Features
Continue the process if at least one currency pair in a list is valid. Currently stops once an invalid currency pair is requested. 




