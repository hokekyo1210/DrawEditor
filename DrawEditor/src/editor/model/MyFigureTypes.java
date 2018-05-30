package editor.model;

public class MyFigureTypes {
	
	public enum FigureType {LINE, CIRCLE, RECTANGLE, TRIANGLE};
	
	private static FigureType[] allFigureType = {FigureType.LINE, FigureType.CIRCLE, FigureType.RECTANGLE, FigureType.TRIANGLE};
	
	public static FigureType[] getAllFigureType() {
		return allFigureType;
	}
	
	public static FigureType getFigureTypeFromIndex(int index) {
		return allFigureType[index];
	}

}
