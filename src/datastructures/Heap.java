package datastructures;

import java.util.ArrayList;

public class Heap<K extends Comparable<K>, V> implements IHeap<K,V>{
	
	private Tuple<? extends Comparable<?>,?>[] array;
	
	private int size;

	public Heap(int maxLength) {
		size =0; 
		array = new Tuple<?,?>[maxLength];
	}
	
	public int getLength() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public Tuple<? extends Comparable<?>, ?>[] getArray() {
		return array;
	}

	@SuppressWarnings("unchecked")
	public void heapify(int i) {
		int largest = i;
		K keyLargest = (K) array[i].getKey();
		Tuple<K,V> aux;
		int l = i*2;
		int r = l+1;
		
		if(l<size) {
			K keyLeft=(K) array[l].getKey();
			if(keyLeft.compareTo(keyLargest)>0) {
				largest=l;
				keyLargest=keyLeft;
			}
		}if(r<size) {
			K keyRight=(K) array[r].getKey();
			if(keyRight.compareTo(keyLargest)>0) {
				largest=r;
			}
		}if(largest!=i) {
			aux = (Tuple<K, V>) array[largest];
			array[largest]=array[i];
			array[i]=aux;
			
			heapify(largest);
		}	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void increaseKey(int i, Tuple<K, V> element) {
		if(size>0) {
			Tuple<K,V> aux;
			int indexFather =(int) Math.floor(i/2);
			array[i]=element;
			K keyFather = (K) array[indexFather].getKey();
			K keyCurrent = (K) array[i].getKey();
			
			while(i>0 && keyFather.compareTo(keyCurrent)>0) {
				aux = (Tuple<K, V>) array[indexFather];  //Exchange
				array[indexFather]=array[i];
				array[i]=aux;
				
				i=indexFather;	//increase counter and variables
				indexFather = (int) Math.floor(i/2);
				keyFather = (K) array[indexFather].getKey();
				keyCurrent = (K) array[i].getKey();
			}
		}else {
			array[0]=element;
		}
	}

	@Override
	public void insert(K key, V value) throws IndexOutOfBoundsException{
		if(array.length>size) {
			increaseKey(size, new Tuple<K,V>(key, value));
			size++;
		}else {
			throw new IndexOutOfBoundsException("Heap is full");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public V extractMax() {
		if(size==0) {
			throw new IndexOutOfBoundsException("Heap is empty");
		}else {
			V max = (V) array[0].getValue();
			array[0]= array[size -1];
			size--;
			heapify(0);
			return max;
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<V> toArrayList(){
		ArrayList<V> list = new ArrayList<>();
		for(int i=0; i<size; i++) {
			list.add((V) array[i].getValue());
		}
		return list;
	}
}