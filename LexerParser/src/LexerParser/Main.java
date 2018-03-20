package LexerParser;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input;
		System.out.println("enter an input");
		input=in.next();
		Lexer newInput = new Lexer(input);
		// checks the method isvalid
		if(newInput.isValidInput()) 
			System.out.println("true");
		else
			System.out.println("false");
		// TODO Auto-generated method stub
	}
	

}
