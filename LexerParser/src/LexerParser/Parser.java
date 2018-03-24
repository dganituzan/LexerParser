package LexerParser;
import java.util.List;

public class Parser {

	private Lexer lexer;
	private String variable[]=new String[26];;
	private String token;
	private int result;
	private boolean valid;

	public Parser(Lexer line){
		lexer= line;
	}
	public void line() {
		token=lexer.getToken();
		
		while(lexer.getCurrentToken() != ";") {
			if(lexer.isDigitToken(token.charAt(0))) {
				token = Integer(lexer.getCurrentToken());
				this.result = expression();
			}
			
		}
		
	}
	public String Integer(String nextToken) {
		if(!(Lexer.isDigitToken(lexer.getCurrentToken().charAt(0))))
			return nextToken+"";
		return nextToken+Integer(lexer.getToken());
	}
	public int expression() {
		int value = term();
		if(lexer.getCurrentToken().equals("+")||lexer.getCurrentToken().equals("-")) {
			if(lexer.getCurrentToken().equals("+"))
				value = value+term();
			else if(lexer.getCurrentToken().equals("-"))
				value = value-term();
		}
		token = lexer.getToken();
		return value;
	}
	public int term() {
		int value = factor();
		if(lexer.getCurrentToken().equals("*")||lexer.getCurrentToken().equals("/")) {
			if(lexer.getCurrentToken().equals("*"))
				value = value*factor();
			else if(lexer.getCurrentToken().equals("/"))
				value = value/factor();
		}
		token = lexer.getToken();
		return value;
	}
	public int factor() {
		
	}
	
	/**
	public String isDigit(char token) {
		System.out.println("test");
		if(lexer.getCurrentToken() <='0'&&lexer.getCurrentToken()>='9') 
			return null; 
		System.out.println(isDigit(lexer.getToken())+lexer.getCurrentToken());
		return isDigit(lexer.getToken())+lexer.getCurrentToken();
			}
	



*/
}

