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


## Important

I changed the port of my local Docker container to 8082 to fix a conflict with my local installation.
If you need to changed your port too, the URL of the Docker container is located within the [ForexProxyClient.java](https://github.com/dforziat/ForexProxy/blob/main/src/main/java/com/mycompany/forexproxy/client/ForexProxyClient.java) class on line 21.

Once the Java project has been successfully been built and deployed, you can "ping" the server using: http://localhost:8080/ForexProxy/resources/javaee8
A successful response will return response code 200 and the text body "ping".


