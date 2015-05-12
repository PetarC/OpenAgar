package client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameRender extends JPanel {

	private int width;
	private int height;
	private GameWindow game;
	
	public GameRender(GameWindow game) {
		this.game = game;
		this.useListener(new GameInputListener(this));
	}
	
	private void useListener(GameInputListener listener) {
		this.addKeyListener(listener);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
	}
	
	@Override
	public void paint(Graphics g) {
		if (this.game.isGameActive())
			this.render((Graphics2D) g);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if (this.game.isGameActive())
			this.paint(g);
	}
	
	private void updateVariables() {
		this.width = this.game.getWidth();
		this.height = this.game.getHeight();
	}
	
	private void renderBackground(Graphics2D g) {
		/* Draw a blank white rectangle */
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
	}
	
	private void renderMousePoint(Graphics2D g) {
		/* Current mouse position */
		Point pos = this.getMousePosition();
		
		/* Draw mouse pointer */
		if (pos != null) {
			g.setColor(Color.BLACK);
			g.fillOval(pos.x - 2, pos.y - 2, 4, 4);
		}
	}
	
	private void render(Graphics2D g) {
		/* Update layout related variables */
		this.updateVariables();
		
		/* Draw the background */
		this.renderBackground(g);
		
		/* Draw the mouse */
		this.renderMousePoint(g);
	}
}
