/**
 * Node containing the NodeStmt field
 */
public class NodeStmt extends Node {

	private NodeAssn assn;

	/**
	 * NodeStmt constructor
	 * @param assn
	 */
	public NodeStmt(NodeAssn assn) {
		this.assn = assn;
	}

	/**
	 * Evaluates a given assignment expression
	 */
	public double eval(Environment env) throws EvalException {
		return assn.eval(env);
	}

}
