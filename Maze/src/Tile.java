import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Tile {
	public static double HEIGHT = 10.0;
	public static double WIDTH = 10.0;
	private double x, y;
	private boolean solid;
	private Player p;
	private String s;
	private Polygon wallLeft, wallRight, floor, blocker;
	private boolean forwardBlocked, leftBlocked, rightBlocked;
	
	Tile(double x, double y, boolean solid, Player p, String s){
		this.x = x;
		this.y = y;
		this.p = p;
		this.solid = solid;
		this.s = s;
	}
	public void render(Graphics g, int distance) {
		
			
	}
	
	public boolean getSolidity() {
		return solid;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	public String getToken() {
		return s;
	}
	public void context(boolean forwardBlocked, boolean leftBlocked, boolean rightBlocked) {
		this.forwardBlocked = forwardBlocked;
		this.leftBlocked = leftBlocked;
		this.rightBlocked = rightBlocked;
	}
	
}
