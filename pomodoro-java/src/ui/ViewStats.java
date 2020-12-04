package ui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.Stats;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import net.miginfocom.swing.MigLayout;

public class ViewStats extends JFrame{

	JLabel tuesdayLbl, wednesdayLbl, thursdayLbl, fridayLbl, saturdayLbl, sundayLbl, mondayLbl;
	JLabel tuesday, wednesday, thursday, friday, saturday, sunday, monday;
	ArrayList<String> data = null;
	
	public ViewStats() {
		initialize();
	}

	// Initialize the contents of the frame
	private void initialize() {
		config();
		
		tuesdayLbl = new JLabel("Tuesday");
		getContentPane().add(tuesdayLbl, "cell 0 0");
		
		wednesdayLbl = new JLabel("Wednesday");
		getContentPane().add(wednesdayLbl, "cell 2 0");
		
		thursdayLbl = new JLabel("Thursday");
		getContentPane().add(thursdayLbl, "cell 4 0");
		
		fridayLbl = new JLabel("Friday");
		getContentPane().add(fridayLbl, "cell 6 0");
		
		saturdayLbl = new JLabel("Saturday");
		getContentPane().add(saturdayLbl, "cell 8 0");
		
		sundayLbl = new JLabel("Sunday");
		getContentPane().add(sundayLbl, "cell 10 0");
		
		mondayLbl = new JLabel("Monday");
		getContentPane().add(mondayLbl, "cell 12 0");
		
		tuesday = new JLabel("0");
		getContentPane().add(tuesday, "cell 0 1");
		
		wednesday = new JLabel("0");
		getContentPane().add(wednesday, "cell 2 1");
		
		thursday = new JLabel("0");
		getContentPane().add(thursday, "cell 4 1");
		
		friday = new JLabel("0");
		getContentPane().add(friday, "cell 6 1");
		
		saturday = new JLabel("0");
		getContentPane().add(saturday, "cell 8 1");
		
		sunday = new JLabel("0");
		getContentPane().add(sunday, "cell 10 1");
		
		monday = new JLabel("0");
		getContentPane().add(monday, "cell 12 1");
		
		setData();
		
	}
	
	private void setData() {
		Stats s = new Stats();
		int[] data = s.getData();
		monday.setText(Integer.toString(data[0]));
		tuesday.setText(Integer.toString(data[1]));
		wednesday.setText(Integer.toString(data[2]));
		thursday.setText(Integer.toString(data[3]));
		friday.setText(Integer.toString(data[4]));
		saturday.setText(Integer.toString(data[5]));
		sunday.setText(Integer.toString(data[6]));
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