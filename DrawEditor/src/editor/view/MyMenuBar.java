package editor.view;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import editor.controller.MenuBarController;
import editor.model.MyColors;
import editor.model.MyFigureTypes;
import editor.model.MyFigureTypes.FigureType;

/*
 * JMenuBarを継承したクラス
 * メニューバーにアイテムを追加するメソッドなどを持つ
 */
public class MyMenuBar extends JMenuBar{
	
	private MenuBarController controller;
	
	public MyMenuBar(MenuBarController controller) {
		super();
		this.controller = controller;
		initMenuBar();
	}
	
	public void addMenuItem(JMenuItem menuItem, JMenu menu) {
		menuItem.addActionListener(controller);
		menu.add(menuItem);
	}
	
	public void initMenuBar() {
		JMenu menu1 = new JMenu("File");
		JMenu menu2 = new JMenu("Color");
		JMenu menu3 = new JMenu("Type");
		JMenu menu4 = new JMenu("Grid");
		JMenu menu5 = new JMenu("Line");
		
		setFileItems(menu1);
		setColorItems(menu2);
		setTypeItems(menu3);
		setGridItems(menu4);
		setLineItems(menu5);
		
		this.add(menu1);
		this.add(menu2);
		this.add(menu3);
		this.add(menu5);
		this.add(menu4);
	}
	
	public void setLineItems(JMenu menu) {
		addMenuItem(new JMenuItem("1"), menu);
		addMenuItem(new JMenuItem("2"), menu);
		addMenuItem(new JMenuItem("4"), menu);
		addMenuItem(new JMenuItem("8"), menu);
		addMenuItem(new JMenuItem("16"), menu);
		addMenuItem(new JMenuItem("others..."), menu);
	}
	
	public void setGridItems(JMenu menu) {
		addMenuItem(new JMenuItem("disable"), menu);
		addMenuItem(new JMenuItem("10"), menu);
		addMenuItem(new JMenuItem("20"), menu);
		addMenuItem(new JMenuItem("40"), menu);
		addMenuItem(new JMenuItem("80"), menu);
		addMenuItem(new JMenuItem("others..."), menu);
	}
	
	public void setFileItems(JMenu menu) {
		addMenuItem(new JMenuItem("New"), menu);
		addMenuItem(new JMenuItem("Open"), menu);
		addMenuItem(new JMenuItem("Save"), menu);
		addMenuItem(new JMenuItem("Save(Image)"), menu);
		addMenuItem(new JMenuItem("Exit"), menu);
	}
	
	public void setColorItems(JMenu menu) {
		Color[] colors = MyColors.getAllColors();
		for(int i = 0; i<colors.length; i++) {
			Color color = colors[i];
			JMenuItem menuItem = new JMenuItem("");
			menuItem.setName(i+"");
			menuItem.setBackground(color);
			addMenuItem(menuItem, menu);
		}
		JMenuItem menuItem = new JMenuItem("others...");
		menuItem.setName("other");
		addMenuItem(menuItem, menu);
	}
	
	public void setTypeItems(JMenu menu) {
		FigureType[] figureTypes = MyFigureTypes.getAllFigureType();
		for(int i = 0; i<figureTypes.length; i++) {
			FigureType figureType = figureTypes[i];
			JMenuItem menuItem = new JMenuItem(figureType.name());
			menuItem.setName(i+"");
			addMenuItem(menuItem, menu);
		}
	}

}
