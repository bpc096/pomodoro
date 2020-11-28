import java.awt.EventQueue;

import javax.swing.JFrame;

import ui.WorkUI;

public class Main extends JFrame
{
	public Main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkUI window = new WorkUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		new Main();

	}

}
