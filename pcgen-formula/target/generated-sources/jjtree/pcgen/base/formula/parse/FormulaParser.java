/* FormulaParser.java */
/* Generated by:  JJTree&ParserGeneratorCC: Do not edit this line. FormulaParser.java */
package pcgen.base.formula.parse;

public class FormulaParser/*@bgen(jjtree)*/implements FormulaParserTreeConstants, FormulaParserConstants {/*@bgen(jjtree)*/
  protected JJTFormulaParserState jjtree = new JJTFormulaParserState();

  final public SimpleNode query() throws ParseException {/*@bgen(jjtree) Root */
  ASTRoot jjtn000 = new ASTRoot(JJTROOT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case EXCLAMATION:
      case MINUS:
      case REM:
      case OPENPAREN:
      case FULLSTOP:
      case VARIABLE:
      case INT:
      case STRING_LITERAL:{
        logicalExpr();
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        ;
      }
      jj_consume_token(0);
jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
{if ("" != null) return jjtn000;}
    } catch (Throwable jjte000) {
if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof ParseException) {
      throw (ParseException)jjte000;
    }
    if (jjte000 instanceof RuntimeException) {
      throw (RuntimeException)jjte000;
    }
    throw (Error)jjte000;
    } finally {
if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
    throw new IllegalStateException ("Missing return statement in function");
}

/******************************************************************************
 * Add Logical expression and function
 *****************************************************************************/
  final public void logicalExpr() throws ParseException {Operator image;
    equalityExpr();
    label_1:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case AND:
      case OR:{
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      image = logicalFtn();
ASTLogical jjtn001 = new ASTLogical(JJTLOGICAL);
                          boolean jjtc001 = true;
                          jjtree.openNodeScope(jjtn001);
      try {
        equalityExpr();
      } catch (Throwable jjte001) {
if (jjtc001) {
                            jjtree.clearNodeScope(jjtn001);
                            jjtc001 = false;
                          } else {
                            jjtree.popNode();
                          }
                          if (jjte001 instanceof ParseException) {
                            throw (ParseException)jjte001;
                          }
                          if (jjte001 instanceof RuntimeException) {
                            throw (RuntimeException)jjte001;
                          }
                          throw (Error)jjte001;
      } finally {
if (jjtc001) {
                            jjtree.closeNodeScope(jjtn001,  2);
                          }
      }
((SimpleNode) jjtree.peekNode()).setOperator(image);
    }
}

  final public Operator logicalFtn() throws ParseException {Operator image;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
    case OR:{
      image = orToken();
      break;
      }
    case AND:{
      image = andToken();
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return image;}
    throw new IllegalStateException ("Missing return statement in function");
}

  final public Operator orToken() throws ParseException {
    jj_consume_token(OR);
{if ("" != null) return Operator.OR;}
    throw new IllegalStateException ("Missing return statement in function");
}

  final public Operator andToken() throws ParseException {
    jj_consume_token(AND);
{if ("" != null) return Operator.AND;}
    throw new IllegalStateException ("Missing return statement in function");
}

/******************************************************************************
 * Add Equality expression and functions
 *****************************************************************************/
  final public void equalityExpr() throws ParseException {Operator image;
    relationalExpr();
    label_2:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case EQUAL:
      case NOTEQUAL:{
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      image = equalityFtn();
ASTEquality jjtn001 = new ASTEquality(JJTEQUALITY);
                           boolean jjtc001 = true;
                           jjtree.openNodeScope(jjtn001);
      try {
        relationalExpr();
      } catch (Throwable jjte001) {
if (jjtc001) {
                             jjtree.clearNodeScope(jjtn001);
                             jjtc001 = false;
                           } else {
                             jjtree.popNode();
                           }
                           if (jjte001 instanceof ParseException) {
                             throw (ParseException)jjte001;
                           }
                           if (jjte001 instanceof RuntimeException) {
                             throw (RuntimeException)jjte001;
                           }
                           throw (Error)jjte001;
      } finally {
if (jjtc001) {
                             jjtree.closeNodeScope(jjtn001,  2);
                           }
      }
((SimpleNode) jjtree.peekNode()).setOperator(image);
    }
}

  final public Operator equalityFtn() throws ParseException {Operator image;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
    case EQUAL:{
      image = equalToken();
      break;
      }
    case NOTEQUAL:{
      image = notEqualToken();
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return image;}
    throw new IllegalStateException ("Missing return statement in function");
}

