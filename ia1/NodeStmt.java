/**
 * Node containing the NodeStmt field
 */ 
public abstract class NodeStmt extends Node {


	/**
	 * NodeStmt constructor
	 * @param assn
	 */
	public NodeStmt() {
	
	}

	/**
	 * NodeStmt eval method
	 */
	public double eval(Environment env) throws EvalException {
		throw new EvalException(pos,"cannot eval() nodeStmts!");
		}
}
