package observer;

public interface Observerable<T> {
	public void broadcast(T message);
	
	public void addObserver(Observer<T> obs);

}
