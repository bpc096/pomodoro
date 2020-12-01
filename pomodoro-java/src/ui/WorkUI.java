package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;


import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class WorkUI extends JFrame{
	JLabel workState1 = new JLabel();
	JLabel workState2 = new JLabel();
	JLabel workState3 = new JLabel();
	JLabel workState4 = new JLabel();
	JButton btnWorkResume = new JButton();
	JLabel lblWorkTime = new JLabel("25:00");
	JButton btnWorkViewStats = new JButton("view stats");
		
	int workSecond = 0;
	int workMinute = 25;
	boolean clicked = true;
	String ddworkSecond, ddworkMinute;
	DecimalFormat dFormat = new DecimalFormat("00");
	Timer workTimer;
	int state = 1;

	public WorkUI() {
		workInitialize(this.state);
	}

	public WorkUI(int state) {
		this.state = state;
		workInitialize(this.state);
	}
	
	// Initialize the contents of the frame
	public void workInitialize(int state) {
		workConfig();
		// show time
		lblWorkTime.setForeground(new Color(0, 0, 0));
		lblWorkTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkTime.setFont(new Font("Lato", Font.PLAIN, 59));
		lblWorkTime.setBounds(98, 0, 228, 123);
		getContentPane().add(lblWorkTime);
		
		// show pause and resume button
		btnWorkResume.setIcon(new ImageIcon("res/play.png"));
		btnWorkResume.setBounds(162, 123, 97, 25);
		btnWorkResume.setBorderPainted(false); 
		btnWorkResume.setContentAreaFilled(false); 
		btnWorkResume.setFocusPainted(false); 
		btnWorkResume.setOpaque(false);
		getContentPane().add(btnWorkResume);
		btnPauseResume();
		btnWorkViewStats.setFont(new Font("Lato", Font.PLAIN, 19));
		
		// show viewstats button
		btnWorkViewStats.setBounds(298, 212, 126, 25);
		btnWorkViewStats.setBorderPainted(false); 
		btnWorkViewStats.setContentAreaFilled(false); 
		btnWorkViewStats.setFocusPainted(false); 
		btnWorkViewStats.setOpaque(false);
		btnWorkViewStats();
		getContentPane().add(btnWorkViewStats);
		
		// show state 1
		workState1.setIcon(new ImageIcon("res/outline_dot.png"));
		workState1.setBounds(185, 175, 26, 16);
		getContentPane().add(workState1);
		
		// show state 2
		workState2.setIcon(new ImageIcon("res/outline_dot.png"));
		workState2.setBounds(208, 175, 26, 16);
		getContentPane().add(workState2);
		
		// show state 3
		workState3.setIcon(new ImageIcon("res/outline_dot.png"));
		workState3.setBounds(234, 175, 26, 16);
		getContentPane().add(workState3);
		
		// show state 4
		workState4.setIcon(new ImageIcon("res/filled_dot.png"));
		workState4.setBounds(162, 175, 26, 16);
		getContentPane().add(workState4);
		wState();
	}
	
	// to start the timer
	private void resume() {
		workTimer = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				workSecond--;
				ddworkSecond = dFormat.format(workSecond);
				ddworkMinute = dFormat.format(workMinute);
				lblWorkTime.setText(ddworkMinute + ":" + ddworkSecond);
				
				if(workSecond == -1) {
					workSecond = 59;
					workMinute--;
					
					ddworkSecond = dFormat.format(workSecond);
					ddworkMinute = dFormat.format(workMinute);
					lblWorkTime.setText(ddworkMinute + ":" + workSecond);
				}
				
				if(workMinute == 0 && workSecond == 0) {
					workTimer.stop();
					if(state == 4) {
						LongBreakUI lb = new LongBreakUI();
						lb.setVisible(true);
						setVisible(false);
					}else {
						BreakUI b = new BreakUI(state);
						b.setVisible(true);
						setVisible(false);	
					}
						
				}
			}
		});
		workTimer.start();
	}
	
	// to view stats
	private void btnWorkViewStats() {
		btnWorkViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewStats().setVisible(true);
			}
		});
	}

	// to start (or resume) and pause the timer
	private void btnPauseResume() {
		btnWorkResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clicked) {
			        btnWorkResume.setIcon(new ImageIcon("res/pause.png"));
			        clicked = false;
			        
			        resume();
			    } else {
			        btnWorkResume.setIcon(new ImageIcon("res/play.png"));
			        clicked = true;
			        
			        workTimer.stop();
			    }
			}
		});
	}
	
	private void wState() {
		if(state == 1) {
			workState4.setIcon(new ImageIcon("res/twotone_dot.png"));
		}
		
		if(state == 2) {
			workState1.setIcon(new ImageIcon("res/twotone_dot.png"));
			workState4.setIcon(new ImageIcon("res/filled_dot.png"));
		}
		
		if(state == 3) {
			workState2.setIcon(new ImageIcon("res/twotone_dot.png"));
			workState4.setIcon(new ImageIcon("res/filled_dot.png"));
			workState1.setIcon(new ImageIcon("res/filled_dot.png"));
		}
		
		if(state == 4) {
			workState3.setIcon(new ImageIcon("res/twotone_dot.png"));
			workState4.setIcon(new ImageIcon("res/filled_dot.png"));
			workState1.setIcon(new ImageIcon("res/filled_dot.png"));
			workState2.setIcon(new ImageIcon("res/filled_dot.png"));
		}
	}
	
	// frame configuration
	private void workConfig() {
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(new Dimension(430, 285));
		getContentPane().setBackground(new Color(255, 51, 51).brighter());
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setIconImage(new ImageIcon("res/tomato.png").getImage());
		setTitle("Pomodoro");
	}
}

