package event;

public class SaveLongBreak extends Event{
	private String message;

	public SaveLongBreak() {
		setMessage(this.getTime() + ", Done Longbreak");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
