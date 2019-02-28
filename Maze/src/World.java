import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class World {
	private ArrayList<String> vals ;
	public static ArrayList<Tile> tiles;
	private Player p;
	public static int WIDTH;
	public static int HEIGHT;
	private boolean leftWallBlocker = true;
	private boolean rightWallBlocker = true;
	private boolean forwardBlocker = true;
	
 	World(String name, Player p){
		File file = new File(name);
		this.p = p;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String text = "";
			vals = new ArrayList<String>();
			while((text = reader.readLine()) != null) {
				vals.add(text);
				WIDTH = text.length() * 10;
			}
			
			HEIGHT = vals.size() * 10;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void init() {
		tiles = new ArrayList<Tile>();
		for(int i = 0; i < vals.size(); i++) {
			for(int j = 0; j < vals.get(i).length(); j++) {
				if(vals.get(i).substring(j, j+1).equals("*")) {
					tiles.add(new Tile(Tile.WIDTH * j, Tile.HEIGHT * i, true, p, "*"));
				}
				else if (vals.get(i).substring(j, j+1).equals("S")) {
					tiles.add(new Tile(Tile.WIDTH * j, Tile.HEIGHT * i, false, p, "S"));
				}
				else if (vals.get(i).substring(j, j+1).equals("E")) {
					tiles.add(new Tile(Tile.WIDTH * j, Tile.HEIGHT * i, false, p, "E"));
				}
				else {
					tiles.add(new Tile(Tile.WIDTH * j, Tile.HEIGHT * i, false, p, ""));
				}
			}
		}
		
		//setting up the walls for each tile
		
	}
	
	public void update() {
	
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(0, 3, 80));
		g.fillPolygon(new Polygon(new int[] {0, 900, 900, 0}, new int[] {0, 0, 75, 75}, 4));
		g.fillPolygon(new Polygon(new int[] {0, 900, 900, 0}, new int[] {75, 75, 150, 150}, 4));
		g.fillPolygon(new Polygon(new int[] {0, 900, 900, 0}, new int[] {150, 150, 225, 225}, 4));
		g.fillPolygon(new Polygon(new int[] {0, 900, 900, 0}, new int[] {225, 225, 300, 300}, 4));
		
		
		g.fillPolygon(new Polygon(new int[] {400, 500, 500, 400}, new int[] {300, 300, 375, 375}, 4));
		
		
		g.setColor(new Color(145, 97, 13));
		g.fillPolygon(new Polygon(new int[] {0, 900, 900, 0}, new int[] {375, 375, 450, 450}, 4));
		g.setColor(new Color(164, 110, 16));
		g.fillPolygon(new Polygon(new int[] {0, 900, 900, 0}, new int[] {450, 450, 525, 525}, 4));
		g.setColor(new Color(196, 131, 19));
		g.fillPolygon(new Polygon(new int[] {0, 900, 900, 0}, new int[] {525, 525, 600, 600}, 4));
		g.setColor(new Color(232, 153, 18));
		g.fillPolygon(new Polygon(new int[] {0, 900, 900, 0}, new int[] {600, 600, 675, 675}, 4));
		
		g.setColor(Color.BLACK);
		g.drawPolygon(new Polygon(new int[] {0, 900, 900, 0}, new int[] {375, 375, 450, 450}, 4));
		g.drawPolygon(new Polygon(new int[] {0, 900, 900, 0}, new int[] {450, 450, 525, 525}, 4));
		g.drawPolygon(new Polygon(new int[] {0, 900, 900, 0}, new int[] {525, 525, 600, 600}, 4));
		g.drawPolygon(new Polygon(new int[] {0, 900, 900, 0}, new int[] {600, 600, 675, 675}, 4));
		
		
		g.setColor(new Color(6, 0, 191));
		g.fillPolygon(new Polygon(new int[] {300, 400, 400, 300}, new int[] {300, 300, 375, 375}, 4));
		g.fillPolygon(new Polygon(new int[] {500, 600, 600, 500}, new int[] {300, 300, 375, 375}, 4));
		g.setColor(new Color(0, 46, 228));
		g.fillPolygon(new Polygon(new int[] {200, 300, 300, 200}, new int[] {225, 225, 450, 450}, 4));
		g.fillPolygon(new Polygon(new int[] {600, 700, 700, 600}, new int[] {225, 225, 450, 450}, 4));
		g.setColor(new Color(0, 85, 213));
		g.fillPolygon(new Polygon(new int[] {100, 200, 200, 100}, new int[] {150, 150, 525, 525}, 4));
		g.fillPolygon(new Polygon(new int[] {700, 800, 800, 700}, new int[] {150, 150, 525, 525}, 4));
		g.setColor(new Color(1, 129, 193));
		g.fillPolygon(new Polygon(new int[] {100, 200, 200, 100}, new int[] {150, 150, 525, 525}, 4));
		g.fillPolygon(new Polygon(new int[] {700, 800, 800, 700}, new int[] {150, 150, 525, 525}, 4));
		g.setColor(new Color(0, 174, 228));
		g.fillPolygon(new Polygon(new int[] {000, 100, 100, 000}, new int[] {75, 75, 600, 600}, 4));
		g.fillPolygon(new Polygon(new int[] {800, 900, 900, 800}, new int[] {75, 75, 600, 600}, 4));
		
		//g.setColor(new Color(220, 220, 220));
		//g.fillPolygon(new Polygon(new int[] {0, 67, 67, 0}, new int[] {0, 0, 502, 502}, 4));
		//g.fillPolygon(new Polygon(new int[] {434, 500, 500, 434}, new int[] {0, 0, 502, 502}, 4));
		
		if(p.getDegree() == 0) {
			for(int i = 0; i < tiles.size(); i++) {
				
				//the tile im on
				if(tiles.get(i).getX() == p.getX() + Tile.WIDTH && tiles.get(i).getY() == p.getY()) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 196, 255));
						g.fillPolygon(new Polygon(new int[] {0, 100, 100, 0}, new int[] {0, 75, 600, 675}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {0, 100, 100, 0}, new int[] {0, 75, 600, 675}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() - Tile.WIDTH && tiles.get(i).getY() == p.getY()){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 196, 255));
						g.fillPolygon(new Polygon(new int[] {800, 900, 900, 800}, new int[] {75, 0, 675, 600}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {800, 900, 900, 800}, new int[] {75, 0, 675, 600}, 4));
					}
				}
				// the tile in front of me
				if(tiles.get(i).getX() == p.getX() + Tile.WIDTH && tiles.get(i).getY() == p.getY() + Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 154, 255));
						g.fillPolygon(new Polygon(new int[] {100, 200, 200, 100}, new int[] {75, 150, 525, 600}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {100, 200, 200, 100}, new int[] {75, 150, 525, 600}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() - Tile.WIDTH && tiles.get(i).getY() == p.getY() + Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 154, 255));
						g.fillPolygon(new Polygon(new int[] {700, 800, 800, 700}, new int[] {150, 75, 600, 525}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {700, 800, 800, 700}, new int[] {150, 75, 600, 525}, 4));
					}
				}
				//two tiles in front of me
				
				if(tiles.get(i).getX() == p.getX() + Tile.WIDTH && tiles.get(i).getY() == p.getY() + 2 * Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 100, 255));
						g.fillPolygon(new Polygon(new int[] {200, 300, 300, 200}, new int[] {150, 225, 450, 525}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {200, 300, 300, 200}, new int[] {150, 225, 450, 525}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() - Tile.WIDTH && tiles.get(i).getY() == p.getY() + 2 * Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 100, 255));
						g.fillPolygon(new Polygon(new int[] {600, 700, 700, 600}, new int[] {225, 150, 525, 450}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {600, 700, 700, 600}, new int[] {225, 150, 525, 450}, 4));
					}
				}
				
				//three tiles
				
				if(tiles.get(i).getX() == p.getX() + Tile.WIDTH && tiles.get(i).getY() == p.getY() + 3 * Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 50, 255));
						g.fillPolygon(new Polygon(new int[] {300, 400, 400, 300}, new int[] {225, 300, 375, 450}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {300, 400, 400, 300}, new int[] {225, 300, 375, 450}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() - Tile.WIDTH && tiles.get(i).getY() == p.getY() + 3 * Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 50, 255));
						g.fillPolygon(new Polygon(new int[] {500, 600, 600, 500}, new int[] {300, 225, 450, 375}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {500, 600, 600, 500}, new int[] {300, 225, 450, 375}, 4));
					}
				}
			}
		}
		
		
		if(p.getDegree() == 90) {
			for(int i = 0; i < tiles.size(); i++) {
				
				//the tile im on
				if(tiles.get(i).getX() == p.getX()  && tiles.get(i).getY() == p.getY() - Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 196, 255));
						g.fillPolygon(new Polygon(new int[] {0, 100, 100, 0}, new int[] {0, 75, 600, 675}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {0, 100, 100, 0}, new int[] {0, 75, 600, 675}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() && tiles.get(i).getY() == p.getY() + Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 196, 255));
						g.fillPolygon(new Polygon(new int[] {800, 900, 900, 800}, new int[] {75, 0, 675, 600}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {800, 900, 900, 800}, new int[] {75, 0, 675, 600}, 4));
					}
				}
				// the tile in front of me
				if(tiles.get(i).getX() == p.getX() + Tile.WIDTH && tiles.get(i).getY() == p.getY() - Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 154, 255));
						g.fillPolygon(new Polygon(new int[] {100, 200, 200, 100}, new int[] {75, 150, 525, 600}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {100, 200, 200, 100}, new int[] {75, 150, 525, 600}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() + Tile.WIDTH && tiles.get(i).getY() == p.getY() + Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 154, 255));
						g.fillPolygon(new Polygon(new int[] {700, 800, 800, 700}, new int[] {150, 75, 600, 525}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {700, 800, 800, 700}, new int[] {150, 75, 600, 525}, 4));
					}
				}
				//two tiles in front of me
				
				if(tiles.get(i).getX() == p.getX() + 2*Tile.WIDTH && tiles.get(i).getY() == p.getY() - Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 100, 255));
						g.fillPolygon(new Polygon(new int[] {200, 300, 300, 200}, new int[] {150, 225, 450, 525}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {200, 300, 300, 200}, new int[] {150, 225, 450, 525}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() + 2*Tile.WIDTH && tiles.get(i).getY() == p.getY() + Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 100, 255));
						g.fillPolygon(new Polygon(new int[] {600, 700, 700, 600}, new int[] {225, 150, 525, 450}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {600, 700, 700, 600}, new int[] {225, 150, 525, 450}, 4));
					}
				}
				
				//three tiles
				
				if(tiles.get(i).getX() == p.getX() + 3*Tile.WIDTH && tiles.get(i).getY() == p.getY() - Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 50, 255));
						g.fillPolygon(new Polygon(new int[] {300, 400, 400, 300}, new int[] {225, 300, 375, 450}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {300, 400, 400, 300}, new int[] {225, 300, 375, 450}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() + 3*Tile.WIDTH && tiles.get(i).getY() == p.getY() + Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 50, 255));
						g.fillPolygon(new Polygon(new int[] {500, 600, 600, 500}, new int[] {300, 225, 450, 375}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {500, 600, 600, 500}, new int[] {300, 225, 450, 375}, 4));
					}
				}
			}
		}
		
		
		
		if(p.getDegree() == 180) {
			for(int i = 0; i < tiles.size(); i++) {
				
				//the tile im on
				if(tiles.get(i).getX() == p.getX() - Tile.WIDTH && tiles.get(i).getY() == p.getY()) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 196, 255));
						g.fillPolygon(new Polygon(new int[] {0, 100, 100, 0}, new int[] {0, 75, 600, 675}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {0, 100, 100, 0}, new int[] {0, 75, 600, 675}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() + Tile.WIDTH && tiles.get(i).getY() == p.getY()){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 196, 255));
						g.fillPolygon(new Polygon(new int[] {800, 900, 900, 800}, new int[] {75, 0, 675, 600}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {800, 900, 900, 800}, new int[] {75, 0, 675, 600}, 4));
					}
				}
				// the tile in front of me
				if(tiles.get(i).getX() == p.getX() - Tile.WIDTH && tiles.get(i).getY() == p.getY() - Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 154, 255));
						g.fillPolygon(new Polygon(new int[] {100, 200, 200, 100}, new int[] {75, 150, 525, 600}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {100, 200, 200, 100}, new int[] {75, 150, 525, 600}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() + Tile.WIDTH && tiles.get(i).getY() == p.getY() - Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 154, 255));
						g.fillPolygon(new Polygon(new int[] {700, 800, 800, 700}, new int[] {150, 75, 600, 525}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {700, 800, 800, 700}, new int[] {150, 75, 600, 525}, 4));
					}
				}
				//two tiles in front of me
				
				if(tiles.get(i).getX() == p.getX() - Tile.WIDTH && tiles.get(i).getY() == p.getY() - 2 * Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 100, 255));
						g.fillPolygon(new Polygon(new int[] {200, 300, 300, 200}, new int[] {150, 225, 450, 525}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {200, 300, 300, 200}, new int[] {150, 225, 450, 525}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() + Tile.WIDTH && tiles.get(i).getY() == p.getY() - 2 * Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 100, 255));
						g.fillPolygon(new Polygon(new int[] {600, 700, 700, 600}, new int[] {225, 150, 525, 450}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {600, 700, 700, 600}, new int[] {225, 150, 525, 450}, 4));
					}
				}
				
				//three tiles
				
				if(tiles.get(i).getX() == p.getX() - Tile.WIDTH && tiles.get(i).getY() == p.getY() - 3 * Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 50, 255));
						g.fillPolygon(new Polygon(new int[] {300, 400, 400, 300}, new int[] {225, 300, 375, 450}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {300, 400, 400, 300}, new int[] {225, 300, 375, 450}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() + Tile.WIDTH && tiles.get(i).getY() == p.getY() - 3 * Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 50, 255));
						g.fillPolygon(new Polygon(new int[] {500, 600, 600, 500}, new int[] {300, 225, 450, 375}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {300, 400, 400, 300}, new int[] {225, 300, 375, 450}, 4));
					}
				}
			}
		}
		
		if(p.getDegree() == 270) {
			for(int i = 0; i < tiles.size(); i++) {
				
				//the tile im on
				if(tiles.get(i).getX() == p.getX()  && tiles.get(i).getY() == p.getY() + Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 196, 255));
						g.fillPolygon(new Polygon(new int[] {0, 100, 100, 0}, new int[] {0, 75, 600, 675}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {0, 100, 100, 0}, new int[] {0, 75, 600, 675}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() && tiles.get(i).getY() == p.getY() - Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 196, 255));
						g.fillPolygon(new Polygon(new int[] {800, 900, 900, 800}, new int[] {75, 0, 675, 600}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {800, 900, 900, 800}, new int[] {75, 0, 675, 600}, 4));
					}
				}
				// the tile in front of me
				if(tiles.get(i).getX() == p.getX() + Tile.WIDTH && tiles.get(i).getY() == p.getY() + Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 154, 255));
						g.fillPolygon(new Polygon(new int[] {100, 200, 200, 100}, new int[] {75, 150, 525, 600}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {800, 900, 900, 800}, new int[] {75, 0, 675, 600}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() + Tile.WIDTH && tiles.get(i).getY() == p.getY() - Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 154, 255));
						g.fillPolygon(new Polygon(new int[] {700, 800, 800, 700}, new int[] {150, 75, 600, 525}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {700, 800, 800, 700}, new int[] {150, 75, 600, 525}, 4));
					}
				}
				//two tiles in front of me
				
				if(tiles.get(i).getX() == p.getX() + 2*Tile.WIDTH && tiles.get(i).getY() == p.getY() + Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 100, 255));
						g.fillPolygon(new Polygon(new int[] {200, 300, 300, 200}, new int[] {150, 225, 450, 525}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {200, 300, 300, 200}, new int[] {150, 225, 450, 525}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() + 2*Tile.WIDTH && tiles.get(i).getY() == p.getY() - Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 100, 255));
						g.fillPolygon(new Polygon(new int[] {600, 700, 700, 600}, new int[] {225, 150, 525, 450}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {600, 700, 700, 600}, new int[] {225, 150, 525, 450}, 4));
					}
				}
				
				//three tiles
				
				if(tiles.get(i).getX() == p.getX() + 3*Tile.WIDTH && tiles.get(i).getY() == p.getY() + Tile.HEIGHT) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 50, 255));
						g.fillPolygon(new Polygon(new int[] {300, 400, 400, 300}, new int[] {225, 300, 375, 450}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {300, 400, 400, 300}, new int[] {225, 300, 375, 450}, 4));
					}
				}
				if(tiles.get(i).getX() == p.getX() + 3*Tile.WIDTH && tiles.get(i).getY() == p.getY() - Tile.HEIGHT){
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 50, 255));
						g.fillPolygon(new Polygon(new int[] {500, 600, 600, 500}, new int[] {300, 225, 450, 375}, 4));
						g.setColor(Color.BLACK);
						g.drawPolygon(new Polygon(new int[] {500, 600, 600, 500}, new int[] {300, 225, 450, 375}, 4));
					}
				}
			}
		}
		
		
		
		//the big squares
		
		if(p.getDegree() == 0) {
			
			
			for(int i =0; i < tiles.size(); i++) {
				
				if(tiles.get(i).getX() == p.getX() && tiles.get(i).getY() == p.getY() + Tile.HEIGHT) {
					if(tiles.get(i).getSolidity() || tiles.get(i).getToken().equals("S") || tiles.get(i).getToken().equals("E")) {
						g.setColor(new Color(0, 154, 255));
						if(tiles.get(i).getToken().equals("E")) {
							System.out.println(true);
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {100, 800, 800, 100}, new int[] {75, 75, 600, 600}, 4));
						System.out.println("Yoo");
						break; 
						
					}
				}
				
				
				if(tiles.get(i).getX() == p.getX() && tiles.get(i).getY() == p.getY() + 2 * Tile.HEIGHT) {
					if(tiles.get(i).getSolidity() || tiles.get(i).getToken().equals("S") || tiles.get(i).getToken().equals("E")) {
						g.setColor(new Color(0, 100, 255));
						if(tiles.get(i).getToken().equals("E")) {
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {200, 700, 700, 200}, new int[] {150, 150, 525, 525}, 4));
						System.out.println("Yeeoo");
						break;
					}
					
				}
				
				if(tiles.get(i).getX() == p.getX() && tiles.get(i).getY() == p.getY() + 3 * Tile.HEIGHT) {
					if(tiles.get(i).getSolidity() || tiles.get(i).getToken().equals("S") || tiles.get(i).getToken().equals("E")) {
						g.setColor(new Color(0, 50, 255));
						if(tiles.get(i).getToken().equals("E")) {
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {300, 600, 600, 300}, new int[] {225, 225, 450, 450}, 4));
						System.out.println("Yeeeeeeeoooooooo");
						break;
					}
				}
				
				
				else if(tiles.get(i).getX() == p.getX() && tiles.get(i).getY() == p.getY() + 4 * Tile.HEIGHT) {
					if(tiles.get(i).getSolidity() || tiles.get(i).getToken().equals("S") || tiles.get(i).getToken().equals("E")) {
						g.setColor(new Color(0, 0, 255));
						if(tiles.get(i).getToken().equals("E")) {
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {400, 500, 500, 400}, new int[] {300, 300, 375, 375}, 4));
						break;
					}
				}
			}
		}
		
		
		if(p.getDegree() == 180) {
			for(int i =0; i < tiles.size(); i++) {
				
				
				if(tiles.get(i).getX() == p.getX() && tiles.get(i).getY() == p.getY() - Tile.HEIGHT) {
					if(tiles.get(i).getSolidity() || tiles.get(i).getToken().equals("S") || tiles.get(i).getToken().equals("E")) {
						g.setColor(new Color(0, 154, 255));
						if(tiles.get(i).getToken().equals("E")) {
							System.out.println(true);
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {100, 800, 800, 100}, new int[] {75, 75, 600, 600}, 4));
						break;
					}
				}
				
				else if(tiles.get(i).getX() == p.getX() && tiles.get(i).getY() == p.getY() - 2 * Tile.HEIGHT) {
					if(tiles.get(i).getSolidity() || tiles.get(i).getToken().equals("S") || tiles.get(i).getToken().equals("E")) {
						g.setColor(new Color(0, 100, 255));
						if(tiles.get(i).getToken().equals("E")) {
							System.out.println(true);
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {200, 700, 700, 200}, new int[] {150, 150, 525, 525}, 4));
						break;
					}
				}
				
				else if(tiles.get(i).getX() == p.getX() && tiles.get(i).getY() == p.getY() - 3 * Tile.HEIGHT) {
					if(tiles.get(i).getSolidity() || tiles.get(i).getToken().equals("S") || tiles.get(i).getToken().equals("E")) {
						g.setColor(new Color(0, 50, 255));
						if(tiles.get(i).getToken().equals("E")) {
							System.out.println(true);
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {300, 600, 600, 300}, new int[] {225, 225, 450, 450}, 4));
						break;
					}
				}
				
				
				else if(tiles.get(i).getX() == p.getX() && tiles.get(i).getY() == p.getY() - 4 * Tile.HEIGHT) {
					if(tiles.get(i).getSolidity() || tiles.get(i).getToken().equals("S") || tiles.get(i).getToken().equals("E")) {
						g.setColor(new Color(0, 0, 255));
						if(tiles.get(i).getToken().equals("E")) {
							System.out.println(true);
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {400, 500, 500, 400}, new int[] {300, 300, 375, 375}, 4));
						break;
					}
				}
			}
		}
		
		
		if(p.getDegree() == 90) {
			for(int i =0; i < tiles.size(); i++) {
				if(tiles.get(i).getX() == p.getX() + Tile.WIDTH && tiles.get(i).getY() == p.getY()) {
					if(tiles.get(i).getSolidity() || tiles.get(i).getToken().equals("S") || tiles.get(i).getToken().equals("E")) {
						g.setColor(new Color(0, 154, 255));
						if(tiles.get(i).getToken().equals("E")) {
							System.out.println(true);
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {100, 800, 800, 100}, new int[] {75, 75, 600, 600}, 4));
						break;
					}
				}
				else if(tiles.get(i).getX() == p.getX() + 2 * Tile.WIDTH && tiles.get(i).getY() == p.getY()) {
					if(tiles.get(i).getSolidity() || tiles.get(i).getToken().equals("S") || tiles.get(i).getToken().equals("E")) {
						g.setColor(new Color(0, 100, 255));
						if(tiles.get(i).getToken().equals("E")) {
							System.out.println(true);
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {200, 700, 700, 200}, new int[] {150, 150, 525, 525}, 4));
						break;
					}
				}
				
				else if(tiles.get(i).getX() == p.getX()  + 3 * Tile.WIDTH && tiles.get(i).getY() == p.getY()) {
					if(tiles.get(i).getSolidity() || tiles.get(i).getToken().equals("S") || tiles.get(i).getToken().equals("E")) {
						g.setColor(new Color(0, 50, 255));
						if(tiles.get(i).getToken().equals("E")) {
							System.out.println(true);
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {300, 600, 600, 300}, new int[] {225, 225, 450, 450}, 4));
						break;
					}
				}
				else if(tiles.get(i).getX() == p.getX()  + 4 * Tile.WIDTH && tiles.get(i).getY() == p.getY()) {
					if(tiles.get(i).getSolidity() || tiles.get(i).getToken().equals("S") || tiles.get(i).getToken().equals("E")) {
						g.setColor(new Color(0, 0, 255));
						if(tiles.get(i).getToken().equals("E")) {
							System.out.println(true);
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {400, 500, 500, 400}, new int[] {300, 300, 375, 375}, 4));
						break;
					}
				}
			}

		}
		
		if(p.getDegree() == 270) {
			for(int i =0; i < tiles.size(); i++) {
				
				if(tiles.get(i).getX() == p.getX() - Tile.WIDTH && tiles.get(i).getY() == p.getY()) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 154, 255));
						if(tiles.get(i).getToken().equals("E")) {
							System.out.println(true);
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {100, 800, 800, 100}, new int[] {75, 75, 600, 600}, 4));
						break;
					}
				}
				
				else if(tiles.get(i).getX() == p.getX() - 2 * Tile.WIDTH && tiles.get(i).getY() == p.getY()) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 100, 255));
						if(tiles.get(i).getToken().equals("E")) {
							System.out.println(true);
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {200, 700, 700, 200}, new int[] {150, 150, 525, 525}, 4));
						break;
					}
				}
				
				else if(tiles.get(i).getX() == p.getX()  - 3 * Tile.WIDTH && tiles.get(i).getY() == p.getY()) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 50, 255));
						if(tiles.get(i).getToken().equals("E")) {
							System.out.println(true);
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {300, 600, 600, 300}, new int[] {225, 225, 450, 450}, 4));
						break;
					}
				}
				
				else if(tiles.get(i).getX() == p.getX()  - 4 * Tile.WIDTH && tiles.get(i).getY() == p.getY()) {
					if(tiles.get(i).getSolidity()) {
						g.setColor(new Color(0, 0, 255));
						if(tiles.get(i).getToken().equals("E")) {
							System.out.println(true);
							g.setColor(Color.GREEN);
						}
						g.fillPolygon(new Polygon(new int[] {400, 500, 500, 400}, new int[] {300, 300, 375, 375}, 4));
						break;
					}
				}
			}
		}
		
		
		
	}
}
