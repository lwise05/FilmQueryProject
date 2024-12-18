package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {
	
	private int filmID;
	private String title;
	private String description;
	private int releaseYear;
	private int languageID;
	private String language;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actors;
	
	public Film () {
		
	}
	


	public Film(int filmID, String title, String description, int releaseYear, int languageID, String language,
			int rentalDuration, double rentalRate, int length, double replacementCost, String rating,
			String specialFeatures, List<Actor> actors) {
		super();
		this.filmID = filmID;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageID = languageID;
		this.language = language;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actors = actors;
	}



	public int getFilmID() {
		return filmID;
	}



	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getReleaseYear() {
		return releaseYear;
	}



	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}



	public int getLanguageID() {
		return languageID;
	}


	public void setLanguageID(int languageID) {
		this.languageID = languageID;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}



	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}



	public double getRentalRate() {
		return rentalRate;
	}



	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}



	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}



	public double getReplacementCost() {
		return replacementCost;
	}



	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}



	public String getRating() {
		return rating;
	}



	public void setRating(String rating) {
		this.rating = rating;
	}



	public String getSpecialFeatures() {
		return specialFeatures;
	}



	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}



	public List<Actor> getActors() {
		return actors;
	}



	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}



	@Override
	public String toString() {
		return "Film [filmID=" + filmID + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", languageID=" + languageID + ", language=" + language + ", rentalDuration="
				+ rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length + ", replacementCost="
				+ replacementCost + ", rating=" + rating + ", specialFeatures=" + specialFeatures + ", actors=" + actors
				+ "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(actors, description, filmID, language, languageID, length, rating, releaseYear,
				rentalDuration, rentalRate, replacementCost, specialFeatures, title);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(description, other.description)
				&& filmID == other.filmID && Objects.equals(language, other.language) && languageID == other.languageID
				&& length == other.length && Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}



	
	

	
	
	
	
	
	
}
