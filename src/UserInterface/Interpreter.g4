grammar Interpreter;

start:
    expression EOF;

number:
	|	DIGIT
	|	DIGIT number;

variable:
	|	LOWERCASE
	|	UPPERCASE;

expression:
	|	variable
	|	number
	|	OBRACKET expression CBRACKET
	|	SIN OBRACKET expression CBRACKET
	|	COS OBRACKET expression CBRACKET
	|	TAN OBRACKET expression CBRACKET
	|	COT OBRACKET expression CBRACKET
	|	SEC	OBRACKET expression CBRACKET
	|	CSC	OBRACKET expression CBRACKET
	|	expression POWER OBRACKET expression CBRACKET
	|	expression (MULTIPLY | DIVIDE) expression
	|	expression (PLUS | MINUS) expression;


DIGIT		:	'0'..'9';
LOWERCASE	:	'a'..'z';
UPPERCASE	:	'A'..'Z';

PLUS		:	'+';
MINUS		:	'-';
MULTIPLY	:	'*';
DIVIDE		:	'/';
POWER		:	'^';

OBRACKET	:	'(';
CBRACKET	:	')';

SIN			:	'sin';
COS			:	'cos';
TAN			:	'tan';
COT			:	'cot';
SEC			:	'sec';
CSC			:	'csc';