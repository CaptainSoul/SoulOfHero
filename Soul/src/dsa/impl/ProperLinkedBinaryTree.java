package dsa.impl;

import dsa.iface.IBinaryTree;
import dsa.iface.IIterator;
import dsa.iface.IList;
import dsa.iface.INode;
import dsa.iface.IQueue;

public class ProperLinkedBinaryTree<T> implements IBinaryTree<T> {
	protected BTNode root;
	protected int size;
	
	protected class BTNode implements INode<T> {
		BTNode parent;
		BTNode left, right;
		T element;
		
		public BTNode(T element, BTNode parent) {
			this(element, parent, null, null);
		}
		
		public BTNode(T element, BTNode parent, BTNode left, BTNode right) {
			this.element = element;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		
		public T element() {
			return element;
		}
	}
	
	public ProperLinkedBinaryTree() {
		root = new BTNode(null, null);
		size = 1;
	}
	
	public int size() {
		return size;
	}
	
	public T replace(INode<T> n, T e) {
		T toReturn = n.element();
		((BTNode) n).element = e;
		return toReturn;
	}
	
	public INode<T> root() {
		return root;
	}
	
	public INode<T> parent(INode<T> n) {
		return ((BTNode) n).parent;
	}
	
	public INode<T> left(INode<T> n) {
		return ((BTNode) n).left;
	}
	
	public INode<T> right(INode<T> n) {
		return ((BTNode) n).right;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isRoot(INode<T> n) {
		return root == n;
	}
	
	public boolean isInternal(INode<T> n) {
		return hasLeft(n) || hasRight(n);
	}
	
	public boolean isExternal(INode<T> n) {
		return !hasLeft(n) && !hasLeft(n);
	}
	
	public boolean hasLeft(INode<T> n) {
		return left(n) != null;
	}
	
	public boolean hasRight(INode<T> n) {
		return right(n) != null;
	}
	
	public IIterator<T> iterator() {
		IList<T> elements = new SLinkedList<T>();
		IIterator<INode<T>> it = nodes();
		while(it.hasNext()) {
			INode<T> node = it.next();
			if(isInternal(node)) {
				elements.insertLast(node.element());
			}
		}
		return new ListIterator<T>(elements);
	}
	
	public IIterator<INode<T>> nodes() {
		IQueue<INode<T>> toVisit = new LinkedQueue<INode<T>>();
		toVisit.enqueue(root());
		IList<INode<T>> nodes = new SLinkedList<INode<T>>();
		while(!toVisit.isEmpty()) {
			INode<T> node = toVisit.dequeue();
			nodes.insertLast(node);
			IIterator<INode<T>> it = children(node);
			while(it.hasNext()) {
				toVisit.enqueue(it.next());
			}
		}
		return new ListIterator<INode<T>>(nodes);
	}
	
	public IIterator<INode<T>> children(INode<T> n) {
		BTNode node = (BTNode) n;
		IList<INode<T>> list = new SLinkedList<INode<T>>();
		if(isInternal(n)){
			list.insertLast(node.left);
			list.insertLast(node.right);
		}
		return new ListIterator<INode<T>>(list);
	}
	
	public T remove(INode<T> n) {
		BTNode node = (BTNode) n;
		if(isExternal(node.left)) {
			if(node == root) {
				root = node.right;
				node.right.parent = null;
			} else if (node.parent.left == node) {
				node.parent.left = node.right;
				node.right.parent = node.parent;
				node.left.parent = null;
			} else {
				node.parent.right = node.right;
				node.right.parent = node.parent;
				node.left.parent = null;
			}
			node.left = null;
			node.right = null;
			node.parent = null;
		} else if(isExternal(node.right)) {
			if(node == root) {
				root = node.left;
				node.left.parent = null;
			} else if(node.parent.left == node) {
				node.parent.left = node.left;
				node.left.parent = node.parent;
				node.right.parent = null;
			} else {
				node.parent.right = node.left;
				node.left.parent = node.parent;
				node.right.parent = null;
			}
			node.left = null;
			node.right = null;
			node.parent = null;
		} else {
			throw new RuntimeException("Cannot remove a node with two internal children.");
		}
		T temp = node.element;
		node.element = null;
		size -= 2;
		return temp;
	}
	
	public void expandExternal(INode<T> n, T e) {
		if(isInternal(n))
			throw new RuntimeException("Not an external node");
		BTNode node = (BTNode) n;
		node.element = e;
		node.left = new BTNode(null, node);
		node.right = new BTNode(null, node);
		size += 2;
	}
	
	public static <E> ProperLinkedBinaryTree<E> merge(E root, ProperLinkedBinaryTree<E> a, ProperLinkedBinaryTree<E> b) {
		ProperLinkedBinaryTree<E> toReturn = new ProperLinkedBinaryTree<E>();
		toReturn.root.element = root;
		toReturn.root.left = a.root;
		a.root.parent = toReturn.root;
		toReturn.root.right = b.root;
		b.root.parent = toReturn.root;
		return toReturn;
	}

}
