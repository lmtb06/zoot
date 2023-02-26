package zoot.analyse ;

import java_cup.runtime.*;
import zoot.exceptions.AnalyseLexicaleException;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{

  private StringBuilder chaine ;

  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

csteB = vrai|faux
csteE = -?[0-9]+
idf = [a-zA-Z][a-zA-Z0-9]*
finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]

%%
"//".*                                    { /* DO NOTHING */ }

"variables"            { return symbol(CodesLexicaux.VARIABLES);}
"fonctions"            { return symbol(CodesLexicaux.FONCTIONS);}
"debut"                { return symbol(CodesLexicaux.DEBUT); }
"fin"              	   { return symbol(CodesLexicaux.FIN); }

"entier"               { return symbol(CodesLexicaux.ENTIER); }
"booleen"              { return symbol(CodesLexicaux.BOOLEEN); }

"ecrire"               { return symbol(CodesLexicaux.ECRIRE); }
"retourne"             { return symbol(CodesLexicaux.RETOURNE); }

"="                    { return symbol(CodesLexicaux.EGAL); }
";"                    { return symbol(CodesLexicaux.POINTVIRGULE); }
"("                    { return symbol(CodesLexicaux.PARENTHESEOUVERTE); }
")"                    { return symbol(CodesLexicaux.PARENTHESEFERMEE); }

{csteB}      	       { return symbol(CodesLexicaux.CSTBOOL, yytext()); }
{csteE}      	       { return symbol(CodesLexicaux.CSTENTIERE, yytext()); }
{idf}                  { return symbol(CodesLexicaux.IDF, yytext()); }

{espace}               { }
.                      { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
