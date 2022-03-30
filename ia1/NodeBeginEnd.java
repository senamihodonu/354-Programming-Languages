/**
 * Begin-End node
 */
public class NodeBeginEnd extends NodeStmt {

	private NodeBlock block;
	
	public NodeBeginEnd(NodeBlock block) {
		this.block = block;

	}
	
	/**
	 * Begin-End eval method
	 */
	public double eval(Environment env) throws EvalException {
		
            return block.eval(env);
        
		
	}
}