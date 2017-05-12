package core.gfx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import core.Core;

/** 
 * @author Josh CLARKE
 */
public class Window {

	private Core core;

	private JFrame frame;
	private JSplitPane split;
	private JPanel buttonPanel;
	private ImageComponent animationPanel;
	private JButton buttons[];

	public Window(Core core) {
		this.core = core;
		initComponents();
	}

	private void initComponents() {
		// Attribute and object definitions
		Dimension animationPanelDimensions = new Dimension(320, 190);
		Dimension buttonPanelDimensions = new Dimension(320, 50);
		Dimension buttonDimensions = new Dimension(70, 40);

		FlowLayout fl = new FlowLayout();
		fl.setHgap(10);

		// Defining the animation panel
		animationPanel = new ImageComponent();
		animationPanel.setPreferredSize(animationPanelDimensions);
		animationPanel.setMaximumSize(animationPanelDimensions);
		animationPanel.setMinimumSize(animationPanelDimensions);
		animationPanel.setDoubleBuffered(true);

		// Defining the button panel
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(buttonPanelDimensions);
		buttonPanel.setMaximumSize(buttonPanelDimensions);
		buttonPanel.setMinimumSize(buttonPanelDimensions);
		buttonPanel.setLayout(fl);
		buttonPanel.setBackground(Color.WHITE);

		// Defining the buttons
		buttons = new JButton[4];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setPreferredSize(buttonDimensions);
			buttons[i].setMinimumSize(buttonDimensions);
			buttons[i].setMaximumSize(buttonDimensions);
			buttons[i].setForeground(Color.WHITE);
			buttons[i].addActionListener(core.getActionListener(i));
			buttonPanel.add(buttons[i], fl);
		}

		buttons[0].setText("Feed");
		buttons[0].setBackground(Color.BLUE);

		buttons[1].setText("Play");
		buttons[1].setBackground(Color.BLUE);

		buttons[2].setText("Sleep");
		buttons[2].setBackground(Color.BLUE);

		buttons[3].setText("KILL");
		buttons[3].setBackground(Color.RED);

		// Defining the top-bottom split pane
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, animationPanel, buttonPanel);
		split.setDividerSize(2);

		// Defining the window (JFrame) characteristics
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(split, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/** Get the current frame from the BEAST and set the animationPanel to this frame, then
	 * repaint. */
	public void update() {
		animationPanel.setImage(core.getBeast().getCurrentAnimation().getFrame());
		animationPanel.update();
	}

	/** Dispose of the current window object. Note that if this is the last open window, the program
	 * will close. */
	public void dispose() {
		dispose();
	}

}
