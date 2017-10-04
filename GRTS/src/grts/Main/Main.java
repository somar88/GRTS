package grts.Main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame("Main Window!");
		MainPanel MP = new MainPanel();
		window.setLocationRelativeTo(null);
		window.setPreferredSize(new Dimension(MP.WIDTH * MP.SCALE, MP.WIDTH * MP.SCALE));
		window.setContentPane(MP);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}

}
