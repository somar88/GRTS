package State;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import com.sun.glass.events.KeyEvent;
import TileMap.Background;

public class MenuState extends State {

	private Background bg;

	private int currentChoice = 0;

	private String[] options = { "Start", "Help", "Quit" };

	private Color titleColor;
	private Font titleFont;

	private Font font;

	public MenuState(StateManager sm) {
		this.sm = sm;

		try {
			bg = new Background("/Backgrounds/menubg.gif", 1);
			bg.setVector(-0.60, 0);

			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);

			font = new Font("Arial", Font.PLAIN, 12);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void init() {
	}

	public void update() {
		bg.update();
	}

	public void draw(Graphics2D g) {

		// draw Background
		bg.draw(g);

		// draw Title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("GRTS", 80, 70);

		// Draw menu options
		g.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g.setColor(Color.BLACK);
			} else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 145, 140 + i * 15);
		}
	}

	private void select() {
		if (currentChoice == 0) {
			// Start
			sm.setState(StateManager.LEVEL1STATE);
		}
		if (currentChoice == 1) {
			// Help
			sm.setState(StateManager.HELPMENU);
		}
		if (currentChoice == 2) {
			System.exit(0);
		}
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {
			select();
		}
		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			if (currentChoice < 0) {
				currentChoice = options.length - 1;
			}
		}
		if (k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if (currentChoice >= options.length) {
				currentChoice = 0;
			}
		}

	}

	public void keyReleased(int k) {
	}

}
