package app.controllers;

import java.util.ArrayList;

import app.model.Provider;

public class ProviderController {

	String firstname;
	String lastname;
	String birthday;
	String plan;
	String id;
	String pricePerHour;
	String location;
	String[] categories;

	public static ArrayList<?> retrieveProviders() {
		return Provider.retrieveProviders(1, 50);

	}

	public static ArrayList<?> retrieveProvidersPerCategory(String param) {
		return Provider.retrieveProviderPerCategory(1, 50, param);
	}

}
