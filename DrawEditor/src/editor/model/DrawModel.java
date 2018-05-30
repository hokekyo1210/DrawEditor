package editor.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import editor.model.Figure;
import editor.model.MyFigureTypes.FigureType;
import editor.model.RectangleFigure;

public class DrawModel extends Observable {
	protected ArrayList<Figure> fig;
	protected Figure drawingFigure;
	protected Color currentColor;
	protected FigureType currentFigureType;
	
	private JFrame frame;

	public DrawModel(JFrame frame) {
		fig = new ArrayList<Figure>();
		drawingFigure = null; // null は定数．C言語のNULLと同じで，何も入っていないという意味．
		currentColor = Color.red; // 色はとりあえず赤で固定．容易に変更可能に拡張できます．
		currentFigureType = FigureType.RECTANGLE;
		this.frame = frame;
	}

	public ArrayList<Figure> getFigures() {
		return fig;
	}

	public Figure getFigure(int idx) {
		return fig.get(idx);
	}
	
	public void setCurrentColor(Color color) {
		this.currentColor = color;
	}
	public void setCurrentFigureType(FigureType figureType) {
		this.currentFigureType = figureType;
	}
	
	public void saveAllFigures(File file) throws Exception {
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(fig);
		out.flush();
		out.close();
	}
	
	public void saveAllFiguresAsImage(File targetFile) throws Exception {
		BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		for(Figure figure : fig) {
			figure.draw(g2d);
		}
		ImageIO.write(image, "png", targetFile);
	}
	
	public void loadFigures(File file) throws Exception{
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(file));
		fig = (ArrayList<Figure>)in.readObject();
		in.close();
		setChanged();
		notifyObservers();
	}

	public void createFigure(int x, int y) {
		Figure f;
		switch (currentFigureType) {///図形の形をセットする
			case RECTANGLE:
				f = new RectangleFigure(x, y, 0, 0, currentColor);
				break;
			case CIRCLE:
				f = new CircleFigure(x, y, 0, 0, currentColor);
				break;
			case TRIANGLE:
				f = new TriangleFigure(x, y, 0, 0, currentColor);
				break;
			case LINE:
				f = new LineFigure(x, y, 0, 0, currentColor);
				break;
			default:
				return;
		}
		
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