package event;

import java.util.Calendar;

public abstract class Event {
	private String time = Calendar.getInstance().getTime().toString();

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
