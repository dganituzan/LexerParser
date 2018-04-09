package LexerParser;

public class Parser {

	private Lexer lexer;
	private int variable[];
	private String token;
	private int result;
	public boolean isResult;
	String tav="";
	public Parser(){
		this.variable = new int [26];
		this.isResult = true;	
	}
	public void line(Lexer line) {
		this.lexer= line;
		this.token=lexer.getCurrentToken();
		this.result = 0;
		while(token.charAt(0)!= ';') {
			/*
			 *  If its an Integer at the beginning, 
			 *  then its a calculation
			 */
			if(Lexer.isDigitToken(token.charAt(0))) {
				this.result = expression();
			}
			// Else its possibly an Assign command 
			else if (Lexer.isCharToken(token.charAt(0))) {
				tav = token;
				this.token=lexer.getToken();
				// If its an assign command then 
				if (token.equals("=")) {
					this.isResult = false;
					this.token=lexer.getToken();
					if (Lexer.isDigitToken(token.charAt(0))){
						int temp =  expression();
						this.variable[tav.charAt(0)-'a'] = temp;
						this.result=temp;
					}
					// Handle a=) situation 
					else if (token.equals(')')) {
						throw new IllegalArgumentException ("Close Bracket cannot be after '=' !");
					}
					
				}
				// Else it is a calculation command
				//				else if(Lexer.isOperatorToken(token.charAt(0))){
				//					if (Lexer.isDigitToken(token.charAt(0)) && (Lexer.isOperatorToken(lexer.allTokens.get(Lexer.i)))) {
				//						int a = Integer.parseInt(lexer.getCurrentToken());
				//						this.result = this.variable[tav.charAt(0)-'a'];
				//						this.isResult = true;
				//						this.token=lexer.getToken();
				//					}
				//					else if(token.equals("(") || token.equals(")")){
				//						token= lexer.getToken();
				//					}
				//
				//				}

				// If its an opernad, then we need some calculation.
				else if (Lexer.isOperatorToken(token.charAt(0))) {
					this.isResult = true;
					this.result=this.variable[tav.charAt(0)-'a'];
					char ch= token.charAt(0);
					this.token=lexer.getToken();
					System.out.println(token);
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
				//				else if (token.equals("(")) {
				//					this.token=lexer.getToken();
				//				}
				//				else if (token.equals(")")) {
				//					this.token=lexer.getToken();
				//				}
				else if (Lexer.isEndLine(token.charAt(0))) {
					this.isResult = true;
					this.result = this.variable[tav.charAt(0)-'a'];
					//if (lexer.lookingToken()) throw new IllegalArgumentException("Not allowed char after ';' ! ");
					//else break;	
				}
			}
			else if (token.equals("(")) {
				this.token=lexer.getToken();
			}
			else if (token.equals(")")) {
				this.token=lexer.getToken();
			}
			else if (Lexer.isOperatorToken(token.charAt(0))){
				switch (token.charAt(0)) {
				case '+': 
					this.result += expression();
					break;

				case '-': 
					this.result += expression();
					break;

				case '*': 
					this.result = expression();
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
			if(!isResult)
				this.variable[tav.charAt(0)-'a'] = this.result;

		}
	}

	/* Expression starts a recursive calculation
	 * Addition and Subtraction actions begin excute here
	 * @return val (int) 
	 */
	public int expression() {
		int value = term();
		System.out.println(token);
		if(token.equals("+")||token.equals("-")) 
			if(token.equals("+"))
			{
				token = lexer.getToken();
				value +=term();
			}
			else if(token.equals("-"))
			{
				token = lexer.getToken();
				value -=term();
			}
		return value;
	}
	/* Term continue the recursive calculation
	 * Multiplication and Division actions excute here if needed
	 * @return val (int)
	 */
	public int term() {
		int value = factor();
		System.out.println(token);
		if(token.equals("*")||token.equals("/")) {
			if(token.equals("*"))
			{
				token = lexer.getToken();
				if(this.result !=0)
					value = this.result*factor();
				else value = value*factor();
			}
			else if(token.equals("/"))
			{
				token = lexer.getToken();
				value = value/factor();
			}
		}
		return value;
	}
	public int factor() {
		int val = 0;
		System.out.println(token);
		if (Lexer.isDigitToken(token.charAt(0))|| (Lexer.isCharToken(token.charAt(0)))) {
			if (Lexer.isDigitToken(token.charAt(0))) {
				val = Integer.parseInt(token);
			}
			else {
				val = this.variable[token.charAt(0)-'a'];
			}
			token = lexer.getToken();
		}
		else if (token.equals("-")) {
			token = lexer.getToken();
			if (Lexer.isEndLine(token.charAt(0))) { 				// check if after - come ;
				throw new IllegalArgumentException("Token ';' canno't come after -!");
			}
			else if (Lexer.isDigitToken(token.charAt(0))) {
				val -= Integer.parseInt(token);
				token = lexer.getToken();
			}
		}
		else if (Lexer.isBracket(token.charAt(0))){
			if (token.equals("(")) {
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
