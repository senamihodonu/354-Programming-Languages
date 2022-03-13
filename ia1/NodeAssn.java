/**
 * Node containing the assignment field
 */
public class NodeAssn extends Node {

	private String id;
	private NodeExpr expr;

	/**
	 * Node assignment constructor
	 * @param id
	 * @param expr
	 */
	public NodeAssn(String id, NodeExpr expr) {
		this.id = id;
		this.expr = expr;
	}
	
	/**
	 * Evaluates Assignment
	 */
	public double eval(Environment env) throws EvalException {
		return env.put(id, expr.eval(env));
	}

}
