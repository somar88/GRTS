package State;

import java.awt.Graphics2D;

import TileMap.Background;

public class MenuState extends State {

	private Background bg;

	private int currentChoice = 0;
	private String[] options = { 
			
			"Start",
			"Help",
			"Quit" 
			
			};

	public MenuState(StateManager sm) {
		this.sm = sm;
	}

	public void init() {
	}

	public void update() {
	}

	public void draw(Graphics2D g) {
	}

	public void keyPressed(int k) {
	}

	public void keyReleased(int k) {
	}

}
