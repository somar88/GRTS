package State;

import java.util.ArrayList;

public class StateManager {

	private ArrayList<State> states;
	private int currentState;

	public static final int MENUSTATE = 0;
	public static final int LEVEL1STATE = 1;

	public StateManager() {
		states = new ArrayList<State>();

		currentState = MENUSTATE;
		states.add(new MenuState(this));
	}

	public void setState(int state) {

		currentState = state;
		states.get(currentState).init();
	}

	public void update() {
		states.get(currentState).update();
	}

	public void draw(java.awt.Graphics2D g) {
		states.get(currentState).draw(g);

	}

	public void keyPressed(int k) {
		states.get(currentState).keyPressed(k);
	}

	public void keyReleased(int k) {
		states.get(currentState).keyReleased(k);
	}

}
