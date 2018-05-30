package editor.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import editor.model.DrawModel;
import editor.model.MyColors;

public class MenuBarController implements ActionListener{
	
	private DrawModel drawModel;
	
	public MenuBarController(DrawModel drawModel) {
		this.drawModel = drawModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!(e.getSource() instanceof JMenuItem))return;
		JMenuItem menuItem = (JMenuItem) e.getSource();
		int colorIndex = Integer.parseInt(menuItem.getName());
		Color color = MyColors.getColorFromIndex(colorIndex);
		drawModel.setCurrentColor(color);
	}

}
