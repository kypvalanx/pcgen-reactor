/* Generated by: JJTree: Do not edit this line. ASTPCGenBracket.java Version 1.1 */
/* ParserGeneratorCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package pcgen.base.formula.parse;

public
class ASTPCGenBracket extends SimpleNode {
  public ASTPCGenBracket(int id) {
    super(id);
  }

  public ASTPCGenBracket(FormulaParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(FormulaParserVisitor visitor, Object data) {
    return
    visitor.visit(this, data);
  }
}
/* ParserGeneratorCC - OriginalChecksum=b241a567b608d267ee25b698f385a5be (do not edit this line) */
