package client;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindowListener implements WindowListener {

	private static final boolean DEBUG = false;
	private static String lastDebugMessage;
	
	private GameWindow game;
	
	public GameWindowListener(GameWindow game) {
		this.printDebug("Attached to the game window "+ game.getName());
		this.game = game;
		this.game.setGameActive(true);
	}
	
	@SuppressWarnings("unused")
	private void printDebug(String s) {
		if (DEBUG && s != null && (lastDebugMessage == null || !lastDebugMessage.equals(s))) {
			System.out.println("<GameWindowListener> "+ s);
			lastDebugMessage = s;
		}
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		this.game.setGameActive(true);
		this.printDebug("Window restored");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		this.game.setGameActive(false);		
		this.printDebug("Window closed");

	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.game.setGameActive(false);
		this.printDebug("Window is closing"); 
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		this.game.setGameActive(false);
		this.printDebug("Window paused");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		this.game.setGameActive(true);
		this.printDebug("Window restored");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		this.game.setGameActive(false);
		this.printDebug("Window paused");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		this.game.setGameActive(true);
		this.printDebug("Window created");
	}

}
