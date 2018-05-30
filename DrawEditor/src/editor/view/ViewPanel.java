package editor.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import editor.controller.DrawController;
import editor.model.DrawModel;
import editor.model.Figure;

public class ViewPanel extends JPanel implements Observer {
	protected DrawModel model;

	public ViewPanel(DrawModel m, DrawController c) {
		this.setBackground(Color.white);
		this.addMouseListener(c);
		this.addMouseMotionListener(c);
		model = m;
		model.addObserver(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ArrayList<Figure> fig = model.getFigures();
		for (int i = 0; i < fig.size(); i++) {
			Figure f = fig.get(i);
			f.draw(g);
		}
	}

	public void update(Observable o, Object arg) {
		repaint();
	}
}
