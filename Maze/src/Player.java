import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player {
	private double dim;
	private double x;
	private double y;
	private double tempX, tempY;
	private boolean up, down, left, right, reset;
	private long timeDelay;
	private boolean gameOver;
	private int moves;
	private int degrees, attempts;

	Player(double x, double y, double dim){
		this.x = x;
		this.y = y;
		this.dim = dim;
		timeDelay = 75;
		gameOver = false;
		moves = 0;
		attempts = 0;
		degrees = 0;
	}
	
	public void update() {
		if(KeyManager.keys[KeyEvent.VK_UP]) {
			System.out.println("up");
			up = true;
		}
		if(KeyManager.keys[KeyEvent.VK_LEFT]) {
			left = true;
		}
		if(KeyManager.keys[KeyEvent.VK_RIGHT]) {
			right = true;
		}
		if(KeyManager.keys[KeyEvent.VK_R]) {
			reset = true;
		}
		/*System.out.println("UP: " + up);
		System.out.println("DOWN: " + down);
		System.out.println("LEFT: " + left);
		System.out.println("RIGHT: " + right);*/
		
		if (reset) {
			reset();
			attempts++;
		}
		
		else if(collisionChecker(up, left, right)) {
			if(up) {
				switch(degrees) {
				case 0:
					 y += Tile.HEIGHT;
					 break;
				case 90: 
					 x += Tile.WIDTH;
					 break;
				case 180:
					 y -= Tile.HEIGHT;
					 break;
				case 270: 
					 x -= Tile.WIDTH;
					 break;
				}
				moves++;
				//del(timeDelay);
				gameOver = win();
			}
			else if(left) {
				rotate(true);
				//del(timeDelay);
				gameOver = win();
			}
			else if(right) {
				rotate(false);
				//del(timeDelay);
				gameOver = win();
			}
		}
		
		up = false;
		left = false;
		right = false;
		reset = false;
		KeyManager.keys[KeyEvent.VK_UP] = false;
		KeyManager.keys[KeyEvent.VK_RIGHT] = false;
		KeyManager.keys[KeyEvent.VK_LEFT] = false;
		KeyManager.keys[KeyEvent.VK_R] = false;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect( (int) 20, (int) 20, (int)dim, (int)dim);
		g.setColor(Color.black);
		switch(degrees) {
		case 0:
			g.drawLine((int) 25, (int) (30),  (int)25, (int)25);
			break;
		case 90: 
			g.drawLine((int) 25, (int) (25),  (int)30, (int)25);
			break;
		case 180:
			g.drawLine((int) 25, (int) (20),  (int)25, (int)25);
			break;
		case 270: 
			g.drawLine((int) 20, (int) (25),  (int)25, (int)25);
			break;
		}
		
	}
	
	public boolean collisionChecker(boolean up, boolean left, boolean right) {
		
		if(up) {
			switch(degrees) {
				case 0:
					return m(y + Tile.HEIGHT, x);	
				case 90: 
					return m(y, x + Tile.WIDTH);
				case 180:
					return m(y - Tile.HEIGHT, x);
				case 270: 
					return m(y, x - Tile.WIDTH);
			}
		}
		else if(left) {
			return true;
		}
		else if(right) {
			return true;
		}
		//System.out.println("checked");
		return false;
	}
	
	
	
	public boolean m(double y, double x) {
		tempY = y;
		tempX = x;
		for(int i = 0; i < World.tiles.size(); i++) {
			if(tempY == World.tiles.get(i).getY() && tempX == World.tiles.get(i).getX()) {
				if(World.tiles.get(i).getSolidity()) {
					//System.out.println("false");
					tempY = 0;
					tempX = 0;
					return false;
				}
				else {
					//System.out.println("true");
					tempY = 0;
					tempX = 0;
					return true;
				}
				
			}
			
		}
		tempY = 0;
		tempX = 0;
		return false;
	}
	
	public void del(long delta) {
		long start = System.currentTimeMillis();
		long cur = System.currentTimeMillis();
		while(!(cur >= start + delta)) {
			cur = System.currentTimeMillis();
		}
	}
	
	
	public boolean win() {
		for(int i = 0; i < World.tiles.size(); i++) {
			if(World.tiles.get(i).getToken().equals("E")) {
				if(x == World.tiles.get(i).getX() && y == World.tiles.get(i).getY()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean getGameState() {
		return gameOver;
	}
	
	
	public int getMoveCount() {
		return moves;
	}
	
	public void rotate(boolean left) {
		if(left) {
			degrees += 90;
			if(degrees == 360) {
				degrees = 0;
			}
			//del(timeDelay);
		}
		else {
			degrees -= 90;
			if(degrees == -90) {
				degrees = 270;
			}
			//del(timeDelay); 
		}
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	public int getDegree() {
		return degrees;
	}
	
	public int getAttemptCount() {
		return attempts;
	}
	
	public void reset() {
		gameOver = false;
		x = 10;
		y = 10;
		degrees = 0;
		moves = 0;
	}
}
