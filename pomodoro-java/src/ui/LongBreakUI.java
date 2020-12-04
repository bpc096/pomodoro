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

import event.SaveLongBreak;
import logic.Pomodoro;

public class LongBreakUI extends JFrame{
	JButton btnLongBreakSkip = new JButton();
	JButton btnLongBreakResume = new JButton();
	JLabel lblLongBreakTime = new JLabel("15:00");
	JButton btnLongBreakViewStats = new JButton("view stats");
	
	int LongBreakSecond = 0;
	int LongBreakMinute = 15;
	String ddLongBreakSecond, ddLongBreakMinute;
	Timer LongBreakTimer;
	
	boolean clicked = true;
	DecimalFormat dFormat = new DecimalFormat("00");

	// Create the application.
	public LongBreakUI() {
		breakInitialize();
	}

	// Initialize the contents of the frame
		public void breakInitialize() {
			breakConfig();
			getContentPane().setLayout(null);
			
			// show time
			lblLongBreakTime.setForeground(new Color(0, 0, 0));
			lblLongBreakTime.setHorizontalAlignment(SwingConstants.CENTER);
			lblLongBreakTime.setFont(new Font("Lato", Font.PLAIN, 59));
			lblLongBreakTime.setBounds(98, 0, 228, 123);
			getContentPane().add(lblLongBreakTime);
			
			// show pause and resume button
			btnLongBreakResume.setIcon(new ImageIcon("res/play.png"));
			btnLongBreakResume.setBounds(143, 124, 97, 25);
			btnLongBreakResume.setBorderPainted(false); 
			btnLongBreakResume.setContentAreaFilled(false); 
			btnLongBreakResume.setFocusPainted(false); 
			btnLongBreakResume.setOpaque(false);
			btnLongBreakResume.setIcon(new ImageIcon("res/pause.png"));
	        clicked = false;
	        resume();
			btnPauseResume();
			getContentPane().add(btnLongBreakResume);
			
			// show viewstats button
			btnLongBreakViewStats.setBounds(285, 211, 139, 26);
			btnLongBreakViewStats.setFont(new Font("Lato", Font.PLAIN, 19));
			btnLongBreakViewStats.setBorderPainted(false); 
			btnLongBreakViewStats.setContentAreaFilled(false); 
			btnLongBreakViewStats.setFocusPainted(false); 
			btnLongBreakViewStats.setOpaque(false);
			btnLongBreakViewStats();
			getContentPane().add(btnLongBreakViewStats);
			
			//show skip button
			btnLongBreakSkip.setIcon(new ImageIcon("res/skip.png"));
			btnLongBreakSkip.setBounds(200, 124, 97, 25);
			btnLongBreakSkip.setBorderPainted(false); 
			btnLongBreakSkip.setContentAreaFilled(false); 
			btnLongBreakSkip.setFocusPainted(false); 
			btnLongBreakSkip.setOpaque(false);
			btnSkip();
			getContentPane().add(btnLongBreakSkip);
		}
		
	// to start the timer
	private void resume() {
		LongBreakTimer = new Timer(10, new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				LongBreakSecond--;
				ddLongBreakSecond = dFormat.format(LongBreakSecond);
				ddLongBreakMinute = dFormat.format(LongBreakMinute);
				lblLongBreakTime.setText(ddLongBreakMinute + ":" + ddLongBreakSecond);
					
				if(LongBreakSecond == -1) {
					LongBreakSecond = 59;
					LongBreakMinute--;
						
					ddLongBreakSecond = dFormat.format(LongBreakSecond);
					ddLongBreakMinute = dFormat.format(LongBreakMinute);
					lblLongBreakTime.setText(ddLongBreakMinute + ":" + LongBreakSecond);
				}
					
				if(LongBreakMinute == 0 && LongBreakSecond == 0) {
					//selesai long break
					LongBreakTimer.stop();
					setVisible(false);
					Pomodoro p = new Pomodoro();
					p.broadcast(new SaveLongBreak());
					new WorkUI().setVisible(true);
				}
			}
		});
		LongBreakTimer.start();
	}
		
	private void btnSkip() {
		btnLongBreakSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LongBreakTimer.stop();
				setVisible(false);
				new WorkUI().setVisible(true);
			}
		});
	}
		
	// to view stats
	private void btnLongBreakViewStats() {
		btnLongBreakViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewStats().setVisible(true);
					
			}
		});
	}
		
	// to start (or resume) and pause the timer
	private void btnPauseResume() {
		btnLongBreakResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clicked) {
					btnLongBreakResume.setIcon(new ImageIcon("res/pause.png"));
					clicked = false;
					
					resume();
				} else {
					btnLongBreakResume.setIcon(new ImageIcon("res/play.png"));
				    clicked = true;
				        
				    LongBreakTimer.stop();
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
}
