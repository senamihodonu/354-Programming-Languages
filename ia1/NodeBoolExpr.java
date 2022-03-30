/**
 * Node containing the expression field
 */
public class NodeBoolExpr extends Node {

	private NodeExpr expr1;
	private NodeRelop relop;
	private NodeExpr expr2;
	private final double TRUE_FLG = 1.0;
	private final double FALSE_FLG = 0.0;

	/**
	 * Boolean expression node constructor
	 * @param term
	 * @param addop
	 * @param expr
	 */
	public NodeBoolExpr(NodeExpr expr1, NodeRelop relop, NodeExpr expr2) {
		this.expr1 = expr1;
		this.relop = relop;
		this.expr2 = expr2;
	}

	/**
	 * BoolExpr eval method
	 */
	public double eval(Environment env) throws EvalException {
		if(expr1 != null && expr2 != null && relop != null){
			if(relop.op(expr1.eval(env), expr2.eval(env))){
				return TRUE_FLG;

			} else {
				return FALSE_FLG;
			}
		}
		return FALSE_FLG;
	}

}
