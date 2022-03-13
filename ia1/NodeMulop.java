/**
 * Node containing the multiplication (*) and division (/) fields
 */
public class NodeMulop extends Node {

    private String mulop;

    /**
     * NodeMulop constructor
     * @param pos
     * @param mulop
     */
    public NodeMulop(int pos, String mulop) {
	this.pos=pos;
	this.mulop=mulop;
    }
    
    /**
     * Integer multiplication/division
     * @param d
     * @param o2
     * @return
     * @throws EvalException
     */
    public int op(int d, int o2) throws EvalException {
	if (mulop.equals("*"))
	    return d*o2;
	if (mulop.equals("/"))
	    return d/o2;
	throw new EvalException(pos,"bogus mulop: "+mulop);
    }

    
    /**
     * Double multiplication/division
     * @param d
     * @param o2
     * @return
     * @throws EvalException
     */
    public double op(double d, double o2) throws EvalException {
	if (mulop.equals("*"))
	    return d*o2;
	if (mulop.equals("/"))
	    return d/o2;
	throw new EvalException(pos,"bogus mulop: "+mulop);
    }
}
