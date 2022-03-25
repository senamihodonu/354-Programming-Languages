/**
 * Node containing the relation fields
 */

public class NodeRelop extends Node {

	private String relop;
    private double relopVal;
    private final double TRUE_VAL = 1.0;
    private double FALSE_VAL = 0.0;



	public NodeRelop(int pos, String relop) {
		this.pos = pos;
		this.relop = relop;
	}

// 	/**
// 	 * Integer addition
// 	 * 
// 	 * @param o1
// 	 * @param o2
// 	 * @return
// 	 * @throws EvalException
// 	 */
// 	public int op(int o1, int o2) throws EvalException {
// 		if (addop.equals("+"))
// 			return o1 + o2;
// 		if (addop.equals("-"))
// 			return o1 - o2;
// 		throw new EvalException(pos, "bogus addop: " + addop);
// 	}

	/**
	 * Double addition
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

		if (relop.equals(">=")){
            return (o1 >= o2);
        }


		if (relop.equals("<")){
            return (o1 < o2);
        }


		if (relop.equals("<=")){
            return (o1 <= o2);
        }


		if (relop.equals("<>")){
            return (o1 != o2);
        }


		if (relop.equals("==")){
            return (o1 == o2);
        }



		throw new EvalException(pos, "bogus addop: " + relop);
	}

}
