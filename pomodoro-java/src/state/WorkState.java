package state;

import time.Phase;
import time.Time;

public class WorkState extends TimerState{

	public WorkState(Time time, Phase phase, State state) {
		super(time, phase, state);
	}

	@Override
	protected int onBreak() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int onLongBreak() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int onWork() {
		return 25;
	}

}
