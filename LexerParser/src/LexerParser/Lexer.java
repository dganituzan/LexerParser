package LexerParser;

import java.util.ArrayList;
import java.util.List;



public class Lexer {
	
	private String input;
	private List<Character> allTokens;
	  
	//the constructor. getting the new string and initiate the tokens array.
	
	public Lexer(String newInput) {
		this.input = newInput;
		allTokens = new ArrayList<Character>();
		for(int i=0; i<this.input.length();i++) {
			allTokens.add(this.input.charAt(i));
		}	
	}
	public boolean isValidInput() {
		
		// first of all , checking if the first token is`nt a operator
		
		boolean valid = false;
		switch(allTokens.get(0)) {
		case '*': valid= false;
		case ';': valid= false;
		case ')': valid= false;
		case '(': valid= false;
		case '=': valid= false;
		case '+': valid= false;
		case '-': valid= false;
		case '/': valid= false;
		default: valid= true;
		}
		
		//if its a single character, return true/false according to the switch above(valid).
		
		if (allTokens.size()==1) {
			return valid;
		}
		//
		//
		// TODO : make more checkers
		//
		return valid;
	}
	public static boolean isCharToken(char token) {
		if(token>='a'&& token<='z')
			return true;
		return false;
	}
	public static boolean isIntToken(char token) {
		if(token>='0'&&token<='9')
			return true;
		return false;
	}
	public static boolean isOperatorToken(char token) {
		switch(token) {
		case '*': 
		case '+': 
		case '-': 
		case '/': 
		case '=':
			return true;
		default:
			return false;
		}
	}
	
	
	

}
