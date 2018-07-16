import java.awt.Dimension;

import javax.swing.JFrame;

public class MultiShapeTest {

	public static void main(String[] args) {

		JFrame window = new JFrame("Project 2 - Moving Shapes");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(new MainWindow());
		window.setMinimumSize(new Dimension(500, 100));

		// makes it so users can't resize window
		window.setResizable(false);

		window.pack();
		window.setVisible(true);

	}

}