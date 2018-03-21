package LexerParser;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input;
		char token;
		System.out.println("enter an input");
		input=in.next();
		Lexer newInput = new Lexer(input);
		// checks the method isvalid
		if(newInput.isValidInput()) 
			System.out.println("true");
		else
			System.out.println("false");
		token= newInput.getToken();
		System.out.println(token);
		System.out.println(newInput.getToken());
		// TODO Auto-generated method stub
	}


}
