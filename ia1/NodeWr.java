/**
 * Node containing the assignment field
 */
public class NodeWr extends NodeStmt {

	private NodeExpr expr;
	
	/**
	 * Node assignment constructor
	 * @param id
	 * @param expr
	 */
	public NodeWr(NodeExpr expr) {
		
		this.expr = expr;
	}
	
	/**
	 * Evaluates Assignment
	 */
	public double eval(Environment env) throws EvalException {
        System.out.println(expr.eval(env));
		return 0;
	}

}
