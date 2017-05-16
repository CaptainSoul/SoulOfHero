package dsa.impl;

import dsa.iface.IQueue;

public class LinkedQueue<T> implements IQueue<T>{
	private int size;
	private QNode front;
	private QNode rear;
	
	private class QNode {
		public QNode next;
		public T element;
		
		public QNode(T element) {
			this.element = element;
			this.next = null;
		}
	}
	
	public LinkedQueue() {
		size = 0;
		front = null;
		rear = null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public T front() {
		return front.element;
	}
	
	public T dequeue() {
		T toReturn = front.element;
		front = front.next;
		if(front == null)
			rear = null;
		size--;
		return toReturn;
	}
	
	public void enqueue(T value) {
		QNode node = new QNode(value);
		if(rear == null)
			front = node;
		else
			rear.next = node;
		rear = node;
		size++;
	}
	
	public String toString() {
		String toReturn = "[" + size + " element(s)]: ";
		QNode node = front;
		while(node != null) {
			toReturn += "[" + node.element + "] -> ";
			node = node.next;
		}
		return toReturn;
	}
}
