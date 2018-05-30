package editor.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import editor.model.DrawModel;
import editor.model.MyColors;
import editor.model.MyFigureTypes;
import editor.model.MyFigureTypes.FigureType;

public class MenuBarController implements ActionListener{
	
	private DrawModel drawModel;
	
	public MenuBarController(DrawModel drawModel) {
		this.drawModel = drawModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!(e.getSource() instanceof JMenuItem))return;
		JMenuItem menuItem = (JMenuItem) e.getSource();
		JMenu parent = (JMenu)((JPopupMenu)menuItem.getParent()).getInvoker();
		String parentType = parent.getText();
		if(parentType.equalsIgnoreCase("Color")) {
			actionPerformedFromColor(e, menuItem);
		}else if(parentType.equalsIgnoreCase("Type")) {
			actionPerformedFromFigureType(e,menuItem);
		}
		
	}
	
	public void actionPerformedFromColor(ActionEvent e, JMenuItem menuItem) {
		Color color;
		if(menuItem.getName().equalsIgnoreCase("other")) {
			color = JColorChooser.showDialog(menuItem, "Choose Color!", Color.WHITE);
		}else {
			int colorIndex = Integer.parseInt(menuItem.getName());
			color = MyColors.getColorFromIndex(colorIndex);
		}
		drawModel.setCurrentColor(color);
	}
	
	public void actionPerformedFromFigureType(ActionEvent e, JMenuItem menuItem) {
		String figureTypeName = menuItem.getText();
		FigureType figureType = FigureType.valueOf(figureTypeName);
		drawModel.setCurrentFigureType(figureType);
	}

}