  final public Operator equalToken() throws ParseException {
    jj_consume_token(EQUAL);
{if ("" != null) return Operator.EQ;}
    throw new IllegalStateException ("Missing return statement in function");
}

  final public Operator notEqualToken() throws ParseException {
    jj_consume_token(NOTEQUAL);
{if ("" != null) return Operator.NEQ;}
    throw new IllegalStateException ("Missing return statement in function");
}

/******************************************************************************
 * Add Relational expression and functions
 *****************************************************************************/
  final public void relationalExpr() throws ParseException {Operator image;
    arithmeticExpr();
    label_3:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case GT:
      case LT:
      case GTEQ:
      case LTEQ:{
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      image = relationalFtn();
ASTRelational jjtn001 = new ASTRelational(JJTRELATIONAL);
                             boolean jjtc001 = true;
                             jjtree.openNodeScope(jjtn001);
      try {
        arithmeticExpr();
      } catch (Throwable jjte001) {
if (jjtc001) {
                               jjtree.clearNodeScope(jjtn001);
                               jjtc001 = false;
                             } else {
                               jjtree.popNode();
                             }
                             if (jjte001 instanceof ParseException) {
                               throw (ParseException)jjte001;
                             }
                             if (jjte001 instanceof RuntimeException) {
                               throw (RuntimeException)jjte001;
                             }
                             throw (Error)jjte001;
      } finally {
if (jjtc001) {
                               jjtree.closeNodeScope(jjtn001,  2);
                             }
      }
((SimpleNode) jjtree.peekNode()).setOperator(image);
    }
}

  final public Operator relationalFtn() throws ParseException {Operator image;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
    case LT:{
      image = lessThanToken();
      break;
      }
    case GT:{
      image = greaterThanToken();
      break;
      }
    case LTEQ:{
      image = lessThanOrEqualToToken();
      break;
      }
    case GTEQ:{
      image = greaterThanOrEqualToToken();
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return image;}
    throw new IllegalStateException ("Missing return statement in function");
}

  final public Operator lessThanToken() throws ParseException {
    jj_consume_token(LT);
{if ("" != null) return Operator.LT;}
    throw new IllegalStateException ("Missing return statement in function");
}

  final public Operator greaterThanToken() throws ParseException {
    jj_consume_token(GT);
{if ("" != null) return Operator.GT;}
    throw new IllegalStateException ("Missing return statement in function");
}

  final public Operator lessThanOrEqualToToken() throws ParseException {
    jj_consume_token(LTEQ);
{if ("" != null) return Operator.LE;}
    throw new IllegalStateException ("Missing return statement in function");
}

  final public Operator greaterThanOrEqualToToken() throws ParseException {
    jj_consume_token(GTEQ);
{if ("" != null) return Operator.GE;}
    throw new IllegalStateException ("Missing return statement in function");
}

/******************************************************************************
 * Add Arithmetic expression and function - addition and subtraction have
 * equal precedence
 *****************************************************************************/
  final public void arithmeticExpr() throws ParseException {Operator image;
    geometricExpr();
    label_4:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case PLUS:
      case MINUS:{
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        break label_4;
      }
      image = arithmeticFtn();
ASTArithmetic jjtn001 = new ASTArithmetic(JJTARITHMETIC);
                             boolean jjtc001 = true;
                             jjtree.openNodeScope(jjtn001);
      try {
        geometricExpr();
      } catch (Throwable jjte001) {
if (jjtc001) {
                               jjtree.clearNodeScope(jjtn001);
                               jjtc001 = false;
                             } else {
                               jjtree.popNode();
                             }
                             if (jjte001 instanceof ParseException) {
                               throw (ParseException)jjte001;
                             }
                             if (jjte001 instanceof RuntimeException) {
                               throw (RuntimeException)jjte001;
                             }
                             throw (Error)jjte001;
      } finally {
if (jjtc001) {
                               jjtree.closeNodeScope(jjtn001,  2);
                             }
      }
((SimpleNode) jjtree.peekNode()).setOperator(image);
    }
}

  final public Operator arithmeticFtn() throws ParseException {Operator image;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
    case PLUS:{
      image = plusToken();
      break;
      }
    case MINUS:{
      image = minusToken();
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return image;}
    throw new IllegalStateException ("Missing return statement in function");
}

  final public Operator plusToken() throws ParseException {
    jj_consume_token(PLUS);
{if ("" != null) return Operator.ADD;}
    throw new IllegalStateException ("Missing return statement in function");
}

  final public Operator minusToken() throws ParseException {
    jj_consume_token(MINUS);
{if ("" != null) return Operator.SUB;}
    throw new IllegalStateException ("Missing return statement in function");
}

