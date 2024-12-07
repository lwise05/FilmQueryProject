package com.skilldistillery.filmquery.app;

import java.util.ArrayList;
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
		// -do while loop

		// act on choice
		// repeat until they quit

		boolean keepgoing = true;

		do {
			System.out.println();
			displayMenu();

			switch (input.nextInt()) {

			case 1:
				System.out.println("Please enter in the film id: ");

				Film filmById = db.findFilmById(input.nextInt());
				
				if (filmById != null) {
					basicInfoByID(filmById);
				} else
					System.out.println("\nSorry, unable to locate a film with that ID.");

				break;

			case 2:
				System.out.println("Please enter in a keyword: ");
				List<Film> filmsByKeyword = db.findFilmByKeyword(input.next());
				
				if (filmsByKeyword.isEmpty()) {
					System.out.println();
					System.out.println("Sorry, unable to locate films with that keyword.");
				} else
					basicInfoByKeyword(filmsByKeyword);
					
				break;

			case 3:
				System.out.println("You are exting the application. /Bye-Bye!");
				keepgoing = false;
				break;

			default:
				System.out.println("Oops! Invalid entry. Please choose from 1-3.");
			}

		} while (keepgoing);

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
	

	public void basicInfoByID(Film film) {
		int filmID = film.getFilmID();
		String title = film.getTitle();
		String language = film.getLanguage();
		int releaseYear = film.getReleaseYear();
		String rating = film.getRating();
		String desc = film.getDescription();
		List actors = film.getActors();
		
		
		System.out.println("Film ID: " + filmID + "\nFilm title: " + title + "\nLanguage: " + language +"\nRelease Year: " + releaseYear);
		System.out.println("Cast in film: " + actors + "\nFilm rating: " + rating + "\nDescription: " + desc);
	}
	
	public void basicInfoByKeyword(List<Film> films) {
		
		for(Film film : films) {
			System.out.println("Film Id: " + film.getFilmID());
			System.out.println("Title : " + film.getTitle());
			System.out.println("Language : " + film.getLanguage());
			System.out.println("Release year: " + film.getReleaseYear());
			System.out.println("Cast in film: " + film.getActors());
			System.out.println("Rating: " + film.getRating());
			System.out.println("Description : " + film.getDescription());
			System.out.println();
			
		}
	}
		
	
		
		
	

}
