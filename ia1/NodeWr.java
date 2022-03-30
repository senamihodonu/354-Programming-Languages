/**
 * Wr node class
 */
public class NodeWr extends NodeStmt {

	private NodeExpr expr;
	
	/**
	 * Wr node constructor
	 * @param id
	 * @param expr
	 */
	public NodeWr(NodeExpr expr) {
		
		this.expr = expr;
	}
	
	/**
	 * Evaluate method for the Wr
	 */
	public double eval(Environment env) throws EvalException {
        System.out.println(expr.eval(env));
		return 0;
	}

}
