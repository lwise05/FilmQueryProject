package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);

//    Actor actor = db.findActorById(1);
//    System.out.println(actor);

	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		// print menu
		// get choice
		//  -do while loop
	
		//act on choice
		// repeat until they quit
		
		boolean keepgoing = true;
		
		
		do {
			System.out.println();
			displayMenu();
			
			switch(input.nextInt()) {
			
			case 1: 
				System.out.println("Please enter in the film id: ");
				
				Film filmById = db.findFilmById(input.nextInt());
				if (filmById != null) {
					System.out.println(filmById);
				} else 
					System.out.println("\nSorry, unable to locate a film with that ID.");
				
				break;
				
			case 2:
				System.out.println("Please enter in a keyword: ");
				List<Film> filmByKeyword = db.findFilmByKeyword(input.next());
				System.out.println(filmByKeyword);
				if (filmByKeyword != null) {
					System.out.println(filmByKeyword);
				} else 
					System.out.println("\nSorry, unable to locate a film with that ID.");
				break;
				
			case 3:
				System.out.println("You are exting the application. /Bye-Bye!");
				keepgoing=false;
				break;
				
			default:
				System.out.println("Oops! Invalid entry. Please choose from 1-3.");
			}
			
			
			
		} while(keepgoing);
		
	
		
		
	}
	
	private void displayMenu() {
		System.out.println("*************************************");
		System.out.println("*             MAIN MENU             *");
		System.out.println("*   Please choose from options 1-3  *");
		System.out.println("*                                   *");
		System.out.println("* 1. Look up film by id             *");
		System.out.println("* 2. Look up film by keyword        *");
		System.out.println("* 3. Exit                           *");
		System.out.println("*                                   *");
		System.out.println("*************************************");
	}

	
	
}
