/**
 * Node containing the relation fields
 */

public class NodeRelop extends Node {

	private String relop;

	/**
	 * NodeRelop constructor
	 * @param pos
	 * @param relop
	 */
	public NodeRelop(int pos, String relop) {
		this.pos = pos;
		this.relop = relop;
	}

	/**
	 * Relop eval method
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 * @throws EvalException
	 */
	public boolean op(double o1, double o2) throws EvalException {
		if (relop.equals(">")){
            return (o1 > o2);
        }

		else if (relop.equals(">=")){
            return (o1 >= o2);
        }


		else if (relop.equals("<")){
            return (o1 < o2);
        }


		else if (relop.equals("<=")){
            return (o1 <= o2);
        }


		else if (relop.equals("<>")){
            return (o1 != o2);
        }


		else if (relop.equals("==")){
            return (o1 == o2);
        }
		
		throw new EvalException(pos, "bogus relop: " + relop);
	}

}
