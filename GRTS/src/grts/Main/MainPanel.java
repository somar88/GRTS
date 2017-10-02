package grts.Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable, KeyListener {

	// dimensions
	public static final int WIDTH = 320;
	public static final int HIGHT = 240;
	public static final int SCALE = 3;

	// main thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;

	// image
	private BufferedImage image;
	private Graphics2D g;

	// Constructor
	public MainPanel() {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();

	}

	public void addNotifier() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this, "MainLoop");
			addKeyListener(this);
			thread.start();
		}
	}

	public void init() {
		image = new BufferedImage(WIDTH, HIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) g;
		running = true;
	}

	public void run() {

		init();
		// Timers
		long start;
		long elapsed;
		long wait;

		// main Loop
		while (running) {
			update();
			draw();
			drawToScreen();
		}

	}

	private void update() {
		// TODO Auto-generated method stub

	}

	private void draw() {
		// TODO Auto-generated method stub

	}

	private void drawToScreen() {

		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}

	public void KeyTyped(KeyEvent Key) {
	}

	public void KeyPressed(KeyEvent Key) {
	}

	public void KeyReleased(KeyEvent Key) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
