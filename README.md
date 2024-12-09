# FilmQueryProject

## Description 
This program simulates a film database where the user is able to view film info in a couple different ways. The user is able to enter in a specific film id or use a keyword to view all films that include the keyword in the title or description. If no films are located with the provided information, the user will be notified and be able submit a new query. If the film id or keyword locates films with that information, the user will be provided with basic film details and will then be prompted if they want to return to the main menu or request to view additional film details. The user is able to continue searching through the database until they are ready to exit the program.

## Technologies Used
* Java
* Eclipse
* MacOS Terminal
* MySQL
* Sublime

## Concepts Used
* Java
	* Object-Relational Mapping
	* Inheritence
	* Encapsulation
	* Polymorphism
	* Interfaces
	* Arraylists
	* Getters/Setters
	* For each loops
	* Do while & While loops
	* Switches
	* Try/Catch blocks
	* Exceptions

* SQL
* SQL queries including:
	* SELECT/FROM statements
	* LIKE operators
	* JOIN clauses

## Lessons Learned
My favorite part of this project/this week was learning to use SQL queries to locate specific data across various tables in a database. I also enjoyed learning how to read from a database and constructing objects in Java using the information from the database. During this project I noted I was alot more comfortable with multiple concepts/functions including: interfaces, constructing objects, using getters to gather specific information from objects, iterating through Arraylists and providing different logic in the loops for different outcomes. Unfortunately, I was only able to finished one stretch goal due to time but I feel confident that I complete the next 2 stretch goals and plan to do so. 

I did have trouble attempting to implement a try/catch block in my switches (main menu and submenus) to account for user error (InputMismatchException). I believe that a better approach would have been to: 1) create seperate methods for the nested switches which would have made for cleaner code. 2) Since I originally was attempting to get different data types from the user input (int and String), I later realized that I was forgetting to use .nextLine() to clear out the scanner and was instead using .nextInt(), which wasn't allowing the user to stay in the loop.