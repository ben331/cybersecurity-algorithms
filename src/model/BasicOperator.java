package model;

public class BasicOperator {
	
	public static String CaesarsCypher57(String cleartext, int displacement) {
		String cyphertext = "";
		
		//Minimum equivalent displacement
		displacement = displacement % 57;
		
		char cypherletter;
		char letter;
		
		//Easy case
		if(displacement == 0) {
			cyphertext = cleartext;
		}else{
			
			//Turn positive displacement
			if(displacement < 0) displacement += 57;
			
			//Displace every letter unless 'spaces'
			for(int i=0; i<cleartext.length(); i++) {
				letter = cleartext.charAt(i);
				if(letter != 32) {
					cypherletter = (char) ((letter - 65 + displacement)%57 + 65) ;
				}else {
					cypherletter = ' ';
				}
				cyphertext += cypherletter;
			}
		}
		return cyphertext;
	}

	public static String CaesarsCypher222(String cleartext, int displacement) {
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
}
