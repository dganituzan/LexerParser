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
		System.out.println("Hello");
		
		do {
			// Instructions
			try{
				System.out.println("Enter an input, last char `;`. press 'End' to Exit");
				input = in.nextLine();
				if (input.equals("END")) isDone = true;
				// As long as we ain't getting END as an input
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
						System.out.println("Your input is Valid");
						System.out.println("Token divide");
						newInput.printList();
						System.out.println(parser.getResult());
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
					}
				}
			}
				// Catch exceptions from Lexer 
				catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Insert new command, 'END' to exit");
				}
			if(parser.isResult){
				System.out.println(parser.getResult());
			}
			Lexer.i = 0;
			}while (!isDone);
			// Closing the scanner
			in.close(); 
			System.out.println("Exiting... Goodbye!");
		}
	}



/*
 * 
 * else
 * token= newInput.getToken();
 * System.out.println(token);
 * String new1 = parser.Integer(token);
 * System.out.println(new1);
 */



