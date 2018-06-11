package editor.model;

import java.awt.Color;

/*
 * 描画の標準色として利用できるすべての色をColorオブジェクトとして保持するクラス
 */
public class MyColors {
	
	/*
	 * 標準色のColorオブジェクトを入れた配列
	 */
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
			Color.YELLOW,
			Color.GREEN
			
			
	};
	
	/*
	 * 全ての標準色を返す
	 */
	public static Color[] getAllColors() {
		return colors;
	}
	
	/*
	 * 配列の添え字に該当するColorオブジェクトを返す
	 */
	public static Color getColorFromIndex(int index) {
		return colors[index];
	}

}
