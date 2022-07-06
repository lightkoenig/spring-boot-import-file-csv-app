Required:

![image](https://user-images.githubusercontent.com/101942591/177436056-7e74f616-954e-40ca-ad5a-e15c1311c8c0.png)

Idea: CSV Data->JDBC->SpringBoot
Result:
![image](https://user-images.githubusercontent.com/101942591/177436176-2ba3fef4-be5a-4acd-9e2d-463095631d05.png)
![image](https://user-images.githubusercontent.com/101942591/177436144-6f1b605f-a495-4c26-b4be-a831d256dae3.png)

How Check Result in Action:
1. Install SQL (MySQL) 
https://dev.mysql.com/downloads/installer/
2. Install Postman 
https://www.postman.com/downloads/
3. Preferred IDE: Intellij
https://www.jetbrains.com/de-de/idea/download/#section=windows

Used:
Framework: Spring Boot, but first initialized through https://start.spring.io/
![image](https://user-images.githubusercontent.com/101942591/177436525-33b6b863-c4ac-4d42-a221-e37cd883e95a.png)
Database: JDBC Connector
Tools: Postman for HTTP Requests

Must be Improved:
1. JDBC bad idea to apply in Spring Boot Project, however at first considered Spring Batch with CSV Helper
2. Some Test implementations for example to cehck some rows (dummy variant -> assertEquals(address, testTB.getAddress()))
