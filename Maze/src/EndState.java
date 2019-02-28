import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class EndState extends State{
	Player p;
	GameState gs;
	public EndState(Player p, GameState gs) {
		this.p = p;
		this.gs = gs;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 690);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Apple Chancery", Font.PLAIN, 50));
		g.drawString("Great Job", 330, 300);
		g.setFont(new Font("TimesRoman", Font.ITALIC, 50));
		g.drawString("Shivam's Labrynth", 260, 200);
		
		g.setFont(new Font("Courier New", Font.PLAIN, 40));
		g.drawString("Press the spacebar to restart", 100, 500);
		
		g.drawString("Attempts: " + p.getAttemptCount(), 150, 600);
		g.drawString("Moves: " + p.getMoveCount(), 550, 600);
		
		
	}

	@Override
	public void update() {
		if(KeyManager.keys[KeyEvent.VK_SPACE]) {
			System.out.println("SpACE");
			gs.reset();
			State.setState(gs);
			System.out.println("State Set...");
		}
		KeyManager.keys[KeyEvent.VK_SPACE] = false;
	}
}
