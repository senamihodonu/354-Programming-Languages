/**
 * Node containing the expression field
 */
public class NodeExpr extends Node {

	private NodeTerm term;
	private NodeAddop addop;
	private NodeExpr expr;

	/**
	 * Node expression constructor
	 * @param term
	 * @param addop
	 * @param expr
	 */
	public NodeExpr(NodeTerm term, NodeAddop addop, NodeExpr expr) {
		this.term = term;
		this.addop = addop;
		this.expr = expr;
	}
	/**
	 * Help append expressions
	 * @param expr
	 */
	public void append(NodeExpr expr) {
		if (this.expr == null) {
			this.addop = expr.addop;
			this.expr = expr;
			expr.addop = null;
		} else
			this.expr.append(expr);
	}

	/**
	 * Evaluates a given expression
	 */
	public double eval(Environment env) throws EvalException {
		return expr == null ? term.eval(env) : addop.op(expr.eval(env), term.eval(env));
	}

}
