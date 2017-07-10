grammar SimpleQLang;

expression : simpleExpression (logicalOp simpleExpression)* ;

logicalOp : AND | OR ;

simpleExpression : leftRightExpr
       | betweenExpr
       | isExpr
       | inExpr ;

leftRightExpr : leftElement relationalOp rightElement;

betweenExpr : columnName notOp? betweenOp leftElement betweenAnd rightElement;

isExpr : columnName isOp notOp? nullVal;

inExpr : columnName notOp? inOp '(' inElements (',' inElements)* ')';

inElements : //(columnName | '(' columnName (',' columnName)* ')')
           //|
           (constant  | '(' constant (',' constant)* ')')? ;

constant : STRING // string, datetime or uniqueidentifier
    | sign? INT
    | sign? (REAL | FLOAT)  // float or decimal
    | sign? dollar='$' (INT | FLOAT)       // money
    ;

leftElement  : element;

rightElement : element;

element : USER_VAR | ID | ( '|' ID '|' ) | constant | columnName;

schemaName : ID;

tableName : ID;

name : ID ;

betweenAnd : AND ;

nullVal : NULL;

columnName : ( ( schemaName DOT )? tableName DOT )? name
        | ( tableName DOT )? name
        | USER_VAR ;


relationalOp : EQ | LTH | GTH | NOT_EQ | LET | GET;

notOp : NOT;

isOp : IS;

betweenOp : BETWEEN;

inOp : IN ;

sign : '+' | '-';

AND : A N D | '&&';

OR  : O R | '||';

IS  : I S ;

NULL : N U L L ;

LIKE : L I K E;

BETWEEN : B E T W E E N | B W;

IN : I N ;

NOT : N O T;

INT : '0' .. '9'+;

EQ  : '=';

LTH : '<';

GTH : '>';

NOT_EQ : '!=' | '<>';

LET : '<=';

GET : '>=';

ID : ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9')+;

USER_VAR : '@' ( USER_VAR_SUBFIX1 | USER_VAR_SUBFIX2 | USER_VAR_SUBFIX3 | USER_VAR_SUBFIX4 );

DOT : '.';

STRING :  N? '\'' (~'\'' | '\'\'')* '\'';

FLOAT  :  DEC_DOT_DEC;

REAL   :  DEC_DOT_DEC (E [+-]? INT+)?;


fragment USER_VAR_SUBFIX1 : ( '`' ( ~ '`' )+ '`' );

fragment USER_VAR_SUBFIX2 : ( '\'' ( ~ '\'' )+ '\'' );

fragment USER_VAR_SUBFIX3 : ( '\"' ( ~ '\"' )+ '\"' );

fragment USER_VAR_SUBFIX4 : ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '$' | '0' .. '9' | DOT )+;

fragment DEC_DOT_DEC:  (INT+ '.' INT+ |  INT+ '.' | '.' INT+);

A : [Aa] ;
N : [Nn] ;
D : [Dd] ;

X : [Xx] ;
O : [Oo] ;
R : [Rr] ;

I : [Ii] ;
S : [Ss] ;

U : [Uu] ;
L : [Ll] ;

K : [Kk] ;
E : [Ee] ;

T : [Tt] ;

B : [Bb] ;
W : [Ww] ;

WS : [ \t\r\n]+ -> skip ;