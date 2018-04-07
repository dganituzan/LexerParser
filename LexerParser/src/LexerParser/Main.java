package LexerParser;

import java.util.*;
import java.util.Scanner;
public class Main{


	public static void main(String[] args) throws Exception
	{
		Scanner in = new Scanner(System.in);
		boolean isDone;
		String input;
		String token;
		System.out.println("Hello");
		System.out.println("Enter an input, 'End' to Exie");
		do {
			// Instructions
			try{
				input = in
						if (input.equals("END")) isDone = true;
				// As long as we ain't getting END as an input
						else {
							// Initialize new Lexer
							Lexer lexer = new Lexer(input);
							// If needed
							List <Token> list = new LinkedList<Token>();
							// Priniting the user's input
							System.out.println("Your input is: " + input); 
							// Sending the string to tokenize @ Lexer class, and assign to list
							Lexer newInput = new Lexer(input);
							Parser parser= new Parser(newInput);
							// checks the method isvalid
							if(newInput.isValidInput()) 
								System.out.println("true");
							else
								System.out.println("false");

							token= newInput.getToken();
							System.out.println(token);
							String new1 = parser.Integer(token);
							System.out.println(new1);

							// TODO Auto-generated method stub

						}

			}
		}
	}
}
