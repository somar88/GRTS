package State;

import java.awt.Graphics2D;

import TileMap.TileMap;

public class Level1State extends State {

	private TileMap tileMap;

	public Level1State(StateManager sm) {
		this.sm = sm;
	}

	@Override
	public void init() {

		// tileMap = new TileMap(30);
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics2D g) {
	}

	@Override
	public void keyPressed(int k) {
	}

	@Override
	public void keyReleased(int k) {
	}

}
