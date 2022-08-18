package model;

public class WordTranslation {
	
	public char main;
	public char foreign;
	public int frequency;
	
	public WordTranslation(char main, char foreign) {
		super();
		this.main = main;
		this.foreign = foreign;
	}
	
	@Override
	public String toString() {
		return main + " - " + foreign;
	}
}
