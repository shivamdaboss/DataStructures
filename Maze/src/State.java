import java.awt.Graphics;

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State s) {
		currentState = s;
	}
	
	public static State getState() {
		return currentState;
	}
	
	public State() {
		
	}
	
	
	
	
	public abstract void render(Graphics g);
	
	public abstract void update();
}
