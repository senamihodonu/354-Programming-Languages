/**
 * Node containing the NodeStmt field
 */
public class NodeProg extends Node {

	private NodeBlock block;

	/**
	 * NodeStmt constructor
	 * @param block
	 */
	public NodeProg(NodeBlock block) {
		this.block = block;
	}

	/**
	 * Evaluates a given assignment expression
	 */
	public double eval(Environment env) throws EvalException {
		return block.eval(env);
	}

}
