/**
 * Node containing the addition (+) and subtraction (-) fields
 */
public class NodeAddop extends Node {

	private String addop;

	public NodeAddop(int pos, String addop) {
		this.pos = pos;
		this.addop = addop;
	}

	/**
	 * Integer addition eval
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 * @throws EvalException
	 */
	public int op(int o1, int o2) throws EvalException {
		if (addop.equals("+"))
			return o1 + o2;
		if (addop.equals("-"))
			return o1 - o2;
		throw new EvalException(pos, "bogus addop: " + addop);
	}

	/**
	 * Double addition eval
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 * @throws EvalException
	 */
	public double op(double o1, double o2) throws EvalException {
		if (addop.equals("+"))
			return o1 + o2;
		if (addop.equals("-"))
			return o1 - o2;
		throw new EvalException(pos, "bogus addop: " + addop);
	}

}
