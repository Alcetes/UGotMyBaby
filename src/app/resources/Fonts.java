package app.resources;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.HashMap;

public class Fonts {

	private Fonts() {
		fonts.put(PROXIMA_NOVA_BOLD, makeFont("ProximaNova-Bold.ttf"));
		fonts.put(PROXIMA_NOVA_REGULAR, makeFont("ProximaNova-Regular.ttf"));
		fonts.put(PROXIMA_NOVA_BLACK, makeFont("ProximaNova-Black.ttf"));
		fonts.put(PROXIMA_NOVA_EXTRA_BOLD, makeFont("ProximaNova-Extrabld.ttf"));
		fonts.put(PROXIMA_NOVA_LIGHT, makeFont("ProximaNova-Light.ttf"));
		fonts.put(PROXIMA_NOVA_SEMI_BOLD, makeFont("ProximaNova-Semibold.ttf"));
		fonts.put(PROXIMA_NOVA_THIN, makeFont("ProximaNovaT-Thin.ttf"));
		fonts.put(SOMATIC_ROUNDED, makeFont("Somatic-Rounded.otf"));
	}

	public static Fonts getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Fonts();
		}
		return uniqueInstance;
	}

	/**
	 * Instances methods
	 * 
	 * @param font_id
	 * @return
	 */

	public Font getFont(int id) {
		return fonts.get(id);
	}

	private Font makeFont(String param) {
		Font temp;
		try {
			temp = Font.createFont(Font.TRUETYPE_FONT, Fonts.class.getClassLoader().getResourceAsStream(param));
			return temp;
		} catch (FontFormatException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Fonts uniqueInstance;
	public static final int PROXIMA_NOVA_BOLD = 1;
	public static final int PROXIMA_NOVA_REGULAR = 2;
	public static final int PROXIMA_NOVA_LIGHT = 3;
	public static final int PROXIMA_NOVA_BLACK = 4;
	public static final int PROXIMA_NOVA_SEMI_BOLD = 5;
	public static final int PROXIMA_NOVA_EXTRA_BOLD = 6;
	public static final int PROXIMA_NOVA_THIN = 7;
	public static final int SOMATIC_ROUNDED = 8;

	private HashMap<Integer, Font> fonts = new HashMap<Integer, Font>();
}
