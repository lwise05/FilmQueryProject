package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

	String user = "student";
	String pass = "student";

	public DatabaseAccessorObject() {

	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		try {
			// 1. connecting to the database
			Connection conn = DriverManager.getConnection(URL, user, pass);

			// 2. defining query we want to execute and substituting values for placeholder
			String filmText = "SELECT id, title, description, release_year, language_id, rental_duration, rental_rate, ";
			filmText += " length, replacement_cost, rating, special_features FROM film WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(filmText);
			stmt.setInt(1, filmId);

			// 3. execute query
			ResultSet rs = stmt.executeQuery();

			// 4. process result
			if (rs.next()) {
				int filmID = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int releaseYear = rs.getInt("release_year");
				int languageID = rs.getInt("language_id");
				int rentDuration = rs.getInt("rental_duration");
				double rentalRate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialFeatures = rs.getString("special_features");
				List<Actor> actors = findActorsByFilmId(filmId);

				Film filmObj = new Film(filmID, title, description, releaseYear, languageID, rentDuration, rentalRate,
						length, replacementCost, rating, specialFeatures, actors);

				return filmObj;
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			System.err.println("Error locating film " + filmId);
			System.out.println(e);
		}
		return film;
	}


	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;

		try {
			// 1. connecting to the database
			Connection conn = DriverManager.getConnection(URL, user, pass);

			// 2. defining query we want to execute and substituting values for placeholder
			String actorText = "SELECT id, first_name, last_name FROM actor WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(actorText);
			stmt.setInt(1, actorId);

			// 3. execute query
			ResultSet rs = stmt.executeQuery();

			// 4. process result
			if (rs.next()) {
				int actorID = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");

				Actor actorObj = new Actor(actorID, firstName, lastName);
				return actorObj;
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			System.err.println("Error locating actor " + actorId);
			System.out.println(e);
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();

		try {
			// 1. connecting to the database
			Connection conn = DriverManager.getConnection(URL, user, pass);

			// 2. defining query we want to execute and substituting values for placeholder
			String actorsInFilm = "SELECT actor.id, actor.first_name, actor.last_name FROM actor JOIN film_actor ON actor.id = film_actor.actor_id ";
			actorsInFilm += "JOIN film ON film_actor.film_id = film.id  WHERE film.id = ?";

			PreparedStatement stmt = conn.prepareStatement(actorsInFilm);
			stmt.setInt(1, filmId);

			// 3. execute query
			ResultSet rs = stmt.executeQuery();

			// 4. process result
			while (rs.next()) {
				int actorID = rs.getInt("actor.id");
				String firstName = rs.getString("actor.first_name");
				String lastName = rs.getString("actor.last_name");

				Actor actorInfo = new Actor(actorID, firstName, lastName);
				actors.add(actorInfo);

			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return actors;
	}

//	public Film printBasicFilmInfo(int film) {
//		
//		System.out.println("Film ID: " + film.getFilmID() + " \nTitle: " + film.getTitle() + " \nYear released: " + film.getReleaseYear());
//		System.out.println(" \nRating: " + film.getRating() + " \nDescription: " + film.getDescription());
//		
//	}
	@Override
	public List<Film> findFilmByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();

		try {
			// 1. connecting to the database
			Connection conn = DriverManager.getConnection(URL, user, pass);

			// 2. defining query we want to execute and substituting values for placeholder
			String filmText = "SELECT id, title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features FROM film ";
			filmText += "WHERE title LIKE ? OR description LIKE ?";

			PreparedStatement stmt = conn.prepareStatement(filmText);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");

			// 3. execute query
			ResultSet rs = stmt.executeQuery();

			// 4. process result
			while (rs.next()) {

				int filmID = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int languageID = rs.getInt("language_id");
				int rentalDuration = rs.getInt("rental_duration");
				double rentRate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialFeatures = rs.getString("special_features");
				List<Actor> actors = findActorsByFilmId(filmID);

				Film filmObj = new Film(filmID, title, description, releaseYear, languageID, rentalDuration,
						rentRate, length, replacementCost, rating, specialFeatures, actors);
				films.add(filmObj);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			System.err.println("Error locating film with keyword " + keyword);
			System.out.println(e);
		}
		return films;
	}


}
