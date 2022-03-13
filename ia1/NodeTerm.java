/**
 * 
 * @author senam
 *
 */
public class NodeTerm extends Node {

	private NodeFact fact;
	private NodeMulop mulop;
	private NodeTerm term;

	public NodeTerm(NodeFact fact, NodeMulop mulop, NodeTerm term) {
		this.fact = fact;
		this.mulop = mulop;
		this.term = term;
	}

	/**
	 * Helps append terms
	 * @param term
	 */
	public void append(NodeTerm term) {
		if (this.term == null) {
			this.mulop = term.mulop;
			this.term = term;
			term.mulop = null;
		} else
			this.term.append(term);
	}
	
	/**
	 * Evaluates the multiplication/division expression
	 */
	public double eval(Environment env) throws EvalException {
		return term == null ? fact.eval(env) : mulop.op(term.eval(env), fact.eval(env));
	}

}
