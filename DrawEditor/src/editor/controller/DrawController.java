package editor.controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import editor.model.DrawModel;

public class DrawController implements MouseListener, MouseMotionListener {
	protected DrawModel model;
	protected int dragStartX, dragStartY;

	public DrawController(DrawModel a) {
		model = a;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		Point convertedPoint = GridManager.convertedGridPoint(e.getX(), e.getY());
		dragStartX = convertedPoint.x;
		dragStartY = convertedPoint.y;
		model.createFigure(dragStartX, dragStartY);
	}

	public void mouseDragged(MouseEvent e) {
		Point convertedPoint = GridManager.convertedGridPoint(e.getX(), e.getY());
		model.reshapeFigure(dragStartX, dragStartY, convertedPoint.x, convertedPoint.y);
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}
}
