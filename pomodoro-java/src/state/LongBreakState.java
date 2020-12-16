package state;

import time.Phase;
import time.Time;

public class LongBreakState extends TimerState{

	public LongBreakState(Time time, Phase phase, State state) {
		super(time, phase, state);
	}

	@Override
	public int onBreak() {
		return 0;
	}

	@Override
	public int onLongBreak() {
		return 15;
	}

	@Override
	public int onWork() {
		return 0;
	}

}
