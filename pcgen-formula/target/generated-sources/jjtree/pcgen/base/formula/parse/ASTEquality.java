/* Generated by: JJTree: Do not edit this line. ASTEquality.java Version 1.1 */
/* ParserGeneratorCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package pcgen.base.formula.parse;

public
class ASTEquality extends SimpleNode {
  public ASTEquality(int id) {
    super(id);
  }

  public ASTEquality(FormulaParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(FormulaParserVisitor visitor, Object data) {
    return
    visitor.visit(this, data);
  }
}
/* ParserGeneratorCC - OriginalChecksum=1dba35f97bb8cf5e9da1cdf9e96c6ae1 (do not edit this line) */
