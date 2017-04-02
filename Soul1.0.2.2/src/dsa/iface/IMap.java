package dsa.iface;

public interface IMap<K, V> {
	public int size();
	public boolean isEmpty();
	public V get(K k);
	public V put(K k, V v);
	public V remove(K k);
	public IIterator<K> keys();
	public IIterator<V> values();
	public IIterator<IEntry<K, V>> entries();
}
