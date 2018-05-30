package editor.view;

import java.awt.Color;

import javax.swing.JFrame;

import editor.controller.DrawController;
import editor.model.DrawModel;
import editor.view.ViewPanel;

public class DrawEditor extends JFrame {
	DrawModel model;
	ViewPanel view;
	DrawController cont;

	public DrawEditor() {
		model = new DrawModel();
		cont = new DrawController(model);
		view = new ViewPanel(model, cont);
		this.setBackground(Color.black);
		this.setTitle("Draw Editor");
		this.setSize(500, 500);
		this.add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
