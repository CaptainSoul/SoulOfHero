package dsa.impl;

import dsa.iface.IEntry;
import dsa.iface.IIterator;
import dsa.iface.IMap;
import dsa.iface.INode;

public class BSTMap<K, V> implements IMap<K, V> {
	private ProperLinkedBinaryTree<IEntry<K, V>> tree;
	private int size;
	
	private class BSTEntry implements IEntry<K, V> {
		private K key;
		private V value;
		
		public BSTEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K key() {
			return key;
		}
		
		public V value() {
			return value;
		}
		
		public String toString() {
			return "{" + key + ", " + value + "}";
		}
	}
	
	public BSTMap() {
		tree = new ProperLinkedBinaryTree<IEntry<K, V>>();
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public INode<IEntry<K, V>> find(INode<IEntry<K, V>> position, K key) {
		if(tree.isExternal(position))
			return position;
		
		@SuppressWarnings("rawtypes")
		Comparable c = (Comparable) key;
		@SuppressWarnings("unchecked")
		int result = c.compareTo(position.element().key());
		
		if(result < 0)
			return find(tree.left(position), key);
		else if(result > 0)
			return find(tree.right(position), key);
		
		return position;
	}
	
	public V get(K k) {
		INode<IEntry<K, V>> position = find(tree.root(), k);
		if(tree.isExternal(position)) {
			return null;
		} else {
			return position.element().value();
		}
	}
	
	public V put(K k, V v) {
		INode<IEntry<K, V>> position = find(tree.root(), k);
		IEntry<K, V> temp = new BSTEntry(k, v);
		if(tree.isExternal(position)) {
			tree.expandExternal(position, temp);
			return v;
		} else {
			V toReturn = position.element().value();
			tree.replace(position, temp);
			return toReturn;
		}
	}
	
	public V remove(K k) {
		INode<IEntry<K, V>> position = find(tree.root(), k);
		if(tree.isInternal(tree.left(position)) && tree.isInternal(tree.right(position))){
			INode<IEntry<K, V>> next = tree.parent(find(tree.right(position), position.element().key()));
			tree.replace(position, next.element());
			IEntry<K, V> removed = tree.remove(next);
			return removed.value();
		} else if(tree.isExternal(position)) {
			throw new RuntimeException("cannot remove an external.");
		} else {
			IEntry<K, V> removed = tree.remove(position);
			return removed.value();
		}
	}
	
	public IIterator<K> keys() {
		return new IIterator<K>() {
			IIterator<IEntry<K, V>> iterator = entries();
			
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			public K next() {
				return iterator.next().key();
			}
		};
	}
	
	public IIterator<V> values() {
		return new IIterator<V>() {
			IIterator<IEntry<K, V>> iterator = entries();
			
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			public V next() {
				return iterator.next().value();
			}
		};
	}
	
	public IIterator<IEntry<K, V>> entries() {
		return tree.iterator();
	}
	
}
