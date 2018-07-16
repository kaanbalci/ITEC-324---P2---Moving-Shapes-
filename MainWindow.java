import java.awt.BorderLayout;
//import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * MainWindow class that extends JPanel
 * 
 * @author Kaan Balci
 *
 */
public class MainWindow extends JPanel {
	int x = 0;
	int y = 0;

	JFrame SubWindow = new JFrame(); // Second Window to add to and hold moving
										// shapes

	JPanel buttons = new JPanel(); // will contain buttons
	JPanel checkboxes = new JPanel(); // will contain checkboxes
	/**
	 * create JButtons,JCheckboxes, initializes shapeIcons, and creates JLabels
	 * for Icons
	 */
	JButton showB = new JButton("Show");
	JButton exitB = new JButton("Exit");
	JButton addB = new JButton("Add");
	JButton removeB = new JButton("Remove");
	JButton exitSubWindow = new JButton("Exit");
	JButton hide = new JButton("Hide");

	JCheckBox aCheck = new JCheckBox("Airplane");
	JCheckBox bCheck = new JCheckBox("Boat");
	JCheckBox cCheck = new JCheckBox("Clock");

	JLabel testLabel = new JLabel("Test");
	private ShapeIcon clockIcon = new ShapeIcon(500, 100);
	private ShapeIcon boatIcon = new ShapeIcon(500, 300);
	private ShapeIcon planeIcon = new ShapeIcon(500, 300);

	JLabel clockLabel = new JLabel(clockIcon);
	JLabel boatLabel = new JLabel(boatIcon);
	JLabel planeLabel = new JLabel(planeIcon);
	/**
	 * Timer with 10 milliseconds between timer clicks
	 */
	final int DELAY = 10;
	Timer t = new Timer(DELAY, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			planeIcon.motion();
			planeLabel.repaint();
			boatIcon.motion();
			boatLabel.repaint();
			clockIcon.motion();
			clockLabel.repaint();
		}
	});

	/**
	 * add buttons and checkboxes to main window frame and sets layout
	 */
	public MainWindow() {
		setLayout(new BorderLayout());

		buttons.setLayout(new GridLayout(1, 4));
		checkboxes.setLayout(new GridLayout(0, 3));

		buttons.add(showB);
		buttons.add(exitB);
		buttons.add(addB);
		buttons.add(removeB);

		checkboxes.add(aCheck);
		checkboxes.add(bCheck);
		checkboxes.add(cCheck);

		add(checkboxes, BorderLayout.NORTH);
		add(buttons, BorderLayout.SOUTH);

		/**
		 * exit application
		 */
		exitB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				// System.out.println("You clicked the button");
				System.exit(0);
			}
		});

		/**
		 * show button action listener calls show method
		 */
		showB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// execute when button is pressed
				show();
			}
		});

		/**
		 * hide subwindow action listener uses hide method
		 */
		hide.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				hide();
			}
		});

		/**
		 * exit sub window action listener. sub window exits and all is removed
		 * from it
		 */
		exitSubWindow.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				SubWindow.dispose();
				planeIcon.removeAll();
				boatIcon.removeAll();
				clockIcon.removeAll();
			}
		});

		/**
		 * add button action listener calls add button method.
		 */
		addB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (aCheck.isSelected())
					add(3);

				if (bCheck.isSelected())
					add(2);

				if (cCheck.isSelected())
					add(1);
			}
		});
		/**
		 * remove button action listener calls remove method
		 */
		removeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();
			}
		});

	}

	/**
	 * show sub window create one if one hasnt been created.
	 */
	public void show() {
		if (!SubWindow.isVisible()) {
			SubWindow.setLayout(null);
			hide.setBounds(150, 0, 100, 25);
			exitSubWindow.setBounds(250, 0, 100, 25);
			SubWindow.add(hide);
			SubWindow.add(exitSubWindow);
			SubWindow.setSize(600, 600);
			SubWindow.setResizable(false);
			SubWindow.setVisible(true);
			t.start();
		}
	}

	/**
	 * hide window and stop animation
	 *
	 */
	public void hide() {
		SubWindow.setVisible(false);
		t.stop();
	}

	/**
	 * exit sub window and remove icons
	 */
	public void exitSubWindow() {
		planeIcon.removeAll();
		clockIcon.removeAll();
		boatIcon.removeAll();
		SubWindow.dispose();

	}

	/**
	 * add method to add the shapes created to window when checked and add
	 * button is pressed
	 * 
	 * @param pick
	 */
	public void add(int pick) {
		if (pick == 1) {
			clockIcon.addShape(new Shape((int) (Math.random() * 300),
					(int) (Math.random() * 300), 1));
			clockLabel.setBounds(0, 50, 600, 600);
			SubWindow.add(clockLabel);
			// if no sub window is visible then show one
			if (!SubWindow.isVisible())
				show();
		}
		if (pick == 2) {
			boatIcon.addShape(new Shape((int) (Math.random() * 200),
					(int) (Math.random() * 200), 2));
			boatLabel.setBounds(0, 50, 600, 600);
			SubWindow.add(boatLabel);
			// if no sub window is visible then show one
			if (!SubWindow.isVisible())
				show();
		} else if (pick == 3) {
			planeIcon.addShape(new Shape((int) (Math.random() * 400),
					(int) (Math.random() * 400), 3));
			planeLabel.setBounds(0, 50, 600, 600);
			SubWindow.add(planeLabel);
			// if no sub window is visible then show one
			if (!SubWindow.isVisible())
				show();
		}
	}

	/**
	 * removes created shape when checked
	 */
	public void remove() {
		if (bCheck.isSelected())
			boatIcon.remove();

		if (cCheck.isSelected())
			clockIcon.remove();

		if (aCheck.isSelected())
			planeIcon.remove();
	}

	/**
	 * set buttons and checkboxes to visible
	 */
	public void setVisible() {
		buttons.setVisible(true);
		checkboxes.setVisible(true);

	}

}