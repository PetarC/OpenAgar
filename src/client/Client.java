package client;

public class Client {
	
	final public static String Version = "0.0.1";
	final public static String Name = "OpenAgar";
	
	final private int windowWidth = 500;
	final private int windowHeight = 500;
	
	public Client() {
		new GameWindow(this.windowWidth, this.windowHeight);
	}
}
