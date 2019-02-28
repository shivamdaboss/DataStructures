import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Launcher {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Main app = new Main("Maze");
		Music m = new Music("Res/MAZE.wav");
		executor.execute(app);
		executor.shutdown();
	}
}
