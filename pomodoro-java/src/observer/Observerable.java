package observer;

public interface Observerable<T> {
	public void broadcast();
	
	public void addObserver(Observer<T> obs);

}