/******************************************************************************
 * Add Geometric expression and functions - multiplication and both types of
 * division have equal precedence
 *****************************************************************************/
  final public void geometricExpr() throws ParseException {Operator image;
    unaryMinusExpr();
    label_5:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case MULT:
      case DIV:
      case REM:{
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        break label_5;
      }
      image = geometricFtn();
ASTGeometric jjtn001 = new ASTGeometric(JJTGEOMETRIC);
                            boolean jjtc001 = true;
                            jjtree.openNodeScope(jjtn001);
      try {
        unaryMinusExpr();
      } catch (Throwable jjte001) {
if (jjtc001) {
                              jjtree.clearNodeScope(jjtn001);
                              jjtc001 = false;
                            } else {
                              jjtree.popNode();
                            }
                            if (jjte001 instanceof ParseException) {
                              throw (ParseException)jjte001;
                            }
                            if (jjte001 instanceof RuntimeException) {
                              throw (RuntimeException)jjte001;
                            }
                            throw (Error)jjte001;
      } finally {
if (jjtc001) {
                              jjtree.closeNodeScope(jjtn001,  2);
                            }
      }
((SimpleNode) jjtree.peekNode()).setOperator(image);
    }
}

  final public Operator geometricFtn() throws ParseException {Operator image;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
    case MULT:{
      image = multToken();
      break;
      }
    case DIV:{
      image = divToken();
      break;
      }
    case REM:{
      image = remToken();
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return image;}
    throw new IllegalStateException ("Missing return statement in function");
}

  final public Operator multToken() throws ParseException {
    jj_consume_token(MULT);
{if ("" != null) return Operator.MUL;}
    throw new IllegalStateException ("Missing return statement in function");
}

  final public Operator divToken() throws ParseException {
    jj_consume_token(DIV);
{if ("" != null) return Operator.DIV;}
    throw new IllegalStateException ("Missing return statement in function");
}

  final public Operator remToken() throws ParseException {
    jj_consume_token(REM);
{if ("" != null) return Operator.REM;}
    throw new IllegalStateException ("Missing return statement in function");
}

/******************************************************************************
 * Add Unary expression
 *****************************************************************************/
  final public void unaryMinusExpr() throws ParseException {Token t = null;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
    case MINUS:{
      t = jj_consume_token(MINUS);
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      ;
    }
ASTUnaryMinus jjtn001 = new ASTUnaryMinus(JJTUNARYMINUS);
                   boolean jjtc001 = true;
                   jjtree.openNodeScope(jjtn001);
    try {
      unaryNotExpr();
    } catch (Throwable jjte001) {
if (jjtc001) {
                     jjtree.clearNodeScope(jjtn001);
                     jjtc001 = false;
                   } else {
                     jjtree.popNode();
                   }
                   if (jjte001 instanceof ParseException) {
                     throw (ParseException)jjte001;
                   }
                   if (jjte001 instanceof RuntimeException) {
                     throw (RuntimeException)jjte001;
                   }
                   throw (Error)jjte001;
    } finally {
if (jjtc001) {
                     jjtree.closeNodeScope(jjtn001,  t != null);
                   }
    }
SimpleNode n = ((SimpleNode) jjtree.peekNode());
     if (n instanceof ASTUnaryMinus) n.setOperator(Operator.MINUS);
}

  final public void unaryNotExpr() throws ParseException {Token t = null;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
    case EXCLAMATION:{
      t = jj_consume_token(EXCLAMATION);
      break;
      }
    default:
      jj_la1[12] = jj_gen;
      ;
    }
ASTUnaryNot jjtn001 = new ASTUnaryNot(JJTUNARYNOT);
                         boolean jjtc001 = true;
                         jjtree.openNodeScope(jjtn001);
    try {
      exponExpr();
    } catch (Throwable jjte001) {
if (jjtc001) {
                           jjtree.clearNodeScope(jjtn001);
                           jjtc001 = false;
                         } else {
                           jjtree.popNode();
                         }
                         if (jjte001 instanceof ParseException) {
                           throw (ParseException)jjte001;
                         }
                         if (jjte001 instanceof RuntimeException) {
                           throw (RuntimeException)jjte001;
                         }
                         throw (Error)jjte001;
    } finally {
if (jjtc001) {
                           jjtree.closeNodeScope(jjtn001,  t != null);
                         }
    }
