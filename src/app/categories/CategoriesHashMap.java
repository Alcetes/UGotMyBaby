package app.categories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JLabel;

import app.components.custom.CustomJLabel;
import app.resources.Fonts;

public class CategoriesHashMap<K, V> extends HashMap<K, V> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> categories;

	@SuppressWarnings("unchecked")
	/**
	 * Cette mehode a été modifé pour pouvoir s'adapter à stocker des composant de
	 * type JLabel dans un HashMap.
	 * 
	 * @param key    -> la clé choisie
	 * @param text   -> Le texte qu'on veut dans le JLabel
	 * @param format -> Le poids de la police utilisé
	 * @return
	 */
	public CategoriesHashMap() {

		/**
		 * This will be replaced as we will want to retrieve the categories from
		 * database.
		 */
		categories = new ArrayList<String>();
		categories.add("Overnight");
		categories.add("In home");
		categories.add("Emergency");
		categories.add("Petsitting");
		categories.add("Special Needs");
		categories.add("Hotel");
		categories.add("Corporateevent");
		categories.add("All");
		categories.add("Lesmieuxnotes");
		categories.add("Les pluspopulaires");

		Iterator<String> iterator = categories.iterator();
		while (iterator.hasNext()) {
			String category = iterator.next();

			pushCategory((K) category.replaceAll("\\s", "").toLowerCase(), category);
			if (category.equals("All")) {
				CustomJLabel all = (CustomJLabel) get("all");
				all.setSelected(true);
			}

		}
	}

	public ArrayList<String> getCategories() {
		return categories;
	}

	/**
	 * Build the JLabel of category
	 */

	@SuppressWarnings("unchecked")
	public void pushCategory(K key, String text) {
		CustomJLabel lbl = new CustomJLabel(text, Fonts.PROXIMA_NOVA_REGULAR, 16f);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		super.put(key, (V) lbl);
	}

	public CustomJLabel getCategory(K key) {
		return (CustomJLabel) super.get(key);
	}
}