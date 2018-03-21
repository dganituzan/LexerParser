package LexerParser;
import java.util.List;

public class Parser {

	private Lexer lexer;
	private String variable[];
	private String token;
	private boolean valid;

	public Parser(String line){
		lexer= new Lexer(line);
		int k = 0;
		char letter;
		variable = new String[26];
		for(int i = 0; i < 26; i++){
			letter = (char)(97 + (k++));
			variable[i]= letter+"="+"0";
		}
	}
	public String Integer(char nextToken) {
		if(!(Lexer.isDigitToken(lexer.getCurrentToken())))
			return nextToken+"";
		return nextToken+Integer(lexer.getToken());
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

