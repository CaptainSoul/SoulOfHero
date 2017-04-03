package dsa.iface;

public interface ITree<T> {
	public int size();
	public T replace(INode<T> n, T e);
	public INode<T> root();
	public INode<T> parent(INode<T> n);
	public boolean isEmpty();
	public boolean isRoot(INode<T> n);
	public boolean isInternal(INode<T> n);
	public boolean isExternal(INode<T> n);
	public IIterator<T> iterator();
	public IIterator<INode<T>> nodes();
	public IIterator<INode<T>> children(INode<T> n);
}
