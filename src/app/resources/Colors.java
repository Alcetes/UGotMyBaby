package app.resources;

import java.awt.Color;

public class Colors {

	public Color secondColor = Color.decode("#A67744");
//	public  Color fontColor = Color.decode("#354E57");
	public Color firstColor = new Color(53, 78, 87);

	public Color getFontColorWithAlpha(int alpha) {
		return new Color(53, 78, 87, alpha);
	}

	
	public static Colors getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Colors();
		}
		return uniqueInstance;
	}
	
	
	private static Colors uniqueInstance;
}