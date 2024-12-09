package com.skilldistillery.filmquery.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

		String choice;

		do {
			displayMenu();

			choice = input.next();

			switch (choice) {

			case "1":
				System.out.println("\nPlease enter in the film id: ");

				Film filmById = db.findFilmById(input.nextInt());

				if (filmById == null) {
					System.out.println("\nSorry, unable to locate a film with that ID.\n");
					break;

				} else
					basicInfoByID(filmById);
				displaySubMenu();
				switch (input.nextInt()) {
				case 1:
					printAllMovieInfo(filmById);
					break;

				case 2:
					break;
				}
				break;

			case "2":
				System.out.println("\nPlease enter in a keyword: ");
				List<Film> filmsByKeyword = db.findFilmByKeyword(input.next());

				if (filmsByKeyword.isEmpty()) {
					System.out.println();
					System.out.println("\nSorry, unable to locate films with that keyword.\n");
					break;
				} else
					basicInfoByKeyword(filmsByKeyword);

				displaySubMenu();
				switch (input.nextInt()) {
				case 1:
					printAllMovieInfo(filmsByKeyword);
					break;

				case 2:
					break;
				}

				break;

			case "3":
				System.out.println("You are exting the application. \nBye-Bye!");
				keepgoing = false;
				break;

			default:
				System.out.println("\nOops! Invalid entry. Please choose from 1-3.");
			}

		} while (keepgoing);

	}

	private void displayMenu() {

		System.out.println("\n*************************************");
		System.out.println("*             MAIN MENU             *");
		System.out.println("*   Please choose from options 1-3  *");
		System.out.println("*                                   *");
		System.out.println("* 1. Look up film by id             *");
		System.out.println("* 2. Look up film by keyword        *");
		System.out.println("* 3. Exit                           *");
		System.out.println("*                                   *");
		System.out.println("*************************************");
	}

	private void displaySubMenu() {
		System.out.println("*************************************");
		System.out.println("*              SUBMENU              *");
		System.out.println("* Please choose from the following  *");
		System.out.println("*                                   *");
		System.out.println("* 1. View all movie details         *");
		System.out.println("* 2. Return to main menu            *");
		System.out.println("*                                   *");
		System.out.println("*************************************");
	}

	public void basicInfoByID(Film film) {
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println(film.getTitle() + " (Movie Id:" + film.getFilmID() + ")");
		System.out.println();
		System.out.println("Release year: " + film.getReleaseYear() + "\tLanguage: " + film.getLanguage()
				+ "\tFilm rating: " + film.getRating());
		System.out.println();
		System.out.println("Movie description: \n" + film.getDescription());
		System.out.println();
		printActors(film.getActors());
	}

	public void basicInfoByKeyword(List<Film> films) {
		for (Film film : films) {

			System.out.println(
					"-----------------------------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println(film.getTitle() + " (Movie Id:" + film.getFilmID() + ")");
			System.out.println();
			System.out.println("Release year: " + film.getReleaseYear() + "\tLanguage: " + film.getLanguage()
					+ "\tFilm rating: " + film.getRating());
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
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------");
	}

	public void printAllMovieInfo(Film film) {
		System.out.println(
				"\n-----------------------------------------------------------------------------------------------------------\n");
		System.out.println(film.getTitle() + " (Movie Id:" + film.getFilmID() + ")\n");
		System.out.println("Release year: " + film.getReleaseYear() + "\tLanguage: " + film.getLanguage()
				+ "(Language Id: " + film.getLanguageID() + ")\tFilm rating: " + film.getRating());
		System.out.println("\nMovie description: \n" + film.getDescription());
		System.out.println(
				"\nLength: " + film.getLength() + " minutes\tSpecial Features: " + film.getSpecialFeatures() + "\n");
		printActors(film.getActors());
		System.out.println("\nRental rate: $" + film.getRentalRate() + "\tRental duration: " + film.getRentalDuration()
				+ " days \tReplacement cost: $" + film.getReplacementCost());
		System.out.println(
				"\n-----------------------------------------------------------------------------------------------------------");
	}

	public void printAllMovieInfo(List<Film> films) {
		for (Film film : films) {
			System.out.println(
					"\n-----------------------------------------------------------------------------------------------------------\n");
			System.out.println(film.getTitle() + " (Movie Id:" + film.getFilmID() + ")\n");
			System.out.println("Release year: " + film.getReleaseYear() + "\tLanguage: " + film.getLanguage()
					+ "(Language Id: " + film.getLanguageID() + ")\tFilm rating: " + film.getRating());
			System.out.println("\nMovie description: \n" + film.getDescription());
			System.out.println("\nLength: " + film.getLength() + " minutes\tSpecial Features: "
					+ film.getSpecialFeatures() + "\n");
			printActors(film.getActors());
			System.out.println("\nRental rate: $" + film.getRentalRate() + "\tRental duration: "
					+ film.getRentalDuration() + " days \tReplacement cost: $" + film.getReplacementCost());
			System.out.println(
					"\n-----------------------------------------------------------------------------------------------------------");
		}

	}

}
