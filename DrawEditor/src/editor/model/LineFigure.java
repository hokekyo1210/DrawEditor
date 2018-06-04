package editor.model;

import java.awt.Color;
import java.awt.Graphics;

public class LineFigure extends Figure{
	
	public LineFigure(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		// 引数付きのコンストラクタは継承されないので，コンストラクタを定義．
		// superで親のコンストラクタを呼び出すだけ．
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(x, y, x+width, y+height);
	}
	
	public void reshape(int x1, int y1, int x2, int y2) {
		int newx = x1;
		int newy = y1;
		int neww = x2 - x1;
		int newh = y2 - y1;
		setLocation(newx, newy);
		setSize(neww, newh);
	}
	

}
