package state;

import time.Phase;
import time.Time;

public class BreakState extends TimerState{

	public BreakState(Time time, Phase phase, State state) {
		super(time, phase, state);
	}

	@Override
	public int onBreak() {
		return 5;
	}

	@Override
	public int onLongBreak() {
		return 0;
	}

	@Override
	public int onWork() {
		return 0;
	}

}
