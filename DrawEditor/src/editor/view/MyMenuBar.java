package editor.view;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import editor.controller.MenuBarController;
import editor.model.MyColors;

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
		
		setColorItems(menu2);
		
		this.add(menu1);
		this.add(menu2);
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
	}

}
