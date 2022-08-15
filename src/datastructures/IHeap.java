package datastructures;

public interface IHeap<K extends Comparable<K>,V> {
	
	public void heapify(int i);
	public void increaseKey(int i, Tuple<K,V> element);
	public void insert(K key, V value) throws IndexOutOfBoundsException;
	public V extractMax();
}