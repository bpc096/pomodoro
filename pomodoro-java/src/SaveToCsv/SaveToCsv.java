package SaveToCsv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import event.Event;
import event.SaveBreak;
import event.SaveLongBreak;
import event.SaveWork;
import observer.Observer;

public class SaveToCsv implements Observer<Event>{

	public SaveToCsv() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Event message) {
		FileWriter csvWriter =null;
		try {
			csvWriter = new FileWriter("D:\\__Kuliah\\Semester 5\\FLA\\pomodoro\\pomodoro-java\\src\\log\\log.csv",true);
			if(message instanceof SaveWork) {
				csvWriter.append(((SaveWork) message).getMessage());
				csvWriter.append("\n");
			}else if(message instanceof SaveBreak) {
				csvWriter.append(((SaveBreak) message).getMessage());
				csvWriter.append("\n");
			}else if(message instanceof SaveLongBreak) {
				csvWriter.append(((SaveLongBreak) message).getMessage());
				csvWriter.append("\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				csvWriter.flush();
				csvWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
