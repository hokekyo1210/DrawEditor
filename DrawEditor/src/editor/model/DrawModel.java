package editor.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

import editor.model.Figure;
import editor.model.RectangleFigure;

public class DrawModel extends Observable {
	protected ArrayList<Figure> fig;
	protected Figure drawingFigure;
	protected Color currentColor;

	public DrawModel() {
		fig = new ArrayList<Figure>();
		drawingFigure = null; // null は定数．C言語のNULLと同じで，何も入っていないという意味．
		currentColor = Color.red; // 色はとりあえず赤で固定．容易に変更可能に拡張できます．
	}

	public ArrayList<Figure> getFigures() {
		return fig;
	}

	public Figure getFigure(int idx) {
		return fig.get(idx);
	}

	public void createFigure(int x, int y) {
		Figure f = new RectangleFigure(x, y, 0, 0, currentColor);
		fig.add(f);
		drawingFigure = f;
		setChanged();
		notifyObservers();
	}

	public void reshapeFigure(int x1, int y1, int x2, int y2) {
		if (drawingFigure != null) {
			drawingFigure.reshape(x1, y1, x2, y2);
			setChanged();
			notifyObservers();
		}
	}
}