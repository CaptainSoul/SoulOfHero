package dsa.impl;

import dsa.iface.IIterator;
import dsa.iface.IList;
import dsa.iface.INode;

public class ListIterator<T> implements IIterator<T> {
	private INode<T> node;
	private IList<T> list;
	
	public ListIterator(IList<T> list) {
		this.list = list;
		node = list.first();
	}
	
	public boolean hasNext() {
		return node != null;
	}
	
	public T next() {
		T toReturn = node.element();
		node = list.next(node);
		return toReturn;
	}
}
