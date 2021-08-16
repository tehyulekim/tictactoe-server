




Completed
2019-5-29
2019-149

README INSTRUCTIONS

This project uses
JDK12
Gradle 5.4.1


Unzip project file server.zip. It will create directory
server\A2

Open IntelliJ IDEA.
File > New > Project from Existing Sources ... >
C:\...\server\A2
Import project from external model
> Gradle
> Next > Next




Run ServerApplication to start server.

A2\src\main\java\assignment2_server_14068171\server\ServerApplication.java


Open browser
http://localhost:8080/ttt










Spring MVC Framework
Spring Boot

with Thymeleaf template engine. Ended up not using any thymeleaf features.
Thymeleaf is equivalent function to JSP, but uses html instead of .jsp.



Relevant files for assignment:

A2\src\main\java\assignment2_server_14068171\server\ServerApplication.java
A2\src\main\java\assignment2_server_14068171\server\ServerController.java
A2\src\main\java\assignment2_server_14068171\server\TTT.java
A2\src\main\resources\templates\test.html
A2\src\test\java\assignment2_server_14068171\server\ServiceTests.java



Game logic is all in Java. The java class itself is sufficient to run all the game logic.
Javascript here does not contain game logic, and it is only for communication and viewing game.






HttpSession equivalent class is in ModelMap // HttpSession class equivalent functionality is in ModelMap
In Spring MVC, it uses Model or ModelMap object instead of HttpServletRequest

// This annotation sets model attribute "sessionGame" as session attribute therefore persistent
@SessionAttributes({"sessionGame"})

// set attribute
modelMap.addAttribute("sessionGame", new TTT());

// get attribute
(TTT) modelMap.get("GameSession");





Tests

To Run test
A2\src\test\java\assignment2_server_14068171\server\ServiceTests.java

Set up but couldn't get it running well as in browser. Trouble making sequential changes in object contained in session.
