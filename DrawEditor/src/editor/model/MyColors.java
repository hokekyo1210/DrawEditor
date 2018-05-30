package editor.model;

import java.awt.Color;

public class MyColors {
	
	private static Color[] colors = {
			Color.BLACK,
			Color.BLUE,
			Color.RED,
			Color.CYAN,
			Color.DARK_GRAY,
			Color.GRAY,
			Color.MAGENTA,
			Color.LIGHT_GRAY,
			Color.ORANGE,
			Color.PINK,
			Color.YELLOW
			
			
			
	};
	
	public static Color[] getColors() {
		return colors;
	}
	
	public static Color getColorFromIndex(int index) {
		return colors[index];
	}

}
