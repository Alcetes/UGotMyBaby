package app.factories;

import java.util.HashMap;

import app.controllers.ChildController;

public class Session extends HashMap<String, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Session uniqueInstance;

	/**
	 * Date et heure du début de la session
	 */
	String loggedAt;

	/**
	 * Identifiant de l'utilisateur connecté.
	 */
	String id;

	/*
	 * Prénom et nom de l'utilisateur connecté.
	 */
	String firstname;
	String lastname;
	/**
	 * email de l'utilisateur connecté.
	 */
	String email;

	/*
	 * Date de naissance de l'utilisateur connecté.
	 */
	String birthday;

	/*
	 * Le plan que l'utilisateur connecté a acheté.
	 */
	String plan;

	/*
	 * Acess level : indique le niveau d'autorisation de l'utilisateur connecté ex :
	 * simple utilisateur, administrateur.
	 */
	String accessLevel;

	/*
	 * Un tableau stockant les identifiants des enfants enregistrés de l'utilisateur
	 * connecté.
	 */
	ChildController[] childs;

	private Session(String firstname, String lastname, String email, String id, String type) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.id = id;
		this.accessLevel = type;
	}

	static public Session getUniqueInstance(String firstname, String lastname, String email, String id, String type) {
		if (uniqueInstance == null) {
			uniqueInstance = new Session(firstname, lastname, email, id, type);
		}
		return uniqueInstance;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public static boolean isDown() {
		return (uniqueInstance == null);
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
	}

	static public Session getUniqueInstance() {
		return uniqueInstance;
	}

	public void reset() {
		firstname = null;
		lastname = null;
		loggedAt = null;
		id = null;
		email = null;
		birthday = null;
		plan = null;
		accessLevel = null;
		uniqueInstance = null;

	}

	/*
	 * private static void buildSession() { if (isLoggedIn()) {
	 * 
	 * }
	 * 
	 * }
	 */
}
