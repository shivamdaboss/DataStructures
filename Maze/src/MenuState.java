import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class MenuState extends State{
	private GameState gs;
	public MenuState(GameState gs) {
		this.gs = gs;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 900, 695);
		g.setFont(new Font("Apple Chancery", Font.ITALIC, 50));
		g.setColor(Color.BLACK);
		g.drawString("Shivam's Labrynth", 275, 200);
		
		g.setFont(new Font("Courier New", Font.PLAIN, 40));
		g.drawString("Press the spacebar to begin", 135, 500);
	}

	@Override
	public void update() {
		if(KeyManager.keys[KeyEvent.VK_SPACE]) {
			State.setState(gs);
		}
		KeyManager.keys[KeyEvent.VK_SPACE] = false;
	}
	
	
}
