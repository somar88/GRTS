package grts.Main;

import javax.swing.JFrame;

public class Main {

	public static void Main(String[] args) {
		JFrame window = new JFrame("Main Window!");
		window.setContentPane(new MainPanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}

}
