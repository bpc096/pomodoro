package state;

import time.Phase;
import time.Time;

public abstract class TimerState {

	private Time time;
    private final Phase phase;
	private State state;

    public TimerState(Time time, Phase phase, State state) {
        this.time = time;
        this.phase = phase;
        this.state = state;
    }

	public Time getTime() {
        return time;
    }

    public Phase getPhase() {
        return phase;
    }

    public void decreaseOneSecond() {
        time = time.minusOneSecond();
    }
    
    protected abstract int onBreak();
    protected abstract int onLongBreak();
    protected abstract int onWork();

}
