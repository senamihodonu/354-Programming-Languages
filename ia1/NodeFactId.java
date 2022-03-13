/**
 * Node containing the NodeFactId field
 */
public class NodeFactId extends NodeFact {

    private String id;

    /**
     * Node factor expression constructor
     * @param pos
     * @param id
     */
    public NodeFactId(int pos, String id) {
	this.pos=pos;
	this.id=id;
    }

	/**
	 * Evaluates a given expression
	 */
    public double eval(Environment env) throws EvalException {
	return env.get(pos,id);
    }

}
