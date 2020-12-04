package event;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Event {
	private String time ="";

	public String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ssX");
		Date date = new Date();
		time = formatter.format(date);
		return time;
	}
}
