/**
 * Node containing the node factor expression field
 */
public class NodeFactExpr extends NodeFact {

	private NodeExpr expr;

	/**
	 * Node factor expression constructor
	 * @param expr
	 */
	public NodeFactExpr(NodeExpr expr) {
		this.expr = expr;
	}

	/**
	 * Evaluates a given expression
	 */
	public double eval(Environment env) throws EvalException {
		return expr.eval(env);
	}

}
