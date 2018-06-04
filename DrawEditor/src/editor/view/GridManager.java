package editor.view;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class GridManager {
	
	public static final int gridWidth = 40;
	public static final int gridHeight = 40;
	
	public static Point convertedGridPoint(int realX, int realY) {
		int x = realX + gridWidth/2;
		int y = realY + gridHeight/2;
		x/= gridWidth;
		y/= gridHeight;
		x*= gridWidth;
		y*= gridHeight;
		return new Point(x, y);
	}
	
	public static void paintGrid(JPanel panel, Graphics g) {
		for(int x = 0; x < panel.getWidth(); x+= gridWidth) {
			g.drawLine(x, 0, x, panel.getHeight());
		}
		
		for(int y = 0; y < panel.getHeight(); y+= gridHeight) {
			g.drawLine(0, y, panel.getWidth(), y);
		}
	}

}