SimpleNode n = ((SimpleNode) jjtree.peekNode());
     if (n instanceof ASTUnaryNot) n.setOperator(Operator.NOT);
}

/******************************************************************************
 * Add Exponential expression
 *****************************************************************************/
  final public void exponExpr() throws ParseException {
    primitiveExpr();
    label_6:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case POW:{
        break;
        }
      default:
        jj_la1[13] = jj_gen;
        break label_6;
      }
      jj_consume_token(POW);
ASTExpon jjtn001 = new ASTExpon(JJTEXPON);
           boolean jjtc001 = true;
           jjtree.openNodeScope(jjtn001);
      try {
        primitiveExpr();
      } catch (Throwable jjte001) {
if (jjtc001) {
             jjtree.clearNodeScope(jjtn001);
             jjtc001 = false;
           } else {
             jjtree.popNode();
           }
           if (jjte001 instanceof ParseException) {
             throw (ParseException)jjte001;
           }
           if (jjte001 instanceof RuntimeException) {
             throw (RuntimeException)jjte001;
           }
           throw (Error)jjte001;
      } finally {
if (jjtc001) {
             jjtree.closeNodeScope(jjtn001,  2);
           }
      }
((SimpleNode) jjtree.peekNode()).setOperator(Operator.EXP);
    }
}

