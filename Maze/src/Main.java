import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Main implements Runnable{
	
	Thread t;
	Boolean running;
	frame f;
	private BufferStrategy bs;
	private Graphics g;
	private String title;
	private KeyManager k;
	private Player p;
	private World w;
	private Polygon test;
	private int[] x;
	private int[] y;
	
	private GameState gs;
	private MenuState ms;
	private EndState es; 
	Main(String title){
		running = false;
		this.title = title;
		x = new int[] {500, 400, 400, 500};
		y = new int [] {000, 100, 400, 520};
		test = new Polygon(x, y, 4);
		Music.playSound("Res/MAZE.wav");
		
	}
	
	public void init() {
		p = new Player(10.0, 10.0, 10.0);
		w = new World("Res/world.txt", p);
		w.init();
		f = new frame(900, 695, title);
		k = new KeyManager();
		f.getCanvas().addKeyListener(k);
		gs = new GameState(p, w);
		ms = new MenuState(gs);
		es = new EndState(p, gs);
		State.setState(ms);
		
		
	}
	
	public void update() {
		State.getState().update();
		if(p.getGameState()) {
			State.setState(es);
		}
	}
	
	public void render() {
		bs = f.getCanvas().getBufferStrategy();
		if(bs == null) {
			f.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//draw here
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 750);
		


		State.getState().render(g);

		//end draw here
		bs.show();
		g.dispose();
	}
	public synchronized void stop() {
		if(running) {
			try {
				t.join();
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			running = false;
		}
		else {
			return;
		}
	}

	@Override
	public void run() {
		running = true;
		init();
		
		while(running) {
			update();
			render();
		}
		
		stop();
		
	}

}
