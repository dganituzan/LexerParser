 #LexerParser. 

*** Asigment 1: Lexer Parser ***

*** Developers Information: ***

Name: Dganit Uzan. ID: 206067563. Email: dganit230395@gmail.com

Name: Idan Koper. ID: 204391130. Email: idankoper@gmail.com

Second year, Computer Science Department - Ashkelon College.

*** Assignment ***

Writing a program that will use as a calculator with a basic commands from the user input and present the right output. 

*** Goals ***

Use our new knowledge in Java programming and implement a basic calculator with a Lexer and Parser that are designed by the language

rules and uses the method of recursive descent.

The calculator can execute the following commands :

•	Instant Operation: for example '2 + 3* 4' will print '14'. or, for instance (2+3)* 4; will print 20. operators it can read: +,-,* ,/.

•	Store Operation: for example 'a=4;' will store '4' and 'a = 4+2;' will store '6' in variable 'a'.

•	Display Operation: for example 'a;' will print the contents of variable 'a'. also, 'b=2*(a-10) and than 'b;' will print -12.

•	';' should be the end of the command.

*** Package ***

LexerParser

*** Classes  ***

Lexer - gets a String (input user). separate into tokens and check if all the tokens are "by the rules".

Parser - this class reads the tokens the Lexer created and calculating the result of the user input by the functions:

line: "uniting" all the tokens and gets a result.

expression: dealing with '+', '-' operators.

term: dealing with '* ','/' operators.

factor: return the value of a token. identifier , Integer, -factor and bracket expressions.

Main - The class where the user put in his command. Actually, this where all the user interaction occurs.

*** Appendix *** 

Valid tokens:

Integer (any number), Identifider (a-z).

Brackets: '(' ')' .

assigns value by '='.

operators: '+' | '-' | '*' | '/' .

and at the end of line: ' ; '.

*** Running the program ***

Navigate to Start -> Run. Enter CMD in the commend line.

Set the path to your JDK bin directory, for example: "set path=C:\Program Files\Java\jdk1.8.0_161\bin".

At the run window enter the project source folder likewise: "cd JavaEclipseWorkspace/hello1.

Type "java Main" and follow the instructions for start calculating.


*** Exit the program	 ***

follow the instructions:

press 'END'  for exit .	

*** Algoritems ***

None.

 *** Definitions ***
 
Lexer - https://en.wikipedia.org/wiki/Lexical_analysis

Parser- https://en.wikipedia.org/wiki/Parsing

