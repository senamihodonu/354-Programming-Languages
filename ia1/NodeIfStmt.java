/**
 * Node containing the NodeStmt field
 */
public class NodeIfStmt extends NodeStmt {

	private NodeBoolExpr boolexpr;
    private NodeStmt stmt;
    private NodeStmt elseStmt;
    private final double TRUE_FLG = 1.0;
	private final double FALSE_FLG = 0.0;
	/**
	 * NodeStmt constructor
	 * @param assn
	 */
	public NodeIfStmt(NodeBoolExpr boolexpr, NodeStmt stmt, NodeStmt elseStmt) {
		this.boolexpr = boolexpr;
        this.stmt = stmt;
        this.elseStmt = elseStmt;
	}

	/**
	 * Evaluates a given assignment expression
	 */
	public double eval(Environment env) throws EvalException {

        if (boolexpr.eval(env) == TRUE_FLG) {
            return stmt.eval(env);
        }
        else if (elseStmt != null) {
            return elseStmt.eval(env);
        }
		return FALSE_FLG;
	}

}
