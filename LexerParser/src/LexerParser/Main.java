package LexerParser;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input;
		String token;
		System.out.println("enter an input");
		input=in.next();
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
