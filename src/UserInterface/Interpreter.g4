grammar Interpreter;

start:
    expression EOF;

number:
	|	DIGIT
	|	DIGIT number;

variable:
	|	LOWERCASE
	|	UPPERCASE;

factor:
	|	variable
	|	number
	|	OBRACKET expression CBRACKET;

exponent:
	|	factor
	|	exponent POWER OBRACKET expression CBRACKET
	|	SIN OBRACKET expression CBRACKET
	|	COS OBRACKET expression CBRACKET
	|	TAN OBRACKET expression CBRACKET
	|	COT OBRACKET expression CBRACKET
	|	SEC	OBRACKET expression CBRACKET
	|	CSC	OBRACKET expression CBRACKET;

term:
	|	exponent
	|	exponent (MULTIPLY | DIVIDE) term;

expression:
	|	term
	|	term (PLUS | MINUS) expression;


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