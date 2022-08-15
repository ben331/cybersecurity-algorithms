package datastructures;

import java.io.Serializable;

public class Tuple<K extends Comparable<K>,V> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1441522304459643339L;
	private K key;
	private V value;
	
	public Tuple(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
	
	//Set Blank
	public void setDelete() {
		key = null;
		value = null;
	}
}
