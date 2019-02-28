import java.awt.Color;
import java.awt.Graphics;

public class GameState extends State{
	
	Player p;
	World w;
	
	public GameState(Player p, World w) {
		this.p = p;
		this.w  = w;
	}

	@Override
	public void render(Graphics g) {
		w.render(g);
		p.render(g);
		g.setColor(Color.RED);
		g.drawString("MOVES: " + p.getMoveCount(), 5, 690); 
		
		g.drawString("TO RESTART, PRESS R", 375, 690);
		
		g.drawString("ATTEMPTS: " + p.getAttemptCount(), 800, 690);
		
	}

	@Override
	public void update() {
		p.update();
		w.update();
		
	}
	
	public void reset() {
		System.out.println("Resetting...");
		p.reset();
		System.out.println("Finished...");
	}

}
