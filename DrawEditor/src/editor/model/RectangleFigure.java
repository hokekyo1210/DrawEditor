package editor.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import editor.model.Figure;

/*
 * 長方形図形の情報を保持するクラス
 */
public class RectangleFigure extends Figure {
	public RectangleFigure(int x, int y, int w, int h, Color c, int lineWidth) {
		super(x, y, w, h, c, lineWidth);
		// 引数付きのコンストラクタは継承されないので，コンストラクタを定義．
		// superで親のコンストラクタを呼び出すだけ．
	}
	
	/*
	 * 長方形図形を描画する
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.setColor(color);
		g2d.drawRect(x, y, width, height);
	}
}
