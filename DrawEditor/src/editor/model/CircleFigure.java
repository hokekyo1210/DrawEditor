package editor.model;

import java.awt.Color;
import java.awt.Graphics;

public class CircleFigure extends Figure{
	public CircleFigure(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		// 引数付きのコンストラクタは継承されないので，コンストラクタを定義．
		// superで親のコンストラクタを呼び出すだけ．
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.drawOval(x, y, width, height);
	}
}
