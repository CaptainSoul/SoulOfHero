package dsa.iface;

public interface IBinaryTree<T> extends ITree<T>{
	public INode<T> left(INode<T> n);
	public INode<T> right(INode<T> n);
	public boolean hasLeft(INode<T> n);
	public boolean hasRight(INode<T> n);
}
