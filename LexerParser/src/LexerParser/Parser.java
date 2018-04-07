package LexerParser;
import java.util.List;

public class Parser {

	private Lexer lexer;
	private int variable[];
	private String token;
	private int result;
	private boolean valid;
	private boolean isResult;

	public Parser(Lexer line){
		this.variable = new int [26];
		this.lexer= line;
		this.isResult = true;	
	}
	public void line() {
		this.token=lexer.getToken();
		this.result = 0;
		
		while(lexer.getCurrentToken() != ";") {
			// If its an Integer at the beginning, then its calculation
			if(Lexer.isDigitToken(token.charAt(0))) {
				token = Integer(lexer.getCurrentToken());			// dont have to
				this.result = expression();
			}
			// Else its possibly an Assign command 
			else if (Lexer.isCharToken(lexer.getCurrentToken().charAt(0))) {
							this.isResult = false;
							String tav = lexer.getCurrentToken();
							this.token=lexer.getToken();
							// If its an assign command then 
							if (lexer.getCurrentToken().equals("=")) {
								this.token=lexer.getToken();	
							if (Lexer.isDigitToken(token.charAt(0)) && (!Lexer.isOperatorToken(lexer.allTokens.get(Lexer.i)))) {
									int a = Integer.parseInt(lexer.getCurrentToken());
									this.variable[tav.charAt(0)-'a'] = a;
								}
								// Handle a=) situation 
								else if (lexer.getCurrentToken().equals(')')) {
									throw new IllegalArgumentException ("Close Bracket cannot be after '=' !");
								}
								else {
									int temp = expression();
									this.variable[tav.charAt(0)-'a'] = temp;
								}
							}
							// Else it is a calculation command
							else {
								this.result = this.variable[tav.charAt(0)-'a'];
								this.isResult = true;
							}
						}
			// If its an opernad, then we need some calculation.
			else if (Lexer.isOperatorToken(lexer.getCurrentToken().charAt(0))) {
				char ch= lexer.getCurrentToken().charAt(0);
				this.token=lexer.getToken();
				// Excuting the calculation according to the matching operand
				switch (ch) {
				case '+': 
					this.result += expression();
					break;

				case '-': 
					this.result -= expression();
					break;

				case '*': 
					this.result *= expression();
					break;

				case '/': 
					int val = expression();
					if (val==0) {
						throw new ArithmeticException("Cannot devide by zero!");
					}
					this.result /= val;
					break;

				default:
					throw new IllegalArgumentException("No operand after identifier!");
				}
			}
			else if (lexer.getCurrentToken().equals('(')) {
				this.token=lexer.getToken();
			}

			else if (lexer.getCurrentToken().equals(')')) {
				this.token=lexer.getToken();
			}
			if (Lexer.isEndLine(lexer.getCurrentToken().charAt(0))) {
				if (lexer.lookingToken()) throw new IllegalArgumentException("Not allowed char after ';' ! ");
				else break;	
			}

		}

	}
	public String Integer(String nextToken) {
		if(!(Lexer.isDigitToken(lexer.getCurrentToken().charAt(0))))
			return nextToken+"";
		return nextToken+Integer(lexer.getToken());
	}
	/* Expression starts a recursive calculation
	 * Addition and Subtraction actions begin excute here
	 * @return val (int) 
	 */
	public int expression() {
		int value = term();
		if(lexer.getCurrentToken().equals("+")||lexer.getCurrentToken().equals("-")) 
			if(lexer.getCurrentToken().equals("+"))
				value +=term();
			else if(lexer.getCurrentToken().equals("-"))
				value -=term();
		token = lexer.getToken();
		return value;
	}
	/* Term continue the recursive calculation
	 * Multiplication and Division actions excute here if needed
	 * @return val (int)
	 */
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
		int val = 0;
		if (Lexer.isDigitToken(lexer.getCurrentToken().charAt(0))|| (Lexer.isOperatorToken(lexer.getCurrentToken().charAt(0)))) {
			if (Lexer.isDigitToken(lexer.getCurrentToken().charAt(0))) {
				val = Integer.parseInt(lexer.getCurrentToken());
			}
			else {
				val = this.variable[lexer.getCurrentToken().charAt(0)-'a'];
			}
			token = lexer.getToken();
		}
		else if (lexer.getCurrentToken().equals("-")) {
			token = lexer.getToken();
			if (Lexer.isEndLine(lexer.getCurrentToken().charAt(0))) { 				// check if after - come ;
				throw new IllegalArgumentException("Token ';' canno't come after -!");
			}
			else if (Lexer.isDigitToken(lexer.getCurrentToken().charAt(0))) {
				val -= Integer.parseInt(lexer.getCurrentToken());
				token = lexer.getToken();
			}
		}
		else if (Lexer.isBracket(lexer.getCurrentToken().charAt(0))){
			if (lexer.getCurrentToken().equals('(')) {
				token = lexer.getToken();
				val = expression();
			}
			token = lexer.getToken();
		}
		return val;
	}
	/* getResult()
	 * @return The result
	 */
	public int getResult() {
		return this.result;
	}
	
	/* setisResult()
	 * If it is calculation, setting the value to true
	 */
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
