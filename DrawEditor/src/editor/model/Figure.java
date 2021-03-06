package editor.model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/*
 * 図形の情報を保持する基本クラス
 */
public class Figure implements Serializable{
	protected int x, y, width, height;
	protected int lineWidth;
	protected Color color;

	public Figure(int x, int y, int w, int h, Color c, int lineWidth) {
		this.x = x;
		this.y = y; // this.x, this.y はインスタンス変数を指します．
		width = w;
		height = h; // ローカル変数で同名の変数がある場合は，this
		color = c; // を付けると，インスタンス変数を指すことになります．
		this.lineWidth = lineWidth;
	}

	public void draw(Graphics g) {
	}

	public void setSize(int w, int h) {
		width = w;
		height = h;
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/*
	 * (x1,y1)および(x2,y2)を内包する最小の長方形(バウンディングボックス)を計算する
	 */
	public void reshape(int x1, int y1, int x2, int y2) {
		int newx = Math.min(x1, x2);
		int newy = Math.min(y1, y2);
		int neww = Math.abs(x1 - x2);
		int newh = Math.abs(y1 - y2);
		setLocation(newx, newy);
		setSize(neww, newh);
	}
}
