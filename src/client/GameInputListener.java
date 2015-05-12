package client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameInputListener implements KeyListener, MouseListener, MouseMotionListener {
	
	private GameRender render;
	
	public GameInputListener(GameRender render) {
		this.render = render;
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {

	}

	@Override
	public void mouseEntered(MouseEvent event) {

	}

	@Override
	public void mouseExited(MouseEvent event) {

	}

	@Override
	public void mousePressed(MouseEvent event) {

	}

	@Override
	public void mouseReleased(MouseEvent event) {

	}

	@Override
	public void keyPressed(KeyEvent event) {

	}

	@Override
	public void keyReleased(KeyEvent event) {

	}

	@Override
	public void keyTyped(KeyEvent event) {

	}

	@Override
	public void mouseDragged(MouseEvent event) {
		this.render.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		this.render.repaint();
	}

}
