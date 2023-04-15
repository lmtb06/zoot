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
csteE = [0-9]+
type = entier|booleen
idf = [a-zA-Z][a-zA-Z0-9]*
finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]
plus = \+
fois = \*


%%
"//".*                                    { /* DO NOTHING */ }

"variables"            { return symbol(CodesLexicaux.VARIABLES);}
"fonctions"            { return symbol(CodesLexicaux.FONCTIONS);}
"debut"                { return symbol(CodesLexicaux.DEBUT); }
"fin"              	   { return symbol(CodesLexicaux.FIN); }

"ecrire"               { return symbol(CodesLexicaux.ECRIRE); }
"retourne"             { return symbol(CodesLexicaux.RETOURNE); }
"repeter"              { return symbol(CodesLexicaux.REPETER); }
"jusqua"               { return symbol(CodesLexicaux.JUSQUA); }
"finrepeter"           { return symbol(CodesLexicaux.FINREPETER); }
"si"                   { return symbol(CodesLexicaux.SI); }
"alors"                { return symbol(CodesLexicaux.ALORS); }
"sinon"                { return symbol(CodesLexicaux.SINON); }
"finsi"                { return symbol(CodesLexicaux.FINSI); }

"="                    { return symbol(CodesLexicaux.EGAL); }
";"                    { return symbol(CodesLexicaux.POINTVIRGULE); }
"("                    { return symbol(CodesLexicaux.PARENTHESEOUVERTE); }
")"                    { return symbol(CodesLexicaux.PARENTHESEFERMEE); }
","                    { return symbol(CodesLexicaux.VIRGULE); }
"non"                  { return symbol(CodesLexicaux.NON); }
"-"                    { return symbol(CodesLexicaux.MOINS); }
{plus}                 { return symbol(CodesLexicaux.PLUS); }
{fois}                 { return symbol(CodesLexicaux.FOIS); }
"<"                    { return symbol(CodesLexicaux.INFERIEURA); }
"=="                   { return symbol(CodesLexicaux.EQUIVAUTA); }
"!="                   { return symbol(CodesLexicaux.DIFFERENTDE); }
"et"                   { return symbol(CodesLexicaux.ET); }
"ou"                   { return symbol(CodesLexicaux.OU); }

{csteB}      	       { return symbol(CodesLexicaux.CSTBOOL, yytext()); }
{csteE}      	       { return symbol(CodesLexicaux.CSTENTIERE, yytext()); }
{type}                 { return symbol(CodesLexicaux.TYPE, yytext()); }
{idf}                  { return symbol(CodesLexicaux.IDF, yytext()); }

{espace}               { }
.                      { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
