package client;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindowListener implements WindowListener {

	@SuppressWarnings("unused")
	private GameWindow game;
	
	public GameWindowListener(GameWindow game) {
		this.game = game;
		System.out.println("Window listener attached to game window "+ game.getName());
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Game window has been activated"); // restored / switching back to window
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Game window has been closed"); // never called
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Game window is closing"); // window closed
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Game window has been deactivated"); // minimizing / switching to other window
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Game window has been deiconified"); // restored
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Game window has been iconified"); // minimized
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Game window has been opened"); // window created
	}

}
