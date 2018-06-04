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
		JMenuItem item1 = new JMenuItem("1");
		JMenuItem item2 = new JMenuItem("2");
		JMenuItem item3 = new JMenuItem("4");
		JMenuItem item4 = new JMenuItem("8");
		JMenuItem item5 = new JMenuItem("16");
		JMenuItem item6 = new JMenuItem("others...");
		item1.addActionListener(controller);
		item2.addActionListener(controller);
		item3.addActionListener(controller);
		item4.addActionListener(controller);
		item5.addActionListener(controller);
		item6.addActionListener(controller);
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		menu.add(item5);
		menu.add(item6);
	}
	
	public void setGridItems(JMenu menu) {
		JMenuItem item1 = new JMenuItem("10");
		JMenuItem item2 = new JMenuItem("20");
		JMenuItem item3 = new JMenuItem("40");
		JMenuItem item4 = new JMenuItem("80");
		JMenuItem item6 = new JMenuItem("others...");
		item1.addActionListener(controller);
		item2.addActionListener(controller);
		item3.addActionListener(controller);
		item4.addActionListener(controller);
		item6.addActionListener(controller);
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		menu.add(item6);
	}
	
	public void setFileItems(JMenu menu) {
		JMenuItem item1 = new JMenuItem("Open");
		JMenuItem item2 = new JMenuItem("Save");
		JMenuItem item3 = new JMenuItem("Save(Image)");
		JMenuItem item4 = new JMenuItem("New");
		item1.addActionListener(controller);
		item2.addActionListener(controller);
		item3.addActionListener(controller);
		item4.addActionListener(controller);
		menu.add(item4);
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
