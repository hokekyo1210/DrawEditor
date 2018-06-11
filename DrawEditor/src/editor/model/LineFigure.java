package editor.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;

/*
 * 直線図形の情報を保持するクラス
 */
public class LineFigure extends Figure{
	
	public LineFigure(int x, int y, int w, int h, Color c, int lineWidth) {
		super(x, y, w, h, c, lineWidth);
		// 引数付きのコンストラクタは継承されないので，コンストラクタを定義．
		// superで親のコンストラクタを呼び出すだけ．
	}
	
	/*
	 * 直線図形を描画するメソッド
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.setColor(color);
		g2d.drawLine(x, y, x+width, y+height);
	}
	
	/*
	 * バウンディングボックスを計算する元々のreshapeをオーバーライドする
	 * バウンディングボックスを計算せず、始点を固定したサイズおよび座標をセットする
	 */
	public void reshape(int x1, int y1, int x2, int y2) {
		int newx = x1;
		int newy = y1;
		int neww = x2 - x1;
		int newh = y2 - y1;
		setLocation(newx, newy);
		setSize(neww, newh);
	}
	

}
