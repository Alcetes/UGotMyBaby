package app.factories;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import app.categories.CategoriesHashMap;
import app.components.custom.CustomJLabel;
import app.views.layouts.Header;

/*
 * 
 * create the ApplicationContext Class : definir la classe ApplicationContnext qui stocke les instances de l'application
 * et autres ressources nécessaires de l'application. Cette classe est construite pour gérer les dependences et fournit 
 * l'acces aux composants requis.
 */
public class AppContext {

	/**
	 * Class Methods - returns the Singleton instance
	 * 
	 * @return
	 */
	public static AppContext getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new AppContext();
		}
		return uniqueInstance;
	}

	private AppContext() {
		CategoriesHashMap<String, CustomJLabel> categoriesMap = new CategoriesHashMap<>();
		Header.categoriesMap = categoriesMap; // Denpendency injection for the header categories
	}

	/**
	 * Returns the name of the app
	 * 
	 * @return
	 */

	public String getAppName() {
		return appName;
	}

	/**
	 * Returns the MySQL connection
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return connection;
	}

	CategoriesHashMap<String, CustomJLabel> categoriesHashMap;

	private Map<String, Object> instances = new HashMap<>();

	private ArrayList<String> categories;

	public void registerInstance(String key, Object instance) {
		instances.put(key, instance);
	}

	public Object getInstance(String key) {
		return instances.get(key);
	}

	public ArrayList<String> getCategories() {
		return categories;
	}

	public CategoriesHashMap<String, CustomJLabel> getCategoriesHashMap() {
		return categoriesHashMap;
	}

	private static AppContext uniqueInstance;

	private Connection connection;

	private String appName = "U Got My Baby";
	
	public Thread listenToDroppedOrders;
	
	public Thread listenToOrders;
}
