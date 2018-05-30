package editor.model;

import java.awt.Color;
import java.awt.Graphics;

public class TriangleFigure extends Figure{
	public TriangleFigure(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		// 引数付きのコンストラクタは継承されないので，コンストラクタを定義．
		// superで親のコンストラクタを呼び出すだけ．
	}

	public void draw(Graphics g) {
		g.setColor(color);
		int hx = (x+width/2);
		g.drawLine(hx, y, x, y+height);
		g.drawLine(x, y+height, x+width, y+height);
		g.drawLine(hx, y, x+width, y+height);
	}
}
