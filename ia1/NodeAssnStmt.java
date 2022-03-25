/**
 * Node containing the NodeStmt field
 */
public class NodeAssnStmt extends NodeStmt {

	private NodeAssn assn;

	/**
	 * NodeStmt constructor
	 * @param assn
	 */
	public NodeAssnStmt(NodeAssn assn) {
		this.assn = assn;
	}

	/**
	 * Evaluates a given assignment expression
	 */
	public double eval(Environment env) throws EvalException {
		return assn.eval(env);
	}

}
