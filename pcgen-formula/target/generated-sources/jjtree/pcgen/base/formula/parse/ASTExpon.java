/* Generated by: JJTree: Do not edit this line. ASTExpon.java Version 1.1 */
/* ParserGeneratorCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package pcgen.base.formula.parse;

public
class ASTExpon extends SimpleNode {
  public ASTExpon(int id) {
    super(id);
  }

  public ASTExpon(FormulaParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(FormulaParserVisitor visitor, Object data) {
    return
    visitor.visit(this, data);
  }
}
/* ParserGeneratorCC - OriginalChecksum=6107f07ec0d5ee291d3b0a5328bbfa00 (do not edit this line) */
