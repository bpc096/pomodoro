package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;

public class ViewStats extends JFrame{

	public ViewStats() {
		initialize();
	}

	// Initialize the contents of the frame
	private void initialize() {
		config();
		
		JLabel lblNewLabel = new JLabel("Tuesday");
		getContentPane().add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("Wednesday");
		getContentPane().add(lblNewLabel_1, "cell 2 0");
		
		JLabel lblNewLabel_2 = new JLabel("Thursday");
		getContentPane().add(lblNewLabel_2, "cell 4 0");
		
		JLabel lblNewLabel_3 = new JLabel("Friday");
		getContentPane().add(lblNewLabel_3, "cell 6 0");
		
		JLabel lblNewLabel_4 = new JLabel("Saturday");
		getContentPane().add(lblNewLabel_4, "cell 8 0");
		
		JLabel lblNewLabel_6 = new JLabel("Sunday");
		getContentPane().add(lblNewLabel_6, "cell 12 0");
		
		JLabel lblNewLabel_14 = new JLabel("Monday");
		getContentPane().add(lblNewLabel_14, "cell 10 0");
		
		JLabel lblNewLabel_7 = new JLabel("0");
		getContentPane().add(lblNewLabel_7, "cell 0 1");
		
		JLabel lblNewLabel_8 = new JLabel("0");
		getContentPane().add(lblNewLabel_8, "cell 2 1");
		
		JLabel lblNewLabel_9 = new JLabel("0");
		getContentPane().add(lblNewLabel_9, "cell 4 1");
		
		JLabel lblNewLabel_10 = new JLabel("0");
		getContentPane().add(lblNewLabel_10, "cell 6 1");
		
		JLabel lblNewLabel_11 = new JLabel("0");
		getContentPane().add(lblNewLabel_11, "cell 8 1");
		
		JLabel lblNewLabel_12 = new JLabel("0");
		getContentPane().add(lblNewLabel_12, "cell 10 1");
		
		JLabel lblNewLabel_13 = new JLabel("0");
		getContentPane().add(lblNewLabel_13, "cell 12 1");
		
	}
	
	private void config() {
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(new Dimension(525, 119));
		setIconImage(new ImageIcon("res/tomato.png").getImage());
		setTitle("Pomodoro");
		getContentPane().setLayout(new MigLayout("", "[][][][][][][][][][][][][]", "[][]"));
		
	}
}