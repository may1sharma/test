/* Generated By:JavaCC: Do not edit this line. TinyParser.java */
   package parser;
   import java.util.ArrayList;
   import java.util.LinkedHashMap;
   public class TinyParser implements TinyParserConstants {
         ArrayList<Statement> initParser()throws ParseException, TokenMgrError {
            return(init()) ;
         }

//SPECIAL_TOKEN : {<COMMENT:("#")+(<DIGIT>|<LETTER>|" ")*("#")+>}
  final public Token TableName() throws ParseException {
    Token T;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LETTER:
      T = jj_consume_token(LETTER);
     {if (true) return T;}
      break;
    case NUMERAL:
      T = jj_consume_token(NUMERAL);
     {if (true) return T;}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Token AttributeName() throws ParseException {
    Token T;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LETTER:
      T = jj_consume_token(LETTER);
     {if (true) return T;}
      break;
    case NUMERAL:
      T = jj_consume_token(NUMERAL);
     {if (true) return T;}
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Token ColumnName() throws ParseException {
    Token T;
    Token S = null;
    T = TableName();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DOT:
      jj_consume_token(DOT);
      S = AttributeName();
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
        if (S!= null) {T.image = T.image + "." + S.image;}
        {if (true) return T;}
    throw new Error("Missing return statement in function");
  }

  final public String Literal() throws ParseException {
    Token T;
    StringBuilder sb = new StringBuilder();
    jj_consume_token(QUOTE);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIGIT:
      case LETTER:
      case LPAREN:
      case RPAREN:
      case COMMA:
      case DOT:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIGIT:
        T = jj_consume_token(DIGIT);
                  sb.append(T.image);
        break;
      case LETTER:
        T = jj_consume_token(LETTER);
                   sb.append(T.image);
        break;
      case LPAREN:
        T = jj_consume_token(LPAREN);
                   sb.append(T.image);
        break;
      case RPAREN:
        T = jj_consume_token(RPAREN);
                   sb.append(T.image);
        break;
      case COMMA:
        T = jj_consume_token(COMMA);
                  sb.append(T.image);
        break;
      case DOT:
        T = jj_consume_token(DOT);
                sb.append(T.image);
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(QUOTE);
     {if (true) return sb.toString();}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<Statement> init() throws ParseException {
    ArrayList<Statement> stmtList = new ArrayList<Statement>();
    Statement stmt;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CREATE:
      case DROP:
      case SELECT:
      case INSERT:
      case DELETE:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CREATE:
        stmt = CreateStatement();
           stmtList.add(stmt) ;
        break;
      case DROP:
        stmt = DropStatement();
           stmtList.add(stmt) ;
        break;
      case SELECT:
        stmt = SelectStatement();
           stmtList.add(stmt) ;
        break;
      case INSERT:
        stmt = InsertStatement();
           stmtList.add(stmt) ;
        break;
      case DELETE:
        stmt = DeleteStatement();
           stmtList.add(stmt) ;
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(0);
     {if (true) return stmtList;}
    throw new Error("Missing return statement in function");
  }

  final public Statement CreateStatement() throws ParseException {
    Token T;
    Statement stmt;
    LinkedHashMap<String,String> attributes;
    jj_consume_token(CREATE);
    T = TableName();
    jj_consume_token(LPAREN);
    attributes = AttrTypeList();
    jj_consume_token(RPAREN);
        stmt = new CreateStatement(T.image, attributes);
        {if (true) return stmt;}
    throw new Error("Missing return statement in function");
  }

  final public LinkedHashMap<String,String> AttrTypeList() throws ParseException {
   Token AName;
   Token AType;
   LinkedHashMap<String,String> var = new LinkedHashMap<String, String>();
    AName = AttributeName();
    AType = jj_consume_token(DATATYPE);
        var.put(AName.image,AType.image);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LETTER:
      case NUMERAL:
      case COMMA:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        jj_consume_token(COMMA);
        break;
      default:
        jj_la1[8] = jj_gen;
        ;
      }
      AName = AttributeName();
      AType = jj_consume_token(DATATYPE);
            var.put(AName.image,AType.image);
    }
        {if (true) return var;}
    throw new Error("Missing return statement in function");
  }

  final public Statement DropStatement() throws ParseException {
    Token T;
    jj_consume_token(DROP);
    T = TableName();
        {if (true) return new DropStatement(T.image);}
    throw new Error("Missing return statement in function");
  }

  final public Statement DeleteStatement() throws ParseException {
    Token T;
    ArrayList<String> clause = null;
    jj_consume_token(DELETE);
    T = TableName();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WHERE:
      jj_consume_token(WHERE);
      clause = Condition();
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
        {if (true) return new DeleteStatement(T.image, clause);}
    throw new Error("Missing return statement in function");
  }

  final public Statement InsertStatement() throws ParseException {
    Token T;
    ArrayList<String> attr;
    ArrayList<String> values;
    Statement stmt;
    jj_consume_token(INSERT);
    T = TableName();
    jj_consume_token(LPAREN);
    attr = AttrList();
    jj_consume_token(RPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VALUES:
      values = tuples();
            {if (true) return new InsertStatement(T.image, attr, values);}
      break;
    case SELECT:
      stmt = SelectStatement();
            {if (true) return new InsertStatement(T.image, attr, (SelectStatement)stmt);}
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> AttrList() throws ParseException {
    Token T;
    ArrayList<String> attr = new ArrayList<String>();
    T = AttributeName();
         attr.add(T.image);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_4;
      }
      jj_consume_token(COMMA);
      T = AttributeName();
         attr.add(T.image);
    }
     {if (true) return attr;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> tuples() throws ParseException {
    Token T;
    ArrayList<String> tup;
    jj_consume_token(VALUES);
    jj_consume_token(LPAREN);
    tup = Values();
    jj_consume_token(RPAREN);
     {if (true) return tup;}
    throw new Error("Missing return statement in function");
  }

  final public String Value() throws ParseException {
    Token T;
    String S;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NULL:
      T = jj_consume_token(NULL);
         {if (true) return T.image;}
      break;
    case QUOTE:
      S = Literal();
         {if (true) return S;}
      break;
    case INTEGER:
      T = jj_consume_token(INTEGER);
         {if (true) return T.image;}
      break;
    case DIGIT:
      T = jj_consume_token(DIGIT);
         {if (true) return T.image;}
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> Values() throws ParseException {
    String T;
    ArrayList<String> vals = new ArrayList<String>();
    T = Value();
         vals.add(T);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_5;
      }
      jj_consume_token(COMMA);
      T = Value();
         vals.add(T);
    }
     {if (true) return vals;}
    throw new Error("Missing return statement in function");
  }

  final public Statement SelectStatement() throws ParseException {
    Token D = null;
    Statement stmt;
    ArrayList<String> selList;
    ArrayList<String> tabList;
    ArrayList<String> clause = null;
    Token O = null;
    jj_consume_token(SELECT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DISTINCT:
      D = jj_consume_token(DISTINCT);
      break;
    default:
      jj_la1[14] = jj_gen;
      ;
    }
    selList = selectList();
    jj_consume_token(FROM);
    tabList = tableList();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WHERE:
      jj_consume_token(WHERE);
      clause = Condition();
      break;
    default:
      jj_la1[15] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ORDERBY:
      jj_consume_token(ORDERBY);
      O = ColumnName();
      break;
    default:
      jj_la1[16] = jj_gen;
      ;
    }
        stmt = new SelectStatement(D, selList, tabList, clause, (O==null? "": O.image));
        {if (true) return stmt;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> selectList() throws ParseException {
    ArrayList<String> subList;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STAR:
      jj_consume_token(STAR);
         {if (true) return  new ArrayList<String>(){{add("*");}};}
      break;
    case LETTER:
    case NUMERAL:
      subList = selectSubList();
         {if (true) return subList;}
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> selectSubList() throws ParseException {
    Token T;
    ArrayList<String> subList = new ArrayList<String>();
    T = ColumnName();
     subList.add(T.image);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_6;
      }
      jj_consume_token(COMMA);
      T = ColumnName();
         subList.add(T.image);
    }
     {if (true) return subList;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> tableList() throws ParseException {
    Token T;
    ArrayList<String> tabList = new ArrayList<String>();
    T = TableName();
     tabList.add(T.image);
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[19] = jj_gen;
        break label_7;
      }
      jj_consume_token(COMMA);
      T = TableName();
         tabList.add(T.image);
    }
     {if (true) return tabList;}
    throw new Error("Missing return statement in function");
  }

  final public String term() throws ParseException {
    Token T;
    String S;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LETTER:
    case NUMERAL:
      T = ColumnName();
         {if (true) return T.image;}
      break;
    case QUOTE:
      S = Literal();
         {if (true) return S;}
      break;
    case INTEGER:
      T = jj_consume_token(INTEGER);
         {if (true) return T.image;}
      break;
    case DIGIT:
      T = jj_consume_token(DIGIT);
         {if (true) return T.image;}
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> exp() throws ParseException {
  Token T;
  String S;
  ArrayList<String> expList = new ArrayList<String>();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LPAREN:
      T = jj_consume_token(LPAREN);
                       expList.add(T.image);
      break;
    default:
      jj_la1[21] = jj_gen;
      ;
    }
    S = term();
                           expList.add(S);
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
      case STAR:
      case SLASH:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_8;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        T = jj_consume_token(PLUS);
                           expList.add(T.image);
        S = term();
                           expList.add(S);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case RPAREN:
          T = jj_consume_token(RPAREN);
                            expList.add(T.image);
          break;
        default:
          jj_la1[23] = jj_gen;
          ;
        }
        break;
      case MINUS:
        T = jj_consume_token(MINUS);
                           expList.add(T.image);
        S = term();
                           expList.add(S);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case RPAREN:
          T = jj_consume_token(RPAREN);
                            expList.add(T.image);
          break;
        default:
          jj_la1[24] = jj_gen;
          ;
        }
        break;
      case STAR:
        T = jj_consume_token(STAR);
                           expList.add(T.image);
        S = term();
                           expList.add(S);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case RPAREN:
          T = jj_consume_token(RPAREN);
                            expList.add(T.image);
          break;
        default:
          jj_la1[25] = jj_gen;
          ;
        }
        break;
      case SLASH:
        T = jj_consume_token(SLASH);
                           expList.add(T.image);
        S = term();
                           expList.add(S);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case RPAREN:
          T = jj_consume_token(RPAREN);
                            expList.add(T.image);
          break;
        default:
          jj_la1[26] = jj_gen;
          ;
        }
        break;
      default:
        jj_la1[27] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
      {if (true) return expList;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> boolFactor() throws ParseException {
    Token T;
    ArrayList<String> S;
    ArrayList<String> cond = new ArrayList<String>();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACKET:
      T = jj_consume_token(LBRACKET);
                       cond.add(T.image);
      break;
    default:
      jj_la1[28] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 40:
      T = jj_consume_token(40);
                   cond.add(T.image);
      break;
    default:
      jj_la1[29] = jj_gen;
      ;
    }
    S = exp();
                  cond.addAll(S);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LT:
      T = jj_consume_token(LT);
                    cond.add(T.image);
      break;
    case GT:
      T = jj_consume_token(GT);
                    cond.add(T.image);
      break;
    case EQ:
      T = jj_consume_token(EQ);
                    cond.add(T.image);
      break;
    default:
      jj_la1[30] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    S = exp();
                  cond.addAll(S);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RBRACKET:
      T = jj_consume_token(RBRACKET);
                       cond.add(T.image);
      break;
    default:
      jj_la1[31] = jj_gen;
      ;
    }
      {if (true) return cond;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> boolTerm() throws ParseException {
    Token T;
    ArrayList<String> S;
    ArrayList<String> cond = new ArrayList<String>();
    S = boolFactor();
                         cond.addAll(S);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 41:
      T = jj_consume_token(41);
                      cond.add(T.image);
      S = boolTerm();
                           cond.addAll(S);
      break;
    default:
      jj_la1[32] = jj_gen;
      ;
    }
      {if (true) return cond;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> Condition() throws ParseException {
    Token T;
    ArrayList<String> S;
    ArrayList<String> cond = new ArrayList<String>();
    S = boolTerm();
                       cond.addAll(S);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 42:
      T = jj_consume_token(42);
                             cond.add(T.image);
      S = Condition();
                            cond.addAll(S);
      break;
    default:
      jj_la1[33] = jj_gen;
      ;
    }
      {if (true) return cond;}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public TinyParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[34];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x600000,0x600000,0x40000000,0x61a80000,0x61a80000,0xf80,0xf80,0x20600000,0x20000000,0x8000,0x2200,0x20000000,0x1a0000,0x20000000,0x1000,0x8000,0x10000,0x600000,0x20000000,0x20000000,0x780000,0x800000,0x80000000,0x1000000,0x1000000,0x1000000,0x1000000,0x80000000,0x8000000,0x0,0x0,0x10000000,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x80,0x0,0x0,0x0,0x0,0x2,0x0,0x0,0x80,0x0,0x7,0x0,0x0,0x0,0x0,0x7,0x0,0x100,0x38,0x0,0x200,0x400,};
   }

  /** Constructor with InputStream. */
  public TinyParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public TinyParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new TinyParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public TinyParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new TinyParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public TinyParser(TinyParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(TinyParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[43];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 34; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 43; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

   }
