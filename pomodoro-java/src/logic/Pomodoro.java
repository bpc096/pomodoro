package logic;

import java.util.Vector;

import event.Event;
import observer.Observer;
import observer.Observerable;

public class Pomodoro implements Observerable<Event>{
	private Vector<Observer<Event>> observers;
	
	public Pomodoro() {
		observers = new Vector<>();
	}

	@Override
	public void broadcast() {
		for(Observer<Event> obs : observers) {
			obs.update();
		}
		
	}

	@Override
	public void addObserver(Observer<Event> obs) {
		observers.add(obs);
	}
	
	

}
