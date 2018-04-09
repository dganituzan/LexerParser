package LexerParser;

import java.util.*;

import java.util.Scanner;
public class Main{


	public static void main(String[] args) throws Exception
	{
		Scanner in = new Scanner(System.in);
		boolean isDone=false;
		Parser parser= new Parser();
		String input;
		String token;
		System.out.println("Hello!");
		System.out.println("Enter an input, last char `;`. press 'End' to Exit");
		do {
			// Instructions
			try{
				input = in.nextLine();
				// moves all the space from the input.
				input.replaceAll("\\s+","");
				if (input.equals("END")) isDone = true;
				/*
				 *  As long as we ain't getting END as an input
				 */
				else {
					// Initialize new Lexer
					Lexer lexer = new Lexer(input);
					// If needed
					//List <Token> list = new LinkedList<Token>();
					// Priniting the user's input
					System.out.println("Your input is: " + input); 
					// Sending the string to tokenize @ Lexer class, and assign to list
					Lexer newInput = new Lexer(input);
					// checks the method isvalid
					if(newInput.isValidInput()) {
						System.out.println("Your input is Valid, good!");
						System.out.print("Token divide: ");
						newInput.printList();
						parser.line(newInput);
						if (parser.isResult) { 
							System.out.println("Result: " + parser.getResult());
						}
						else {
							System.out.println(input + " Has been excuted!");
						}
						// Getting new input from the user
						System.out.println("To continue, Insert new command, 'END' to exit");
						parser.isResult = true;
					}
					else{
						System.out.println("your input is invalid. please try again.");
						System.out.println("To continue, Insert new command, 'END' to exit");
					}
				}
			}
			// Catch exceptions from Lexer 
			catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Insert new command, 'END' to exit");
			}
//			if(parser.isResult){
//				System.out.println(parser.getResult());
//			}
			Lexer.i = 0;
		}while (!isDone);
		// Closing the scanner
		in.close(); 
		System.out.println("Exiting... Goodbye!");
	}
}


