package SaveToCsv;

import java.io.File;

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
		File file = new File("log.csv");
		CSVReaderWriter csv = new CSVReaderWriter();
		if(message instanceof SaveWork) {
			csv.writeCSV(file.getAbsolutePath(), ((SaveWork) message).getMessage());
		}else if(message instanceof SaveBreak) {
			csv.writeCSV(file.getAbsolutePath(), ((SaveBreak) message).getMessage());
		}else if(message instanceof SaveLongBreak) {
			csv.writeCSV(file.getAbsolutePath(), ((SaveLongBreak) message).getMessage());
		}
	}

}
