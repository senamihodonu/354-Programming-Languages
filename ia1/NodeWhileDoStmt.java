/**
 * Node containing the NodeWhileDoStmt field
 */
public class NodeWhileDoStmt extends NodeStmt {

	private NodeBoolExpr boolexpr;
    private NodeStmt stmt;
    private final double TRUE_FLG = 1.0;
	private final double FALSE_FLG = 0.0;
	/**
	 * NodeStmt constructor
	 * @param assn
	 */
	public NodeWhileDoStmt(NodeBoolExpr boolexpr, NodeStmt stmt) {
		this.boolexpr = boolexpr;
        this.stmt = stmt;
	}

	/**
	 * NodeWhileDoStmt eval method 
	 */
	public double eval(Environment env) throws EvalException {
        if (boolexpr.eval(env) == TRUE_FLG) {
            return stmt.eval(env);
        } 

		if (boolexpr.eval(env) == FALSE_FLG) {
            return FALSE_FLG;
        } 

		return 0.0;

	}

}
