package client;

import java.awt.Cursor;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	
	private int width;
	private int height;
	
	private boolean active = false;

	public GameWindow(int width, int height) {
		this.width = width;
		this.height = height;
		this.prepareWindow();
		this.setWindowCentered();
	}
	
	public void setWindowCentered() {
		int displayWidth = this.width;
		int displayHeight = this.height;
		
		try {
			GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			displayWidth = gd.getDisplayMode().getWidth();
			displayHeight = gd.getDisplayMode().getHeight();
		}
		catch (Exception e) { }
		
		this.setLocation((displayWidth - width) / 2, (displayHeight - height) / 2);
	}
	
	private void prepareWindow() {
		/* Prepare the window */
		this.setTitle(this.getName());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(0, 0);
		this.setResizable(false);
		this.setSize(this.width, this.height);
		this.setVisible(true);
		
		/* Hide the cursor */
		this.overwriteCursor();
		
		/* Attach panel and listener */
		this.addWindowListener(new GameWindowListener(this));
		this.setContentPane(new GameRender(this));
	}
	
	private void overwriteCursor() {
		BufferedImage image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "Blank");
		this.setCursor(blankCursor);
	}
	
	public void setGameActive(boolean active) {
		if (this.active != active) {
			this.active = active;
			this.enableInputMethods(active);
			System.out.println("<GameWindow> Set active to "+ active);
		}
	}
	
	public boolean isGameActive() {
		return this.active;
	}
	
	@Override
	public String getName() {
		return Client.Name +" - "+ Client.Version;
	}

}
