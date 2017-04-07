package dsa.impl;

import dsa.iface.IIterator;
import dsa.iface.IList;
import dsa.iface.INode;

public class SLinkedList<T> implements IList<T> {
	private SNode top;
	private int size;
	
	private class SNode implements INode<T> {
		public SNode next;
		public T element;
		
		public T element() {
			return element;
		}
		
		public SNode(T element, SNode next) {
			this.element = element;
			this.next = next;
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public T remove(INode<T> n) {
		SNode n1 = (SNode) n;
		if(n1 == top) {
			top = top.next;
			n1.next = null;
		} else {
			SNode pre = (SNode) prev(n1);
			pre.next = n1.next;
			n1.next = null;
		}
		size--;
		return n.element();
	}
	
	public T replace(INode<T> n, T e) {
		SNode n1 = (SNode) n;
		T toReturn = n1.element();
		n1.element = e;
		return toReturn;
	}
	
	public INode<T> first() {
		return top;
	}
	
	public INode<T> last() {
		SNode last = top;
		while(last.next != null) {
			last = last.next;
		}
		return last;
	}
	
	public INode<T> prev(INode<T> n) {
		SNode pre = top;
		while(pre != null && pre.next != n) {
			pre = pre.next;
		}
		return pre;
	}
	
	public INode<T> next(INode<T> n) {
		SNode n1 = (SNode) n;
		return n1.next;
	}
	
	public INode<T> insertFirst(T e) {
		SNode n = new SNode(e, top);
		top = n;
		size++;
		return n;
	}
	
	public INode<T> insertLast(T e) {
		if(isEmpty()) {
			return insertFirst(e);
		} else {
			SNode last = (SNode) last();
			SNode down = new SNode(e, null);
			last.next = down;
			size++;
			return down;
		}
	}
	
	public INode<T> insertBefore(INode<T> n, T e) {
		SNode n1 = (SNode) n;
		if(n1 == top) {
			return insertFirst(e);
		} else {
			SNode pre = (SNode) prev(n1);
			SNode down = new SNode(e, n1);
			pre.next = down;
			size++;
			return down;
		}
	}
	
	public INode<T> insertAfter(INode<T> n, T e) {
		SNode n1 = (SNode) n;
		SNode down = new SNode(e, n1.next);
		n1.next = down;
		size++;
		return down;
	}
	
	public IIterator<T> iterator() {
		return new ListIterator<T>(this);
	}
}
