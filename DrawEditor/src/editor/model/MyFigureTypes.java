package editor.model;

/*
 * 図形の種類に関する定義や、enumインスタンスの保持を行うクラス
 */
public class MyFigureTypes {
	
	/*
	 * 図形の種類ごとのenumをFigureTypeとして定義する
	 */
	public enum FigureType {LINE, CIRCLE, RECTANGLE, TRIANGLE};
	
	/*
	 * すべてのFigureTypeのインスタンスを保持する配列
	 */
	private static FigureType[] allFigureType = {FigureType.LINE, FigureType.CIRCLE, FigureType.RECTANGLE, FigureType.TRIANGLE};
	
	public static FigureType[] getAllFigureType() {
		return allFigureType;
	}
	
	public static FigureType getFigureTypeFromIndex(int index) {
		return allFigureType[index];
	}

}
