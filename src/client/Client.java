package client;

public class Client {
	
	final public static String Version = "0.0.1";
	final public static String Name = "OpenAgar";
	
	final private int windowWidth = 800;
	final private int windowHeight = 800;
	
	public Client() {
		new GameWindow(0, 0, this.windowWidth, this.windowHeight);
	}
}
