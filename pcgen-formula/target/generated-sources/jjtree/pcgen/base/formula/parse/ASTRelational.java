/* Generated by: JJTree: Do not edit this line. ASTRelational.java Version 1.1 */
/* ParserGeneratorCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package pcgen.base.formula.parse;

public
class ASTRelational extends SimpleNode {
  public ASTRelational(int id) {
    super(id);
  }

  public ASTRelational(FormulaParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(FormulaParserVisitor visitor, Object data) {
    return
    visitor.visit(this, data);
  }
}
/* ParserGeneratorCC - OriginalChecksum=f02ff6cbd9953c048d9e27d7f4ece5dc (do not edit this line) */
