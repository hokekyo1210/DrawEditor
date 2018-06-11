package editor.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/*
 * グリッド機能に関するstaticメソッドおよびstatic変数を持つクラス
 */
public class GridManager {
	
	public static int gridWidth = 40;///グリッド幅
	public static int gridHeight = 40;
	
	/*
	 * 入力された座標をグリッド上の最も近い点の座標として返す
	 */
	public static Point convertedGridPoint(int realX, int realY) {
		if(gridWidth == 0) {
			return new Point(realX, realY);
		}
		int x = realX + gridWidth/2;
		int y = realY + gridHeight/2;
		x/= gridWidth;
		y/= gridHeight;
		x*= gridWidth;
		y*= gridHeight;
		return new Point(x, y);
	}
	
	public static void setGridSize(int gridSize) {
		GridManager.gridWidth = gridSize;
		GridManager.gridHeight = gridSize;
	}
	
	/*
	 * panelにグリッドを描画する
	 */
	public static void paintGrid(JPanel panel, Graphics g) {
		if(gridWidth == 0) {
			return;
		}
		g.setColor(new Color(192, 192, 192,60));
		for(int x = 0; x < panel.getWidth(); x+= gridWidth) {
			g.drawLine(x, 0, x, panel.getHeight());
		}
		
		for(int y = 0; y < panel.getHeight(); y+= gridHeight) {
			g.drawLine(0, y, panel.getWidth(), y);
		}
	}

}
