package event;

public class SaveBreak extends Event{
	private String message;

	public SaveBreak() {
		setMessage(this.getTime() + ", Done Break");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
