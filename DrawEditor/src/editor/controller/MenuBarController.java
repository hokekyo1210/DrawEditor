package editor.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
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
		if(parentType.equalsIgnoreCase("File")) {
			actionPerformedFromFile(e, menuItem);
		}else if(parentType.equalsIgnoreCase("Color")) {
			actionPerformedFromColor(e, menuItem);
		}else if(parentType.equalsIgnoreCase("Type")) {
			actionPerformedFromFigureType(e,menuItem);
		}
		
	}
	
	public void actionPerformedFromFile(ActionEvent e, JMenuItem menuItem) {
		String itemName = menuItem.getText();
		JFileChooser fileChooser = new JFileChooser();
		
		if(itemName.equalsIgnoreCase("open")) {
			int selected = fileChooser.showOpenDialog(null);
			if(selected != JFileChooser.APPROVE_OPTION)return;
			File targetFile = fileChooser.getSelectedFile();
			try {
				drawModel.loadFigures(targetFile);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if(itemName.equalsIgnoreCase("save")) {
			int selected = fileChooser.showSaveDialog(null);
			if(selected != JFileChooser.APPROVE_OPTION)return;
			File targetFile = fileChooser.getSelectedFile();
			try {
				drawModel.saveAllFigures(targetFile);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
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
