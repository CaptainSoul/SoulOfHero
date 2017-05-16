package dsa.iface;

public interface IQueue<T> {
	public int size();
	public boolean isEmpty();
	public T front();
	public T dequeue();
	public void enqueue(T value);
}
