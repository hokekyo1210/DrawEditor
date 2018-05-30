package editor.view;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import editor.controller.MenuBarController;
import editor.model.MyColors;
import editor.model.MyFigureTypes;
import editor.model.MyFigureTypes.FigureType;

public class MyMenuBar extends JMenuBar{
	
	private MenuBarController controller;
	
	public MyMenuBar(MenuBarController controller) {
		super();
		this.controller = controller;
		initMenuBar();
	}
	
	public void initMenuBar() {
		JMenu menu1 = new JMenu("File");
		JMenu menu2 = new JMenu("Color");
		JMenu menu3 = new JMenu("Type");
		
		setFileItems(menu1);
		setColorItems(menu2);
		setTypeItems(menu3);
		
		this.add(menu1);
		this.add(menu2);
		this.add(menu3);
	}
	
	public void setFileItems(JMenu menu) {
		JMenuItem item1 = new JMenuItem("Open");
		JMenuItem item2 = new JMenuItem("Save");
		JMenuItem item3 = new JMenuItem("Save(Image)");
		item1.addActionListener(controller);
		item2.addActionListener(controller);
		item3.addActionListener(controller);
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
	}
	
	public void setColorItems(JMenu menu) {
		Color[] colors = MyColors.getColors();
		for(int i = 0; i<colors.length; i++) {
			Color color = colors[i];
			JMenuItem menuItem = new JMenuItem("");
			menuItem.setName(i+"");
			menuItem.setBackground(color);
			menuItem.addActionListener(controller);
			menu.add(menuItem);
		}
		JMenuItem menuItem = new JMenuItem("others...");
		menuItem.setName("other");
		menuItem.addActionListener(controller);
		menu.add(menuItem);
	}
	
	public void setTypeItems(JMenu menu) {
		FigureType[] figureTypes = MyFigureTypes.getAllFigureType();
		for(int i = 0; i<figureTypes.length; i++) {
			FigureType figureType = figureTypes[i];
			JMenuItem menuItem = new JMenuItem(figureType.name());
			menuItem.setName(i+"");
			menuItem.addActionListener(controller);
			menu.add(menuItem);
		}
	}

}
