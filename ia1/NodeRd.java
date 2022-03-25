/**
 * Node containing the assignment field
 */
public class NodeRd extends NodeStmt {

	private String id;
	
	/**
	 * Node assignment constructor
	 * @param id
	 * @param expr
	 */
	public NodeRd(String id) {
		this.id = id;
	}
	
	/**
	 * Evaluates Assignment
	 */
	public double eval(Environment env) throws EvalException {
        java.util.Scanner s = new java.util.Scanner(System.in);
        double val = s.nextDouble();
        env.put(id, val);
		return 0;
	}

}
