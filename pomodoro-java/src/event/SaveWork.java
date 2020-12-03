package event;

public class SaveWork extends Event{
	private String message;

	public SaveWork() {
		message =  this.getTime() + ", Done Work";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
