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

/*
 * 図形に関する変更を通達するObservable
 * および現在描画している図形の情報を保持するクラス
 */
public class DrawModel extends Observable {
	protected ArrayList<Figure> fig; //Figureオブジェクトが格納される動的配列
	protected Figure drawingFigure;
	protected Color currentColor;
	protected FigureType currentFigureType;
	protected int currentLineWidth;
	
	private JFrame frame;

	public DrawModel(JFrame frame) {
		fig = new ArrayList<Figure>();
		drawingFigure = null; // null は定数．C言語のNULLと同じで，何も入っていないという意味．
		currentColor = Color.red; // 色はとりあえず赤で固定．容易に変更可能に拡張できます．
		currentFigureType = FigureType.RECTANGLE; //初期は長方形
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
	public void setCurrentLineWidth(int lineWidth) {
		this.currentLineWidth = lineWidth;
	}
	
	/*
	 * figリストからすべてのFigureオブジェクトを削除する
	 */
	public void clearAllFigure() {
		fig.clear();
		setChanged();
		notifyObservers();
	}
	
	/*
	 * file(テキストファイル)にfigリストに含まれるすべてのFigureオブジェクトを保存する
	 */
	public void saveAllFigures(File file) throws Exception {
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(fig);
		out.flush();
		out.close();
	}
	
	/*
	 * targetFile(画像ファイル)にfigリストに含まれるすべてのFigureオブジェクトを描画し、pngイメージとして保存する
	 */
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
	
	/*
	 * file(テキストファイル)に含まれるすべてのFigureオブジェクトの情報を入力し、figリストに入れる
	 */
	public void loadFigures(File file) throws Exception{
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(file));
		fig = (ArrayList<Figure>)in.readObject();
		in.close();
		setChanged();
		notifyObservers();
	}

	/*
	 * ドラッグの始点が(x,y)である各種Figureオブジェクト(インスタンス)を作成し、figリストに追加する
	 * 作成されたことを全てのObserverに通達する
	 */
	public void createFigure(int x, int y) {
		Figure f;
		switch (currentFigureType) {///図形の形をセットする
			case RECTANGLE:
				f = new RectangleFigure(x, y, 0, 0, currentColor, currentLineWidth);
				break;
			case CIRCLE:
				f = new CircleFigure(x, y, 0, 0, currentColor, currentLineWidth);
				break;
			case TRIANGLE:
				f = new TriangleFigure(x, y, 0, 0, currentColor, currentLineWidth);
				break;
			case LINE:
				f = new LineFigure(x, y, 0, 0, currentColor, currentLineWidth);
				break;
			default:
				return;
		}
		
		fig.add(f);
		drawingFigure = f;
		setChanged();
		notifyObservers();
	}

	/*
	 * 現在描画しているFigureオブジェクトのreshapeメソッドを呼ぶ
	 * また、すべてのObserverに変更を通達する
	 */
	public void reshapeFigure(int x1, int y1, int x2, int y2) {
		if (drawingFigure != null) {
			drawingFigure.reshape(x1, y1, x2, y2);
			setChanged();
			notifyObservers();
		}
	}
}