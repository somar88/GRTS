package State;

import java.awt.Color;
import java.awt.Graphics2D;

import TileMap.TileMap;
import grts.Main.MainPanel;

public class Level1State extends State {

	private TileMap tileMap;

	public Level1State(StateManager sm) {
		this.sm = sm;
		init();
	}

	@Override
	public void init() {

		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/grasstileset.gif");
		tileMap.loadMap("Maps/level1-1.map");
		tileMap.setPosition(0, 0);
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics2D g) {
		// clear screen
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, MainPanel.WIDTH, MainPanel.HIGHT);

		// draw tilemap
		tileMap.draw(g);
	}

	@Override
	public void keyPressed(int k) {
	}

	@Override
	public void keyReleased(int k) {
	}

}