/******************************************************************************
 * Now we're at the productions that will form the leaves of the tree
 *****************************************************************************/
  final public void primitiveExpr() throws ParseException {
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
    case OPENPAREN:{
      parenExpr();
      break;
      }
    case FULLSTOP:
    case INT:{
      numberExpr();
      break;
      }
    case REM:
    case VARIABLE:{
      lookupExpr();
      break;
      }
    case STRING_LITERAL:{
      quotedString();
      break;
      }
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void parenExpr() throws ParseException {/*@bgen(jjtree) Paren */
  ASTParen jjtn000 = new ASTParen(JJTPAREN);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(OPENPAREN);
      logicalExpr();
      jj_consume_token(CLOSEPAREN);
    } catch (Throwable jjte000) {
if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof ParseException) {
      throw (ParseException)jjte000;
    }
    if (jjte000 instanceof RuntimeException) {
      throw (RuntimeException)jjte000;
    }
    throw (Error)jjte000;
    } finally {
if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
}

  final public void numberExpr() throws ParseException {/*@bgen(jjtree) Num */
          ASTNum jjtn000 = new ASTNum(JJTNUM);
          boolean jjtc000 = true;
          jjtree.openNodeScope(jjtn000);Token t1 = null, t2 = null, t3 = null;
    try {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case INT:{
        t1 = jj_consume_token(INT);
        if (jj_2_1(2)) {
          t2 = jj_consume_token(FULLSTOP);
          t3 = jj_consume_token(INT);
        } else {
          ;
        }
        break;
        }
      case FULLSTOP:{
        t1 = jj_consume_token(FULLSTOP);
        t2 = jj_consume_token(INT);
        break;
        }
      default:
        jj_la1[15] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
String image;
   if (t3 == null) {
    if (t2 == null) {
     image = t1.image;
    } else {
     image = "." + t2.image;
    }
   } else {
    image = t1.image + "." + t3.image;
   }
   jjtn000.setToken(image);
    } finally {
if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
}

/******************************************************************************
 * This is the start of the PCGEN specific stuff.  The "Dot separated words"
 * are used for our OS tokens and in some of our predefined variables.
 *****************************************************************************/
  final public void lookupExpr() throws ParseException {/*@bgen(jjtree) #PCGenLookup(> 1) */
  ASTPCGenLookup jjtn000 = new ASTPCGenLookup(JJTPCGENLOOKUP);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      pcgenSingleWord();
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case OPENPAREN:
      case OPENBRACKET:{
        switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case OPENBRACKET:{
          pcgenBracketGroup();
          break;
          }
        case OPENPAREN:{
          parenGroup();
          break;
          }
        default:
          jj_la1[16] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      default:
        jj_la1[17] = jj_gen;
        ;
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof ParseException) {
      throw (ParseException)jjte000;
    }
    if (jjte000 instanceof RuntimeException) {
      throw (RuntimeException)jjte000;
    }
    throw (Error)jjte000;
    } finally {
if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, jjtree.nodeArity() >  1);
    }
    }
}

  final public void pcgenSingleWord() throws ParseException {/*@bgen(jjtree) PCGenSingleWord */
                      ASTPCGenSingleWord jjtn000 = new ASTPCGenSingleWord(JJTPCGENSINGLEWORD);
                      boolean jjtc000 = true;
                      jjtree.openNodeScope(jjtn000);Token t; Token i = null;
    try {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case REM:{
        i = jj_consume_token(REM);
        break;
        }
      default:
        jj_la1[18] = jj_gen;
        ;
      }
      t = jj_consume_token(VARIABLE);
jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
String image;
   if (i == null) {
    image = t.image;
   } else {
       if (i.image.lastIndexOf(" ") == i.image.length() - 1)
       {
           throw new ParseException("Found Word with embedded space: " + i.image + t.image);
       }
    image = i.image + t.image;
   }
   /*
			 * Cannot enforce spaces on other words, due to Class names allowing spaces
			 */
   jjtn000.setToken(image);
    } finally {
if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
}

  final public void pcgenBracketGroup() throws ParseException {/*@bgen(jjtree) PCGenBracket */
  ASTPCGenBracket jjtn000 = new ASTPCGenBracket(JJTPCGENBRACKET);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(OPENBRACKET);
      arithmeticExpr();
      jj_consume_token(CLOSEBRACKET);
    } catch (Throwable jjte000) {
if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof ParseException) {
      throw (ParseException)jjte000;
    }
    if (jjte000 instanceof RuntimeException) {
      throw (RuntimeException)jjte000;
    }
    throw (Error)jjte000;
    } finally {
if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
}

  final public void parenGroup() throws ParseException {/*@bgen(jjtree) FParen */
             ASTFParen jjtn000 = new ASTFParen(JJTFPAREN);
             boolean jjtc000 = true;
             jjtree.openNodeScope(jjtn000);Token t1;
    try {
      jj_consume_token(OPENPAREN);
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case EXCLAMATION:
      case MINUS:
      case REM:
      case OPENPAREN:
      case FULLSTOP:
      case VARIABLE:
      case INT:
      case STRING_LITERAL:{
        functionExpr();
        label_7:
        while (true) {
          switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
          case COMMA:{
            break;
            }
          default:
            jj_la1[19] = jj_gen;
            break label_7;
          }
          jj_consume_token(COMMA);
          functionExpr();
        }
        break;
        }
      default:
        jj_la1[20] = jj_gen;
        ;
      }
      jj_consume_token(CLOSEPAREN);
    } catch (Throwable jjte000) {
if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof ParseException) {
      throw (ParseException)jjte000;
    }
    if (jjte000 instanceof RuntimeException) {
      throw (RuntimeException)jjte000;
    }
    throw (Error)jjte000;
    } finally {
if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
}

  final public void functionExpr() throws ParseException {
    logicalExpr();
}

  final public void quotedString() throws ParseException {/*@bgen(jjtree) QuotString */
                 ASTQuotString jjtn000 = new ASTQuotString(JJTQUOTSTRING);
                 boolean jjtc000 = true;
                 jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(STRING_LITERAL);
jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
String stripped = t.image.substring(1, t.image.length() - 1);
   jjtn000.setToken(stripped);
    } finally {
if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
}

  private boolean jj_2_1(int xla)
 {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try { return (!jj_3_1()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3_1()
 {
    if (jj_scan_token(FULLSTOP)) return true;
    if (jj_scan_token(INT)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public FormulaParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[21];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x40049400,0x30000000,0x30000000,0xc000000,0xc000000,0x3c00000,0x3c00000,0x1800,0x1800,0xe000,0xe000,0x1000,0x400,0x10000,0x40048000,0x40000000,0x140000,0x140000,0x8000,0x20000,0x40049400,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x98,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x98,0x10,0x0,0x0,0x0,0x0,0x98,};
	}
  private final JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /**
   * Constructor with InputStream.
   * @param stream input stream
   */
  public FormulaParser(final java.io.InputStream stream) {
	  this(stream, null);
  }

  /**
   * Constructor with InputStream and supplied encoding
   * @param stream input stream
   * @param encoding charset to be used
   */
  public FormulaParser(final java.io.InputStream stream, final java.nio.charset.Charset encoding) {
   jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1);
	 token_source = new FormulaParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 21; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /**
   * Reinitialise
   * @param stream input stream
   */
  public void ReInit(final java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /**
   * Reinitialise
   * @param stream input stream
   * @param encoding charset to be used
   */
  public void ReInit(final java.io.InputStream stream, final java.nio.charset.Charset encoding) {
    jj_input_stream.reInit(stream, encoding, 1, 1);
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 21; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /**
   * Constructor with InputStream.
   * @param stream char stream
   */
  public FormulaParser(final java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new FormulaParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
   for (int i = 0; i < 21; i++)
     jj_la1[i] = -1;
   for (int i = 0; i < jj_2_rtns.length; i++)
     jj_2_rtns[i] = new JJCalls();
  }

  /**
   * Reinitialise
   * @param stream char stream
   */
  public void ReInit(final java.io.Reader stream) {
	if (jj_input_stream == null) {
	  jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	  jj_input_stream.reInit(stream, 1, 1);
  }
	if (token_source == null) {
 token_source = new FormulaParserTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
   for (int i = 0; i < 21; i++)
     jj_la1[i] = -1;
   for (int i = 0; i < jj_2_rtns.length; i++)
     jj_2_rtns[i] = new JJCalls();
  }

  /**
   * Constructor with generated Token Manager.
   * @param tm Token manager to use
   */
  public FormulaParser(final FormulaParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 21; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /**
   * Reinitialise
   * @param tm Token manager to use
   */
  public void ReInit(final FormulaParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 21; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(final int kind) throws ParseException {
    final Token oldToken = token;
    if (token.next != null)
      token = token.next;
    else {
      token.next = token_source.getNextToken();
      token = token.next;
    }
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen)
              c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  @SuppressWarnings("serial")
  private static final class LookaheadSuccess extends IllegalStateException { }
  private final LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
	 if (jj_scanpos == jj_lastpos) {
	   jj_la--;
	   if (jj_scanpos.next == null) {
		   jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
	   } else {
		   jj_lastpos = jj_scanpos = jj_scanpos.next;
	   }
	 } else {
	   jj_scanpos = jj_scanpos.next;
	 }
	 if (jj_rescan) {
	   int i = 0; Token tok = token;
	   while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
	   if (tok != null) jj_add_error_token(kind, i);
	 }
	 if (jj_scanpos.kind != kind) return true;
	 if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
	 return false;
  }


  /**
   * @return the next Token.
   */
  public final Token getNextToken() {
   if (token.next != null)
     token = token.next;
   else
     token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

  /**
   * @param index index to be retrieved
   * @return the specific Token.
   */
  public final Token getToken(final int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next == null)
        t.next = token_source.getNextToken();
      t = t.next;
    }
    return t;
  }

  private int jj_ntk_f() {
    jj_nt = token.next;
    if (jj_nt == null) {
      token.next = token_source.getNextToken();
      jj_ntk = token.next.kind;
      return jj_ntk;
    }
    jj_ntk = jj_nt.kind;
    return jj_ntk;
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
  if (pos >= 100) {
    return;
  }

  if (pos == jj_endpos + 1) {
    jj_lasttokens[jj_endpos++] = kind;
  } else if (jj_endpos != 0) {
    jj_expentry = new int[jj_endpos];

    for (int i = 0; i < jj_endpos; i++) {
      jj_expentry[i] = jj_lasttokens[i];
    }

    for (final int[] oldentry : jj_expentries) {
      if (oldentry.length == jj_expentry.length) {
        boolean isMatched = true;
        for (int i = 0; i < jj_expentry.length; i++) {
          if (oldentry[i] != jj_expentry[i]) {
            isMatched = false;
            break;
          }
        }
        if (isMatched) {
          jj_expentries.add(jj_expentry);
          break;
        }
      }
    }

    if (pos != 0) {
      jj_endpos = pos;
      jj_lasttokens[jj_endpos - 1] = kind;
    }
  }
}

  /**
   * Generate ParseException.
   * @return new Exception object. Never <code>null</code>
   */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[40];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 21; i++) {
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
    for (int i = 0; i < 40; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /**
   * @return Always <code>false</code>.
   */
  public final boolean trace_enabled() {
    return false;
  }

  /** Enable tracing. */
  public final void enable_tracing() {}

  /** Disable tracing. */
  public final void disable_tracing() {}

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
      try {
        JJCalls p = jj_2_rtns[i];
        do {
          if (p.gen > jj_gen) {
            jj_la = p.arg;
            jj_scanpos = p.first;
            jj_lastpos = p.first;
            switch (i) {
              case 0: jj_3_1(); break;
            }
          }
          p = p.next;
        } while (p != null);
      } catch(LookaheadSuccess ls) { /* ignore */ }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) {
        p.next = new JJCalls();
        p = p.next;
        break;
      }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; 
    p.first = token;
    p.arg = xla;
  }

  static final class JJCalls {
	 int gen;
	 Token first;
	 int arg;
	 JJCalls next;
  }

}