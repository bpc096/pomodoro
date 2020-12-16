package logic;

import java.util.Vector;

import SaveToCsv.SaveToCsv;
import event.Event;
import event.SaveBreak;
import event.SaveLongBreak;
import event.SaveWork;
import observer.Observer;
import observer.Observerable;

public class Pomodoro implements Observerable<Event>{
	private Vector<Observer<Event>> observers;
	
	public Pomodoro() {
		observers = new Vector<>();
		addObserver(new SaveToCsv());
	}
	
	public void saveBreak() {
		broadcast(new SaveBreak());
	}
	
	public void saveLongBreak() {
		broadcast(new SaveLongBreak()); 
	}
	
	public void saveWork() {
		broadcast(new SaveWork());
	}

	@Override
	public void broadcast(Event message) {
		for(Observer<Event> obs : observers) {
			obs.update(message);				
		}
		
	}

	@Override
	public void addObserver(Observer<Event> obs) {
		observers.add(obs);
	}
}
