package com.skilldistillery.filmquery.entities;

import java.util.Objects;

public class Actor {

	private int actorID;
	private String firstName;
	private String lastName;

	public Actor() {

	}

	public Actor(int actorID, String firstName, String lastName) {
		super();
		this.actorID = actorID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getActorID() {
		return actorID;
	}

	public void setActorID(int actorID) {
		this.actorID = actorID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "\nActor ID: " + actorID + ", Name: " + firstName + " " + lastName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorID, firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return actorID == other.actorID && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}

}
