package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import state.State;

public class BreakUI extends JFrame{
	JLabel breakState1 = new JLabel();
	JLabel breakState2 = new JLabel();
	JLabel breakState3 = new JLabel();
	JLabel breakState4 = new JLabel();
	JButton btnBreakSkip = new JButton();
	JButton btnBreakResume = new JButton();
	JLabel lblBreakTime = new JLabel("05:00");
	JButton btnBreakViewStats = new JButton("view stats");
	
	int state = 1;
	int breakSecond = 0;
	int breakMinute = 5;
	String ddBreakSecond, ddBreakMinute;
	Timer breakTimer;
	
	boolean clicked = true;
	DecimalFormat dFormat = new DecimalFormat("00");
	
	public BreakUI(int state) {
		this.state = state;
		breakInitialize();
	}

	// Initialize the contents of the frame
	public void breakInitialize() {
		breakConfig();
		getContentPane().setLayout(null);
			
		// show time
		lblBreakTime.setForeground(new Color(0, 0, 0));
		lblBreakTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblBreakTime.setFont(new Font("Lato", Font.PLAIN, 59));
		lblBreakTime.setBounds(98, 0, 228, 123);
		getContentPane().add(lblBreakTime);
			
		// show pause and resume button
		btnBreakResume.setIcon(new ImageIcon("res/play.png"));
		btnBreakResume.setBounds(143, 124, 97, 25);
		btnBreakResume.setBorderPainted(false); 
		btnBreakResume.setContentAreaFilled(false); 
		btnBreakResume.setFocusPainted(false); 
		btnBreakResume.setOpaque(false);
		btnBreakResume.setIcon(new ImageIcon("res/pause.png"));
	    clicked = false;
	    resume();
		btnPauseResume();
		getContentPane().add(btnBreakResume);
			
		// show viewstats button
		btnBreakViewStats.setBounds(285, 211, 139, 26);
		btnBreakViewStats.setFont(new Font("Lato", Font.PLAIN, 19));
		btnBreakViewStats.setBorderPainted(false); 
		btnBreakViewStats.setContentAreaFilled(false); 
		btnBreakViewStats.setFocusPainted(false); 
		btnBreakViewStats.setOpaque(false);
		btnBreakViewStats();
		getContentPane().add(btnBreakViewStats);
			
		//show skip button
		btnBreakSkip.setIcon(new ImageIcon("res/skip.png"));
		btnBreakSkip.setBounds(200, 124, 97, 25);
		btnBreakSkip.setBorderPainted(false); 
		btnBreakSkip.setContentAreaFilled(false); 
		btnBreakSkip.setFocusPainted(false); 
		btnBreakSkip.setOpaque(false);
		btnSkip();
		getContentPane().add(btnBreakSkip);
			
		// show state 1
		breakState1.setIcon(new ImageIcon("res/outline_dot.png"));
		breakState1.setBounds(185, 175, 26, 16);
			
		getContentPane().add(breakState1);
			
		// show state 2
		breakState2.setIcon(new ImageIcon("res/outline_dot.png"));
		breakState2.setBounds(208, 175, 26, 16);
			
		getContentPane().add(breakState2);
			
		// show state 3
		breakState3.setIcon(new ImageIcon("res/outline_dot.png"));
		breakState3.setBounds(234, 175, 26, 16);
			
		getContentPane().add(breakState3);
			
		// show state 4
		breakState4.setIcon(new ImageIcon("res/outline_dot.png"));
		breakState4.setBounds(162, 175, 26, 16);
			
		getContentPane().add(breakState4);
		
		wState();
	}
		
	// to start the timer
	private void resume() {
		breakTimer = new Timer(10, new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				breakSecond--;
				ddBreakSecond = dFormat.format(breakSecond);
				ddBreakMinute = dFormat.format(breakMinute);
				lblBreakTime.setText(ddBreakMinute + ":" + ddBreakSecond);
					
				if(breakSecond == -1) {
					breakSecond = 59;
					breakMinute--;
						
					ddBreakSecond = dFormat.format(breakSecond);
					ddBreakMinute = dFormat.format(breakMinute);
					lblBreakTime.setText(ddBreakMinute + ":" + breakSecond);
				}
					
				if(breakMinute == 0 && breakSecond == 0) {
					breakTimer.stop();
					setVisible(false);
					state += 1;
					
					WorkUI w = new WorkUI(state);
					w.setVisible(true);
				}
			}
		});
		breakTimer.start();
	}
		
	private void btnSkip() {
		btnBreakSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				breakTimer.stop();
				setVisible(false);
				state += 1;
				WorkUI w = new WorkUI(state);
				w.setVisible(true);
			}
		});
	}
		
	// to view stats
	private void btnBreakViewStats() {
		btnBreakViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewStats().setVisible(true);
					
			}
		});
	}
	
	// to start (or resume) and pause the timer
	private void btnPauseResume() {
		btnBreakResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clicked) {
					btnBreakResume.setIcon(new ImageIcon("res/pause.png"));
			        clicked = false;
			        
			        resume();
			    } else {
			    	btnBreakResume.setIcon(new ImageIcon("res/play.png"));
			        clicked = true;
				        
				    breakTimer.stop();
				}
			}
		});
	}
		
	// Initialize the contents of the frame
	private void breakConfig() {
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(new Dimension(430, 285));
		getContentPane().setBackground(new Color(153, 255, 255).darker());
		setIconImage(new ImageIcon("res/tomato.png").getImage());
		setTitle("Pomodoro");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void wState() {
		if(state == 1) {
			breakState4.setIcon(new ImageIcon("res/filled_dot.png"));
		}
		
		if(state == 2) {
			breakState1.setIcon(new ImageIcon("res/filled_dot.png"));
			breakState4.setIcon(new ImageIcon("res/filled_dot.png"));
		}
		
		if(state == 3) {
			breakState2.setIcon(new ImageIcon("res/filled_dot.png"));
			breakState4.setIcon(new ImageIcon("res/filled_dot.png"));
			breakState1.setIcon(new ImageIcon("res/filled_dot.png"));
		}
		
		if(state == 4) {
			breakState3.setIcon(new ImageIcon("res/filled_dot.png"));
			breakState4.setIcon(new ImageIcon("res/filled_dot.png"));
			breakState1.setIcon(new ImageIcon("res/filled_dot.png"));
			breakState2.setIcon(new ImageIcon("res/filled_dot.png"));
		}
	}
}
