package state;

public class State {
	
	TimerState timerState;
	int state;
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public State(TimerState timerState) {
		this.timerState = timerState;
	}

}
