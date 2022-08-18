package model;

public class BasicOperator {
	
	public static String caesarsCypher26(String cleartext, int displacement) {
		String cyphertext = "";
		
		//Minimum equivalent displacement
		displacement = displacement % 26;
		
		char cypherletter;
		char letter;
		
		//Easy case
		if(displacement == 0) {
			cyphertext = cleartext;
		}else{
			
			//Turn positive displacement
			if(displacement < 0) displacement += 26;
			
			//Displace every letter unless 'spaces'
			for(int i=0; i<cleartext.length(); i++) {
				letter = cleartext.charAt(i);
				if(letter != 32) {
					cypherletter = (char) ((letter - 65 + displacement)%26 + 65) ;
				}else {
					cypherletter = ' ';
				}
				cyphertext += cypherletter;
			}
		}
		return cyphertext;
	}

	public static String caesarsCypher222(String cleartext, int displacement) {
		String cyphertext = "";
		
		//Minimum equivalent displacement
		displacement = displacement % 222;
		
		char cypherletter;
		char letter;
		
		//Easy case
		if(displacement == 0) {
			cyphertext = cleartext;
		}else{
			
			//Turn positive displacement
			if(displacement < 0) displacement += 222;
			
			//Displace every letter unless 'spaces'
			for(int i=0; i<cleartext.length(); i++) {
				letter = cleartext.charAt(i);
				if(letter != 32) {
					cypherletter = (char) ((letter - 33 + displacement)%222 + 33) ;
				}else {
					cypherletter = ' ';
				}
				cyphertext += cypherletter;
			}
		}
		return cyphertext;
	}

	public static Alphabet createAlphabet(String name, String lettersPairs) {
		String[] arrayOfLetters = lettersPairs.split(" ");
		Alphabet alphabet = new Alphabet(arrayOfLetters.length, name);
		
		char origin;
		char foreign;
		for(int i=0; i<arrayOfLetters.length; i++) {
			origin = arrayOfLetters[i].charAt(0);
			foreign = arrayOfLetters[i].charAt(1);
			alphabet.addWord(origin, foreign);
		}
		
		return alphabet;
	}
	
	public static String monoalphabeticCypher(Alphabet alphabet, String cleartext) {
		String cyphertext="";
		for(int i=0; i<cleartext.length(); i++) {
			cyphertext+= alphabet.cipher(cleartext.charAt(i));
		}	
		return cyphertext;
	}
	
	public static String monoalphabeticDecypher(Alphabet alphabet, String cyphertext) {
		String cleartext="";
		for(int i=0; i<cyphertext.length(); i++) {
			cleartext+= alphabet.cipher(cyphertext.charAt(i));
		}	
		return cleartext;
	}
	

	public static String vigenereCypher(String cleartext, String key) {
		String cyphertext = "";
		
		char letter;
		int counter = 0;
		for(int i=0; i<cleartext.length(); i++) {
			letter = cleartext.charAt(i);
			if(letter != 32) {
				cyphertext += (char) ( ((letter - 65) + (key.charAt(counter) - 65))%26 + 65); 
				counter = (counter+1)%key.length();
			}else {
				cyphertext+=" ";
			}
		}
		
		return cyphertext;
	}
	
	public static String vigenereDecypher(String cyphertext, String key) {
		String cleartext = "";
		
		char cypherletter;
		char letter;
		int counter = 0;
		for(int i=0; i<cyphertext.length(); i++) {
			cypherletter = cyphertext.charAt(i);
			if(cypherletter != 32) {
				letter = (char) ((cypherletter - 65) - (key.charAt(counter) - 65)); 
				if(letter < 0)
					letter = (char) (letter + 26 + 65);
				else
					letter = (char) (letter + 65);
				
				cleartext += letter;
				
				counter = (counter+1)%key.length();
			}else {
				cleartext+=" ";
			}
		}
		
		return cleartext;
	}
}
