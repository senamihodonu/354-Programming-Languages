/**
 * Node containing the NodeFactNum field
 */
public class NodeFactNum extends NodeFact {

    private String num;
    /**
     * NodeFactNum expression constructor
     * @param num
     */
    public NodeFactNum(String num) {
	this.num=num;
    }

	/**
	 * Evaluates a given expression
	 */
    public double eval(Environment env) throws EvalException {
	return Double.parseDouble(num);
    }

}
