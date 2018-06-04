package editor.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class CircleFigure extends Figure{
	public CircleFigure(int x, int y, int w, int h, Color c, int lineWidth) {
		super(x, y, w, h, c, lineWidth);
		// 引数付きのコンストラクタは継承されないので，コンストラクタを定義．
		// superで親のコンストラクタを呼び出すだけ．
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.setColor(color);
		g2d.drawOval(x, y, width, height);
	}
}
