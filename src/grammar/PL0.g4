grammar PL0;

program
    : program_header block
    ;

program_header
    : PROGRAM ident
    ;

block
    : const_stat? var_stat? statement
    ;

const_stat
    : CONST const_def (',' const_def)* ';'
    ;

const_def
    :ident ':=' number
    ;

var_stat
    : VAR ident (',' ident)* ';'
    ;

statement
    : (assignstmt | beginstmt | ifstmt | whilestmt | emptystmt )?
    ;

emptystmt : ;

assignstmt
    : ident ':=' expression
    ;

beginstmt
    : BEGIN statement (';' statement)* END
    ;

condition
    : expression RELATIONAL_OPERATOR expression
    ;

ifstmt
    : IF condition THEN statement
    ;

whilestmt
    : WHILE condition DO statement
    ;


expression
    : optionalSign term ((addOperator) term)*
    ;

optionalSign
    : ('+' | '-')?
    ;

addOperator
    : '+' | '-'
    ;

multiplyOperator
    : '*' | '/'
    ;

term
    : factor ((multiplyOperator) factor)*
    ;

factor
    : ident
    | number
    | '(' expression ')'
    ;

ident
    : STRING
    ;

number
    : NUMBER
    ;

PROGRAM
    : P R O G R A M
    ;

WHILE
    : W H I L E
    ;

DO
    : D O
    ;

IF
    : I F
    ;

THEN
    : T H E N
    ;


BEGIN
    : B E G I N
    ;

END
    : E N D
    ;

CONST
    : C O N S T
    ;

VAR
    : V A R
    ;

RELATIONAL_OPERATOR
    : '='
    | '<>'
    | '<'
    | '<='
    | '>'
    | '>='
    ;

fragment A
    : 'A'
    ;

fragment B
    : 'B'
    ;

fragment C
    : 'C'
    ;

fragment D
    : 'D'
    ;

fragment E
    : 'E'
    ;

fragment F
    : 'F'
    ;

fragment G
    : 'G'
    ;

fragment H
    : 'H'
    ;

fragment I
    : 'I'
    ;

fragment J
    : 'J'
    ;

fragment K
    : 'K'
    ;

fragment L
    : 'L'
    ;

fragment M
    : 'M'
    ;

fragment N
    : 'N'
    ;

fragment O
    : 'O'
    ;

fragment P
    : 'P'
    ;

fragment Q
    : 'Q'
    ;

fragment R
    : 'R'
    ;

fragment S
    : 'S'
    ;

fragment T
    : 'T'
    ;

fragment U
    : 'U'
    ;

fragment V
    : 'V'
    ;

fragment W
    : 'W'
    ;

fragment X
    : 'X'
    ;

fragment Y
    : 'Y'
    ;

fragment Z
    : 'Z'
    ;



NUMBER
    : [0-9]+
    ;

STRING
    : [a-z] [a-z0-9]*
    ;


WS
    : [ \t\r\n] -> skip
    ;

