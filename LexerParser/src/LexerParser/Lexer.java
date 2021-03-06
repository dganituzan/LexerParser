package LexerParser;

import java.util.LinkedList;
import java.util.List;


public class Lexer {

	static int i=0;
	private String input;
	protected List<String> allTokens;

	/**the constructor. 
	 * getting the new string and initiate the tokens array.
	 * @param newInput
	 */

	public Lexer(String newInput) {
		this.input = newInput;
		this.allTokens = new LinkedList<String>();
		for(int j=0,k=0; j<this.input.length();j++,k++) {

			allTokens.add(Character.toString(this.input.charAt(j)));
			//checking integer
			if(allTokens.get(k).charAt(0) >='0'&& allTokens.get(k).charAt(0)<='9'){
				String sub= input.substring(j);
				allTokens.set(k,Integer(sub)) ;
				j=j+index-1;
				
			}
		}	
	}
	/*Prints Token list 
	 * [token value token type | token value token type]
	 * for -> b; -> prints:
	 * [b IDENTIFIER | ; END_OF_LINE]
	 */
	public void printList() {
		System.out.print("[");
		for(int i = 0; i < allTokens.size(); i++) {
			if (i==allTokens.size()-1) System.out.print(allTokens.get(i));
			else System.out.print(allTokens.get(i) + " | ");
		}
		System.out.println("]");
	}

	/**checks if the input is valid
	 */
	public boolean isValidInput() {
		boolean valid = true;

		/** first of all, 
		 * checking if the first token is`nt a operator
		 */

		switch(allTokens.get(0).charAt(0)) {
		case '*': valid= false;break;
		case ';': valid= false;break;
		case ')': valid= false;break;
		case '=': valid= false;break;
		case '+': valid= false;break;
		case '/': valid= false;break;
		default: valid= true;break;
		}
		/**if the token ";" isnt the last token
		 * the input is not correct input
		 */
		if(!(Character.toString(allTokens.get(allTokens.size()-1).charAt(0)).equals(";"))){
			valid=false;
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
			if(!(allowedChar(allTokens.get(i).charAt(0)))){
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
			return true;
		default:
			return false;
		}
	}
	/*
	 *  if the token is an ';' - end of the line.
	 */
	public static boolean isEndLine(char token)
	{
		if (token == ';')
			return true;
		return false;
	}
	public static boolean isBracket(char token)
	{
		if(token == '(' || token == ')')
			return true;
		return false;
	}
	/* checks if the token is allowed token - 
	 * according the rules.
	 */
	public static boolean allowedChar(char token) {
		boolean allowed=true;
		if(!(isOperatorToken(token)) && !(isDigitToken(token))&& !(isCharToken(token))) {
			if(token != ')' && token != '(' && token !=';' && '='!= token) {
				allowed=false;
			}
		}
		return allowed;
	}
	// gets the next token 
	public String getToken() {
		String token;
		if(allTokens.size()>=1)   
			i++;
		else 
			System.out.println("this is the last token");
		token = allTokens.get(i);
		return token;
	}
	//gets the current token
	public String getCurrentToken() {
		return allTokens.get(i);
	}
	/*
	 * checking if there are more tokens
	 */
	public boolean lookingToken()
	{
		int temp = Lexer.i + 1;
		if (temp>this.allTokens.size()-1) return false;
		else return true;  
	}
// check integer token - (more than one digit)
	static int index=0;
	public String Integer(String str){
		String intToken = "";
		for(int j =0; j<str.length();j++){
			if(isDigitToken(str.charAt(j))){
				intToken +=str.charAt(j);
			}
			else{
				index = j;
				j=str.length();
			}			
		}
		return intToken;
	}



}
