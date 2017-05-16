package dsa.impl;



import dsa.iface.IIterator;
import dsa.iface.INode;
import dsa.impl.BinarySearchTree;

public class SplayTree<T extends Comparable<T>> extends BinarySearchTree<T> {

	/**
	 * Insert a value into the tree.
	 * 
	 * The node that is expanded to add the new value should be splayed.
	 */
	public void insert(T value) {
		INode<T> find = super.find(root, value);
		if(find.element() == null) {
			super.expandExternal(find, value);
			splay(find);
		} else {
			throw new RuntimeException("cannot insert duplicate value");
		}
	}

	/**
	 * Check if a value is found in the tree.
	 * 
	 * If it is found, the node that contains it should be splayed.
	 * If it is not found, the parent of the external node that the search reached should be splayed.
	 */
	public boolean contains(T value) {
		INode<T> find = super.find(root, value);
		if(find.element() != null) {
			splay(find);
			return true;
		}
		splay(parent(find));
		return false;
	}

	/**
	 * Remove a value from the tree.
	 * 
	 * If it is removed, the parent of the node that was actually removed should be splayed.
	 */
	public void remove(T value) {
		INode<T> find = super.find(root, value);
		if(find.element() != null) {
			INode<T> parent = parent(find);
			if (isExternal(left(find)) || isExternal(right(find))) {
				super.remove(find);
			} else if(isInternal(left(find)) && isInternal(right(find))) {
				INode<T> next = parent(super.find(right(find), value));
				parent = parent(next);
				replace( find, next.element() );
				super.remove(next);
			}
			splay(parent);
		} else {
			throw new RuntimeException("cannot remove an external node");
		}
	}

	/**
	 * Splay a node.
	 * @param n The node to be splayed.
	 */
	private void splay(INode<T> n) {
		while(parent(n) != null) {
			BTNode node = (BTNode) n;
			if(isRoot(node.parent)) {
				if(node == node.parent.left) {
					zig(n);
				}
				else if(node == node.parent.right) {
					zag(n);
				}
			} else {
				if(node == node.parent.left) {
					if(node.parent == node.parent.parent.left) {
						zigZig(n);
					}
					else if(node.parent == node.parent.parent.right) {
						zigZag(n);
					}
				} else if(node == node.parent.right) {
					if(node.parent == node.parent.parent.left) {
						zagZig(n);
					}
					else if(node.parent == node.parent.parent.right) {
						zagZag(n);
					}
				}
			}
		}
	}
	
	/**
	 * Check root
	 * @param n the node to set root if it don't have parent
	 */
	public void setRoot(INode<T> n) {
		if(parent(n) == null)
			root = (BTNode) n;
	}
	
	/**
	 * Clockwise rotation
	 * @param n the node to be rotated clockwise
	 */
	private void zig(INode<T> n) {
		BTNode x = (BTNode) n;
		BTNode y = x.parent;
		BTNode t3 = x.right;
		
		// if y is root, check references of y and x
		if(!isRoot(y)) {
			if(y == y.parent.left)
				y.parent.left = x;
			else if(y == y.parent.right)
				y.parent.right = x;
		}
		y.left = t3;
		t3.parent = y;
		x.parent = y.parent;
		y.parent = x;
		x.right = y;
		setRoot(n);
	}
	
	/**
	 * Anticlockwise rotation
	 * @param n The node to be rotated anticlockwise
	 */
	private void zag(INode<T> n) {
		BTNode x = (BTNode) n;
		BTNode y = x.parent;
		BTNode t2 = x.left;
		
		// if y is root, check references of y and x
		if(!isRoot(y)) {
			if(y == y.parent.left)
				y.parent.left = x;
			else if(y == y.parent.right)
				y.parent.right = x;
		}
		y.right = t2;
		t2.parent = y;
		x.parent = y.parent;
		y.parent = x;
		x.left = y;
		setRoot(n);
	}
	
	/**
	 * Double clockwise rotations
	 * @param n The node to be rotated
	 */
	private void zigZig(INode<T> n) {
		zig(parent(n));
		zig(n);
	}
	
	/**
	 * Double anticlockwise rotations
	 * @param n The node to be rotated
	 */
	private void zagZag(INode<T> n) {
		zag(parent(n));
		zag(n);
	}
	
	/**
	 * Clockwise rotation and then anticlockwise rotation
	 * @param n The node to be rotated
	 */
	private void zigZag(INode<T> n) {
		zig(n);
		zag(n);
	}
	
	/**
	 * Anticlockwise rotation and then clockwise rotation
	 * @param n The node to be rotated
	 */
	private void zagZig(INode<T> n) {
		zag(n);
		zig(n);
	}
	
	/**
	 * Check reference of the tree
	 * @param start The node to be start of checking
	 * @return true if all of references are correct or false if not
	 */
	public boolean checkReference(INode<T> start) {
		if(isExternal(start)) {
			return true;
		}
		boolean toReturn1 = checkReference(left(start));
		boolean toReturn2 = checkReference(right(start));
		if(start != parent(left(start)) || start != parent(right(start))) {
			return false;
		}
		if(toReturn1 && toReturn2) {
			return true;
		}
		return false;
	}
	
	/**
	 * Construct a binary search tree with same structure and data
	 * @param Tree The tree to be copied
	 * @return Equivalent binary search tree
	 */
	public static <E extends Comparable<E>> BinarySearchTree<E> parseBST(SplayTree<E> tree) {
		BinarySearchTree<E> bst = new BinarySearchTree<>();
		if(tree.isEmpty())
			return null;
		IIterator<E> iterator = tree.iterator();
		while(iterator.hasNext()) {
			bst.insert(iterator.next());
		}
		return bst;
	}
	
	/**
	 * Construct a AVL tree with same structure and data
	 * @param Tree The tree to be copied
	 * @return Equivalent AVL tree
	 */
	public static <E extends Comparable<E>> AVLTree<E> parseAVLTree(SplayTree<E> tree) {
		AVLTree<E> avlt = new AVLTree<>();
		if(tree.isEmpty())
			return null;
		IIterator<E> iterator = tree.iterator();
		while(iterator.hasNext()) {
			avlt.insert(iterator.next());
		}
		return avlt;
	}

}
