package client;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private GameWindowListener windowListener;

	public GameWindow(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.prepareWindow();
	}
	
	private void prepareWindow() {
		this.setTitle(this.getName());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(this.x, this.y);
		this.setResizable(false);
		this.setSize(this.width, this.height);
		this.setVisible(true);
		
		this.windowListener = new GameWindowListener(this);
		this.addWindowListener(this.windowListener);
	}
	
	@Override
	public String getName() {
		return Client.Name +" - "+ Client.Version;
	}
	
}
