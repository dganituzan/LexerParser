package LexerParser;

import java.util.ArrayList;
import java.util.List;


public class Lexer {
	
	static int i=0;
	private String input;
	private List<Character> allTokens;

	/**the constructor. 
	 * getting the new string and initiate the tokens array.
	 * @param newInput
	 */

	public Lexer(String newInput) {
		this.input = newInput;
		this.allTokens = new ArrayList<Character>();
		for(int i=0; i<this.input.length();i++) {
			allTokens.add(this.input.charAt(i));
			//System.out.println(allTokens);
		}	
	}

	/**checks if the input is valid
	 */
	public boolean isValidInput() {
		boolean valid = true;

		/** first of all, 
		 * checking if the first token is`nt a operator
		 */

		switch(allTokens.get(0)) {
		case '*': valid= false;break;
		case ';': valid= false;break;
		case ')': valid= false;break;
		case '=': valid= false;break;
		case '+': valid= false;break;
		case '/': valid= false;break;
		default: valid= true;break;
		}

		/**if its a single character, return true/false
		 *  according to the switch above(valid).
		 */

		if (allTokens.size()==1) {
			return valid;
		}

		/** check all the options of allowed token
		 */
		for(int i=0; i<allTokens.size();i++) {
			if(!(allowedChar(allTokens.get(i)))){
				valid = false;
			}
		}
		/**
		//
		// TODO : make more checkers
		 */
		return valid;
	}

	/* if the token is a letter
	 * 
	 */
	public static boolean isCharToken(char token) {
		if(token>='a'&& token<='z')
			return true;
		return false;
	}
	/* if the token is an int
	 * 
	 */
	public static boolean isDigitToken(char token) {
		if(token>='0'&&token<='9')
			return true;
		return false;
	}
	/*if the token is an operator
	 * *
	 */
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
	/* checks if the token is allowed token - 
	 * according the rules.
	 */
	public static boolean allowedChar(char token) {
		boolean allowed=true;
		if(!(isOperatorToken(token)) && !(isDigitToken(token))&& !(isCharToken(token))) {
			if(token != ')' && token != '(' && token !=';') {
				allowed=false;
			}
		}
		return allowed;
	}
	public char getToken() {
		char token;
		token= allTokens.get(i);
		if(allTokens.size()>=1)   
			i++;
		else 
			System.out.println("this is the last token");
		return token;
	}
	public char getCurrentToken() {
		return allTokens.get(i);
	}

}
