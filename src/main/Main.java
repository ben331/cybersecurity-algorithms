package main;

import java.util.Scanner;
import model.BasicOperator;

public class Main {

	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		
		System.out.println("Welcome to mrrobot\n");
		
		int option = 0;
		do {
			System.out.println("Select option:"
					+ "\n -1. Exit"
					+ "\n 1. Caesars cypher 57"
					+ "\n 2. Caesars cypher 222");
			
			option = r.nextInt();
			r.nextLine();
			
			switch(option) {
			case 1:
				System.out.println("\nWrite message:");
				String cleartext = r.nextLine();
				
				System.out.println("\nType displacement (number between 1-56)");
				int displacement = r.nextInt();
				r.nextLine();
				
				System.out.println("\nCyphertext: \n"+BasicOperator.CaesarsCypher57(cleartext, displacement));
				break;
			case 2:
				System.out.println("\nWrite message:");
				cleartext = r.nextLine();
				
				System.out.println("\nType displacement (number between 1-221)");
				displacement = r.nextInt();
				r.nextLine();
				
				System.out.println("\nCyphertext: \n"+BasicOperator.CaesarsCypher222(cleartext, displacement));
				break;
			default:
				System.out.println("Invalid option");
			}
			
			System.out.println("\n\n-------------------------------------------\n\n");
		}while(option!=-1);
		
		r.close();
	}
}
