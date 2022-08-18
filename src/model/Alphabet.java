package model;

import datastructures.Heap;
import datastructures.Tuple;

public class Alphabet {
	
	private int size;
	private String name;

	private Heap<Float,WordTranslation> heap;
	
	public Alphabet(int size, String name) {
		this.size = size;
		this.name = name;
		
		heap = new Heap<>(size);
	}
	
	public void addWord(char origin, char foreign) {
		
		if(heap.getLength() < size) {
			WordTranslation word = new WordTranslation(origin, foreign);
			heap.insert(0f, word);
		}else {
			System.out.println("Full heap");
		}
	}
	
	public char cipher(char origin) {
		
		if(origin == ' ')
			return ' ';
		else {
			@SuppressWarnings("unchecked")
			Tuple<Float, WordTranslation>[] array = (Tuple<Float, WordTranslation>[]) heap.getArray();
			
			for(int i=0; i<array.length; i++) {
				WordTranslation word = array[i].getValue();
				if(word.main == origin) {
					word.frequency++;
					heap.heapify(0);
					return word.foreign; 
				}
			}
			return 42;
		}
	}
	
	public char decipher(char foreign) {
		
		if(foreign == ' ')
			return ' ';
		else {
			@SuppressWarnings("unchecked")
			Tuple<Float, WordTranslation>[] array = (Tuple<Float, WordTranslation>[]) heap.getArray();
			
			for(int i=0; i<array.length; i++) {
				WordTranslation word = array[i].getValue();
				if(word.foreign == foreign) {
					return word.main; 
				}
			}
			return 42;
		}
	}
	
	@SuppressWarnings("unchecked")
	public String getWords() {
		String words = "";
		Tuple<Float, WordTranslation>[] array = (Tuple<Float, WordTranslation>[]) heap.getArray();
		
		for(int i=0; i<array.length; i++) {
			words += array[i].getValue().toString()+"\n";
		}
		return words;
	}
	

	public int getSize() {
		return size;
	}

	public String getName() {
		return name;
	}
}
