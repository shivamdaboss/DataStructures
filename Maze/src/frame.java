import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class frame{
	private int height;
	private int width; 
	private String title;
	private JFrame frame;
	private Canvas canvas;
	frame(int height, int width, String title){
		this.height = height;
		this.width  = width;
		this.title = title;
		frame = new JFrame();
		canvas = new Canvas();
		frameInit();
		panelInit();
	}
	public void frameInit() {
		frame.setSize(height, width);
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	public void panelInit() {
		canvas.setPreferredSize(new Dimension(height, width));
		canvas.setMaximumSize(new Dimension(height, width));
		canvas.setMinimumSize(new Dimension(height, width));
		
		frame.add(canvas);
		frame.pack();
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

}
