package grts.Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import State.StateManager;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements Runnable, KeyListener {

	// dimensions
	public static final int WIDTH = 320;
	public static final int HIGHT = 240;
	public static final int SCALE = 2;
	public Dimension d = new Dimension(WIDTH * SCALE, HIGHT * SCALE);
	// main thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;

	// image
	private BufferedImage image;
	private Graphics2D g;

	// Main State Manager
	private StateManager sm;

	// Constructor
	public MainPanel() {
		super();
		System.out.println(d.getHeight() + ", " + d.getWidth());
		setPreferredSize(d);
		setFocusable(true);
		requestFocus();

	}

	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this, "MainLoop");
			addKeyListener(this);
			thread.start();
		}
	}

	public void init() {
		image = new BufferedImage(WIDTH, HIGHT, BufferedImage.TYPE_INT_RGB);

		g = (Graphics2D) image.getGraphics();

		running = true;

		sm = new StateManager();
	}

	public void run() {

		init();

		// Timers
		long start;
		long elapsed;
		long wait;

		// main Loop
		while (running) {

			start = System.nanoTime();

			update();
			draw();
			drawToScreen();

			elapsed = System.nanoTime() - start;

			wait = targetTime - elapsed / 1000_000;

			try {
				if (wait < 0) {
					wait = 5;
				}
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void update() {
		sm.update();
	}

	private void draw() {
		sm.draw(g);
	}

	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HIGHT * SCALE, null);
		g2.dispose();
	}

	@Override
	public void keyTyped(KeyEvent key) {
	}

	@Override
	public void keyPressed(KeyEvent key) {
		sm.keyPressed(key.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent key) {
		sm.keyReleased(key.getKeyCode());
	}
}
