package editor.controller;

import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import editor.model.DrawModel;
import editor.model.MyColors;
import editor.model.MyFigureTypes;
import editor.model.MyFigureTypes.FigureType;
import editor.view.GridManager;
import editor.view.ViewPanel;

public class MenuBarController implements ActionListener{
	
	private DrawModel drawModel;
	private ViewPanel viewPanel;
	
	public MenuBarController(DrawModel drawModel, ViewPanel viewPanel) {
		this.drawModel = drawModel;
		this.viewPanel = viewPanel;
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
		}else if(parentType.equalsIgnoreCase("Grid")) {
			actionPerformedFromGrid(e,menuItem);
		}else if(parentType.equalsIgnoreCase("Line")) {
			actionPerformedFromLine(e, menuItem);
		}
		viewPanel.repaint();
	}
	
	private File setExtension(File file) {
		String fileName = file.getName();
		if(fileName.indexOf(".png") == -1) {
			return new File(file.getAbsolutePath() + ".png");
		}else {
			return file;
		}
	}
	
	public void actionPerformedFromLine(ActionEvent e, JMenuItem menuItem) {
		String itemName = menuItem.getText();
		if(itemName.indexOf("other") != -1) {
			itemName = JOptionPane.showInputDialog("数値を入力してください。");
		}
		try {
			int lineWidth = Integer.parseInt(itemName);
			drawModel.setCurrentLineWidth(lineWidth);
		}catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void actionPerformedFromGrid(ActionEvent e, JMenuItem menuItem) {
		String itemName = menuItem.getText();
		if(itemName.indexOf("other") != -1) {
			itemName = JOptionPane.showInputDialog("数値を入力してください。");
		}
		try {
			int gridSize = Integer.parseInt(itemName);
			GridManager.setGridSize(gridSize);
		}catch (Exception exception) {
			exception.printStackTrace();
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
		}else if(itemName.equalsIgnoreCase("Save(Image)")) {
			int selected = fileChooser.showSaveDialog(null);
			if(selected != JFileChooser.APPROVE_OPTION)return;
			File targetFile = fileChooser.getSelectedFile();
			targetFile = setExtension(targetFile);
			try {
				drawModel.saveAllFiguresAsImage(targetFile);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if(itemName.equalsIgnoreCase("New")) {
			drawModel.clearAllFigure();
		}else if(itemName.equalsIgnoreCase("Exit")) {
			System.exit(0);
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
