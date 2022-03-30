/**
 * Node containing the NodeStmt field
 */
public class NodeBlock extends Node {

	private NodeStmt stmt;
	private NodeBlock block;

	/**
	 * NodeBlock Constructor
	 * @param stmt
	 * @param block
	 */
	public NodeBlock(NodeStmt stmt, NodeBlock block) {
		this.stmt = stmt;
		this.block = block;

	}

	/**
	 * Block eval method
	 */
	public double eval(Environment env) throws EvalException {
		double retVal = stmt.eval(env);

		if(block != null){
			retVal = block.eval(env);
		}
		return retVal;
	}

}
