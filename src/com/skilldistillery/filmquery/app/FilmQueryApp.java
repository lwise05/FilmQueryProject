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

		boolean keepgoing = true;

		do {
			System.out.println();
			displayMenu();

			switch (input.nextInt()) {

			case 1:
				System.out.println("\nPlease enter in the film id: ");

				Film filmById = db.findFilmById(input.nextInt());

				if (filmById != null) {
					basicInfoByID(filmById);
					
				} else
					System.out.println("\nSorry, unable to locate a film with that ID.");

				System.out.println();
				System.out.println("Enter 1 to view additional movie details \nEnter 2 to return to the Main Menu");
					switch(input.nextInt()) {
					case 1: 
						printAllMovieInfo(filmById);
						break;
						
					case 2:
						break;
					}
						
				
				break;
				

			case 2:
				System.out.println("\nPlease enter in a keyword: ");
				List<Film> filmsByKeyword = db.findFilmByKeyword(input.next());

				if (filmsByKeyword.isEmpty()) {
					System.out.println();
					System.out.println("\nSorry, unable to locate films with that keyword.");
				} else
					basicInfoByKeyword(filmsByKeyword);
				

				break;

			case 3:
				System.out.println("You are exting the application. \nBye-Bye!");
				keepgoing = false;
				break;

			default:
				System.out.println("\nOops! Invalid entry. Please choose from 1-3.");
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
		
		
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println(title + " (Movie Id:" + filmID +")");
		System.out.println();
		System.out.println("Release year: " + releaseYear + "\tLanguage: " + language + "\tFilm rating: " + rating);
		System.out.println();
		System.out.println("Movie description: \n" + desc);
		System.out.println();
		printActors(film.getActors());
	}

	public void basicInfoByKeyword(List<Film> films) {
		

		for (Film film : films) {
			
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println(film.getTitle() + " (Movie Id:" + film.getFilmID() +")");
			System.out.println();
			System.out.println("Release year: " + film.getReleaseYear() + "\tLanguage: " + film.getLanguage() + "\tFilm rating: " + film.getRating());
			System.out.println();
			System.out.println("Movie description: \n" + film.getDescription());
			System.out.println();
			printActors(film.getActors());

		}
	}

	public void printActors(List<Actor> actors) {
		
		System.out.println("Cast:");
		int count = 1;
		for (Actor actor : actors) {
			System.out.println(count + ") " + actor.getFirstName() + " " + actor.getLastName());
			count++;
		}
		System.out.println("-----------------------------------------------------------------------------------------------------------");
	}

	public void printAllMovieInfo(Film film) {
		int filmID = film.getFilmID();
		String title = film.getTitle();
		String language = film.getLanguage();
		int releaseYear = film.getReleaseYear();
		String rating = film.getRating();
		String desc = film.getDescription();
		int length = film.getLength();
		double replacementCost = film.getReplacementCost();
		String specFeatures = film.getSpecialFeatures();
		int languageID = film.getLanguageID();
		double rate = film.getRentalRate();
		int duration = film.getRentalDuration();
		
	
		
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println(title + " (Movie Id:" + filmID +")");
		System.out.println();
		System.out.println("Release year: " + releaseYear + "\tLanguage: " + language + "(Language Id: " + languageID + ")\tFilm rating: " + rating);
		System.out.println();
		System.out.println("Movie description: \n" + desc);
		System.out.println();
		System.out.println("Length: " + length + " minutes\tSpecial Features: " + specFeatures);
		printActors(film.getActors());
		System.out.println();
		System.out.println("Rental rate: $" + rate + "\tRental duration: " + duration + " days \tReplacement cost: $" + replacementCost);
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------------");
	}
	
	
	
	public void subMenu(Scanner input) {
		System.out.println();
		System.out.println("Enter 1 to view additional movie details \nEnter 2 to return to the Main Menu");
		
		switch(input.nextInt()) {
		
		case 1:
			Film filmById = db.findFilmById(input.nextInt());
		case 2:
			break;
		
		default:
			System.out.println("\nOops! Invalid entry. Please enter 1 or 2.");
		}
		
	}
}
