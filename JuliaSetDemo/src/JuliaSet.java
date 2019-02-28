import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
public class JuliaSet extends JPanel implements AdjustmentListener,ActionListener
{
	JFrame frame;
	JScrollBar[] scrollBar;
	JScrollBar zoomScroll; 
	JScrollBar AScroll; 
	JScrollBar BScroll; 
	double A=0, B=0;
	String zoomString, AString, BString, colorOneString, colorTwoString, colorThreeString;
	float zoom;
	JButton invert;
	float[] color;
	boolean flip=true;
	int w, h;
	BufferedImage image; 
	float maxValue = 300;
	JLabel zoomLabel, ALabel, BLabel, colorOneLabel, colorTwoLabel, colorThreeLabel;
	JPanel onePanel, scrollPanel, otherScrollPanel, twoPanel, labelPanel;
	public JuliaSet()
	{	//setting up variables
		frame=new JFrame("Julia Set Program");
		frame.add(this);
		color=new float[3];
		scrollBar=new JScrollBar[3];
		invert=new JButton("DEFAULT");

		invert.addActionListener(this);

		scrollPanel=new JPanel();
		scrollPanel.setLayout(new GridLayout(1,3));
		//setting up color scroll bars
		for(int x=0;x<3;x++)
		{
			scrollBar[x]=new JScrollBar(JScrollBar.VERTICAL,255,0,0,255);
			scrollBar[x].addAdjustmentListener(this);
			scrollBar[x].setUnitIncrement(1);


			scrollPanel.add(scrollBar[x]);
		}
		
		onePanel= new JPanel();
		onePanel.setLayout(new BorderLayout());
		onePanel.add(scrollPanel,BorderLayout.CENTER);
		onePanel.add(invert,BorderLayout.SOUTH);

		frame.add(onePanel,BorderLayout.EAST);

		//setting up zoom, A, and B 
		zoomScroll = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 200);
		zoomScroll.addAdjustmentListener(this);
		zoomScroll.setUnitIncrement(1);
		
		AScroll = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, -1000,1000);
		AScroll.addAdjustmentListener(this);
		AScroll.setUnitIncrement(1);
		
		BScroll = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, -1000,1000);
		BScroll.addAdjustmentListener(this);
		BScroll.setUnitIncrement(1);
		
		otherScrollPanel = new JPanel();
		otherScrollPanel.setLayout(new GridLayout(3, 1));
		otherScrollPanel.add(zoomScroll);
		otherScrollPanel.add(AScroll);
		otherScrollPanel.add(BScroll);
		
		
		colorOneString = "HUE: " + color[0];
		colorTwoString = "SATURATION: " + color[1];
		colorThreeString = "BRIGHTNESS: " + color[2];
		BString = "B: " + B;
		AString = "A: " + A;
		zoomString = "ZOOM: " + zoom;
		zoomLabel = new JLabel(zoomString);
		ALabel = new JLabel(AString);
		BLabel = new JLabel(BString);
		colorOneLabel = new JLabel(colorOneString);
		colorTwoLabel = new JLabel(colorTwoString);
		colorThreeLabel = new JLabel(colorThreeString);
		labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(6, 1));
		labelPanel.add(zoomLabel);
		labelPanel.add(ALabel);
		labelPanel.add(BLabel);
		labelPanel.add(colorOneLabel);
		labelPanel.add(colorTwoLabel);
		labelPanel.add(colorThreeLabel);
		
		
		
		twoPanel = new JPanel();
		twoPanel.setLayout(new GridLayout(1, 2));
		twoPanel.add(otherScrollPanel, BorderLayout.EAST);
		twoPanel.add(labelPanel , BorderLayout.WEST);
		
		
		frame.add(twoPanel, BorderLayout.SOUTH);

		
		frame.setSize(1000,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawJulia(g);
		colorOneLabel.setText(colorOneString);
		colorTwoLabel.setText(colorTwoString);
		colorThreeLabel.setText(colorThreeString);
		zoomLabel.setText(zoomString);
		ALabel.setText(AString);
		BLabel.setText(BString);
	}
	public void drawJulia(Graphics g)
	{
		w = frame.getWidth();
		h = frame.getHeight();

		
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		for(int x = 0; x < w; x++) {
			for(int y = 0; y < h; y++) {
				double zx = 1.5 * (x - w/2.0)/(0.5 * zoom * w);
				double zy = (y - h/2.0) / (h * 0.5 * zoom);
				
				float value = maxValue;
				
				while((zx * zx + zy * zy) < 6 && value > 0) {
						double temp = (zx * zx) - (zy * zy) + A;
						zy = 2 * zx * zy + B; 
						zx = temp; 
						value --; 
				}
				
				int c; 
				if(value > 0) {
					c =Color.HSBtoRGB((maxValue / value+color[0]) % 1, color[1], color[2]);
				}
				else {
					c = Color.HSBtoRGB((maxValue / value+color[0])%1, color[1], Math.abs(1-color[2]));
				}
				
				image.setRGB(x, y, c);
			}
			
		}																										
		
		g.drawImage(image, 0, 0, null);
		

	}

	public void adjustmentValueChanged(AdjustmentEvent e)
	{	
		if(e.getSource() == zoomScroll) {
			zoom = zoomScroll.getValue()/100.0f;
			zoomString = "ZOOM: " + zoom;
		}
		else if(e.getSource() == AScroll) {
			A = AScroll.getValue() / 1000.0;
			AString = "A: " + A;
		}
		else if(e.getSource() == BScroll) {
			B = BScroll.getValue() / 1000.0;
			BString = "B: " + B;
		}
		for(int x=0;x<3;x++)
		{
			if(e.getSource()==scrollBar[x])
			{
				color[x]=scrollBar[x].getValue()/255.0f;
				


			}
		}
		colorOneString = "HUE: " + color[0];
		colorTwoString = "SATURATION: " + color[1];
		colorThreeString = "BRIGHTNESS: " + color[2];
		repaint();

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==invert)
		{
			zoomScroll.setValue(0);
			AScroll.setValue(0);
			BScroll.setValue(0);
			scrollBar[0].setValue(255);
			scrollBar[1].setValue(255);
			scrollBar[2].setValue(255);
			
		}
		repaint();
	}



	public static void main(String[] args)
	{
		JuliaSet app=new JuliaSet();
	}
}