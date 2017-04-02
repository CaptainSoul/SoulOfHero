package dsa.iface;

public interface IList<T> {
	public int size();
	public boolean isEmpty();
	public T remove(INode<T> n);
	public T replace(INode<T> n, T e);
	public INode<T> first();
	public INode<T> last();
	public INode<T> prev(INode<T> n);
	public INode<T> next(INode<T> n);
	public INode<T> insertFirst(T e);
	public INode<T> insertLast(T e);
	public INode<T> insertBefore(INode<T> n, T e);
	public INode<T> insertAfter(INode<T> n, T e);
	public IIterator<T> iterator();
}
