# Java--BasicMarketSystem


- It's basic market system with mysql database.
- I have tried to write code as generic as I could.
- I have tried keep coupling in the lowest level I could.
- I have divided part program into components.
- Login controller and User interface components are implemented to be able to test for the reason not having actual user interface.


## Code layers
- Login Controller -> Decides which user is logged in.
- User Interfaces -> Since program is not connected to real front-end part, I created fake front-end methods are described according to different authorization
- Business Layer -> Layer for business rules and other constraints can be idenfied.
- Data Access Layer -> It contains database access implementation.


## Code Parts Explanation

- Worker -> Base class for any worker type
- Employee -> Employee class extends Worker
- Owner -> Owner class extends Worker
- Market -> Market class and properties
- Product -> Product class and properties
- Sales -> Sales class and properties
- Shift -> Shift class and properties
- Employee Dal -> It contains employee manipulation methods in database
- Owner Dal -> It contains owner manipulation methods in database
- Market Dal -> It contains market manipulation methods in database
- Product Dal -> It contains product manipulation methods in database
- Sales Dal -> It contains sales manipulation methods in database
- Shift Dal -> It contains shift manipulation methods in database
- Employee Manager -> It contains business rules for employee and interacts with data access layerc
- Owner Manager -> It contains business rules for owner and interacts with data access layer
- Market Manager -> It contains business rules for market and interacts with data access layer
- Product Manager -> It contains business rules for product and interacts with data access layer
- Sales Manager -> It contains business rules for sales and interacts with data access layer
- Shift Manager -> It contains business rules for shift and interacts with data access layer
- Employee Interface -> It contains employee front-end interface and it's authorized methods
- Owner Interface -> It contains owner front-end interface and it's authorized methods
- Admin Interface -> It contains admin front-end interface and it's authorized methods
- Interface Controller -> It contains creation methods for 3 types of User Interface
- Login Controller ->  It contains login methods for users and decision methods for which user interface will be created


- Main.java -> Main program initializer code


## How To Run
- git clone https://github.com/SerhatKumas/Java--BasicMarketSystem.git
- Open main.java and run it
- You will see user interface on your ide console


## Technologies

- [@Java](https://www.java.com/tr/)
- [@Mysql](https://www.mysql.com/)


# Hi, I'm Serhat the Author! 👋


## 🔗 Connection Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/serhatkumas/)

[![@Github](https://img.shields.io/badge/github-0A66C2?style=for-the-badge&logo=github&logoColor=white)](https://www.github.com/serhatkumas)
