package dsa.impl;
import dsa.iface.INode;
import dsa.impl.BinarySearchTree;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {
	
	/**
	 * Insert a value into the tree.
	 * 
	 * The node that is expanded to add the new value should be checked balance.
	 */
	@Override
	public void insert(T value) {
		INode<T> find = super.find(root, value);
		if(find.element() == null) {
			super.expandExternal(find, value);
			checkBalance(find);
		} else {
			throw new RuntimeException("cannot insert duplicate value");
		}
	}
	
	/**
	 * Check if a value is found in the tree.
	 * 
	 * If it is found, the node that contains it should be checked balance.
	 * If it is not found, the parent of the external node that the search reached should be checked balance.
	 */
	@Override
	public void remove(T value) {
		INode<T> find = super.find(root, value);
		if(find.element() != null) {
			INode<T> parent = parent(find);
			if (isExternal(left(find)) || isExternal(right(find))) {
				super.remove(find);
				checkBalance(parent);
			} else if(isInternal(left(find)) && isInternal(right(find))) {
				INode<T> next = parent(super.find(right(find), value));
				parent = parent(next);
				replace( find, next.element() );
				super.remove(next);
				checkBalance(find);
			}
		} else {
			throw new RuntimeException("cannot remove an external node");
		}
	}
	
	/**
	 * Get height
	 * @param n The node to get height
	 * @return 0 if is external or plus one every level
	 */
	public int height(INode<T> n) {
		if(isExternal(n)) {
			return 0;
		}
		return 1 + Math.max(height(left(n)), height(right(n)));
	}
	
	/**
	 * Get balance factor
	 * @param n The node to get balance factor
	 * @return height of left minus height of right
	 */
	private int balanceFactor(INode<T> n) {
		return height(left(n)) - height(right(n));
	}
	
	/**
	 * Restructure the tree
	 * @param n The node to be started restructure
	 */
	private void restructure(INode<T> n) {
		INode<T> x = n;
		INode<T> y = parent(n);
		INode<T> z = parent(y);
		int bFactorZ = balanceFactor(z);
		int bFactorY = balanceFactor(y);
		
		if(bFactorY > 0) {
			if(bFactorZ > 0) {
				zig(y);
			} else if(bFactorZ < 0) {
				zigZag(x);
			}
		} else if(bFactorY < 0) {
			if(bFactorZ > 0) {
				zagZig(x);
			} else if(bFactorZ < 0) {
				zag(y);
			}
		}
	}
	
	/**
	 * Check balance
	 * @param n The node start to be checked
	 * Call restructure after finding unbalanced
	 */
	private void checkBalance(INode<T> n) {
		int factor = balanceFactor(n);
		INode<T> toRestructure = n;
		if(factor > 1) {
			if(balanceFactor(left(n)) > 0) {
				toRestructure = left(left(n));
			} else {
				toRestructure = right(left(n));
			}
			restructure(toRestructure);
		} else if(factor < -1) {
			if(balanceFactor(right(n)) > 0) {
				toRestructure = left(right(n));
			} else {
				toRestructure = right(right(n));
			}
			restructure(toRestructure);
		} else {
			if(!isRoot(n)) {
				checkBalance(parent(n));
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
}
