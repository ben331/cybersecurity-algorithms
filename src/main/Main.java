package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Alphabet;
import model.BasicOperator;

public class Main {

	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		ArrayList<Alphabet> alphabets = new ArrayList<>();
		
		System.out.println("Welcome to mrrobot\n");
		
		int option = 0;
		do {
			System.out.println("Select option:"
					+ "\n -1. Exit"
					+ "\n 1. Caesars cypher 57"
					+ "\n 2. Caesars cypher 222"
					+ "\n 3. Create an alphabet"
					+ "\n 4. Cypher monoalphabetic"
					+ "\n 5. Decypher monoalphabetic"
					+ "\n 6. Show alphabets");
			
			option = r.nextInt();
			r.nextLine();
			
			switch(option) {
			case 1:
				System.out.println("\nWrite message:");
				String cleartext = r.nextLine();
				
				System.out.println("\nType displacement (number between 1-56)");
				int displacement = r.nextInt();
				r.nextLine();
				
				System.out.println("\nCyphertext: \n"+BasicOperator.caesarsCypher57(cleartext, displacement));
				break;
			case 2:
				System.out.println("\nWrite message:");
				cleartext = r.nextLine();
				
				System.out.println("\nType displacement (number between 1-221)");
				displacement = r.nextInt();
				r.nextLine();
				
				System.out.println("\nCyphertext: \n"+BasicOperator.caesarsCypher222(cleartext, displacement));
				break;
			case 3:
				System.out.println("\nType alphabet name:");
				String name = r.nextLine();
				System.out.println("\nType pairs of word translation. Ex: qe rd h5 w2 1q zñ 3w");
				String alphabet = r.nextLine();
				alphabets.add(BasicOperator.createAlphabet(name, alphabet));
				System.out.println("Alphabet "+name+" added successfully");
				break;
			case 4:
				System.out.println("\nWrite message:");
				cleartext = r.nextLine();
				
				System.out.println("\nSelect alphabet:");
				
				for(int i=0; i<alphabets.size();i++) {
					System.out.println("\n"+ (i+1) + ". "+ alphabets.get(i).getName());
				}
				
				int option2 = r.nextInt();
				r.nextLine();
				
				System.out.println("\nCyphertext: \n"+BasicOperator.monoalphabeticCypher(alphabets.get(option2-1), cleartext));
				break;
			case 5:
				System.out.println("\nWrite message:");
				String cyphertext = r.nextLine();
				
				System.out.println("\nSelect alphabet:");
				
				for(int i=0; i<alphabets.size();i++) {
					System.out.println("\n"+ (i+1) + ". "+ alphabets.get(i).getName());
				}
				
				option2 = r.nextInt();
				r.nextLine();
				
				System.out.println("\nCyphertext: \n"+BasicOperator.monoalphabeticDecypher(alphabets.get(option2-1), cyphertext));
				break;
			case 6:
				
				break;
			default:
				System.out.println("Invalid option");
			}
			
			System.out.println("\n\n-------------------------------------------\n\n");
		}while(option!=-1);
		
		r.close();
	}
}
