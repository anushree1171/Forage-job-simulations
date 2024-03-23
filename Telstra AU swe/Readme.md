##Sim Card Activation

This Java code implements a REST service for activating SIM cards. 
The controller receives activation requests via the "/activate" endpoint, then utilizes REST templates to forward JSON data to another service located at "/actuate" for SIM card activation. 
Upon activation, pertinent data such as SIM card ID, ICCID, and customer email ID are stored in the "sim cards" table, while activation status information is stored in the "activation status" table. 
The code employs Cucumber for API testing, ensuring robust functionality. 
Additionally, clean code practices are maintained with the integration of SonarQube plugin in IntelliJ. 
Extensive testing, including Postman validation, confirms the system's effectiveness, yielding expected results aligned with input parameters.
