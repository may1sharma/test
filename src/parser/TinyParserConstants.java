/* Generated By:JavaCC: Do not edit this line. TinyParserConstants.java */
package parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface TinyParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int CREATE = 7;
  /** RegularExpression Id. */
  int DROP = 8;
  /** RegularExpression Id. */
  int SELECT = 9;
  /** RegularExpression Id. */
  int INSERT = 10;
  /** RegularExpression Id. */
  int DELETE = 11;
  /** RegularExpression Id. */
  int DISTINCT = 12;
  /** RegularExpression Id. */
  int VALUES = 13;
  /** RegularExpression Id. */
  int FROM = 14;
  /** RegularExpression Id. */
  int WHERE = 15;
  /** RegularExpression Id. */
  int ORDERBY = 16;
  /** RegularExpression Id. */
  int NULL = 17;
  /** RegularExpression Id. */
  int DATATYPE = 18;
  /** RegularExpression Id. */
  int DIGIT = 19;
  /** RegularExpression Id. */
  int LETTER = 20;
  /** RegularExpression Id. */
  int NUMERAL = 21;
  /** RegularExpression Id. */
  int LPAREN = 22;
  /** RegularExpression Id. */
  int RPAREN = 23;
  /** RegularExpression Id. */
  int LBRACE = 24;
  /** RegularExpression Id. */
  int RBRACE = 25;
  /** RegularExpression Id. */
  int LBRACKET = 26;
  /** RegularExpression Id. */
  int RBRACKET = 27;
  /** RegularExpression Id. */
  int COMMA = 28;
  /** RegularExpression Id. */
  int DOT = 29;
  /** RegularExpression Id. */
  int PLUS = 30;
  /** RegularExpression Id. */
  int MINUS = 31;
  /** RegularExpression Id. */
  int STAR = 32;
  /** RegularExpression Id. */
  int SLASH = 33;
  /** RegularExpression Id. */
  int LT = 34;
  /** RegularExpression Id. */
  int GT = 35;
  /** RegularExpression Id. */
  int EQ = 36;
  /** RegularExpression Id. */
  int COMP_OP = 37;
  /** RegularExpression Id. */
  int QUOTE = 38;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\r\\n\"",
    "\"\\\\\"",
    "\"\\t\"",
    "\" \"",
    "\"Create Table\"",
    "\"Drop Table\"",
    "\"Select\"",
    "\"Insert Into\"",
    "\"Delete From\"",
    "\"Distinct\"",
    "\"Values\"",
    "\"From\"",
    "\"Where\"",
    "\"Order By\"",
    "\"Null\"",
    "<DATATYPE>",
    "<DIGIT>",
    "<LETTER>",
    "<NUMERAL>",
    "\"(\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "\",\"",
    "\".\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"<\"",
    "\">\"",
    "\"=\"",
    "<COMP_OP>",
    "\"\\\"\"",
  };

}