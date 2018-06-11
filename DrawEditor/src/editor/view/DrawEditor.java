package editor.view;

import java.awt.Color;
import java.awt.MenuBar;

import javax.swing.JFrame;

import editor.controller.DrawController;
import editor.controller.MenuBarController;
import editor.model.DrawModel;
import editor.view.ViewPanel;

/*
 * JFrameを継承したクラス
 * MVCを繋ぎ合わせる役目を持つ
 * メニューバーを持つ
 */
public class DrawEditor extends JFrame {
	private DrawModel model;
	private ViewPanel view;
	private DrawController cont;
	private MenuBarController menuBarController;
	
	private MyMenuBar menuBar;

	public DrawEditor() {
		model = new DrawModel(this);
		cont = new DrawController(model);
		view = new ViewPanel(model, cont);
		menuBarController = new MenuBarController(model, view);
		menuBar = new MyMenuBar(menuBarController);
		this.setBackground(Color.black);
		this.setTitle("Draw Editor");
		this.setJMenuBar(menuBar);
		this.setSize(500, 500);
		this.add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
