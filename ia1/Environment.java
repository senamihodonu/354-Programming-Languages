import java.util.HashMap;
import java.util.Map;

 /**
  * This class provides a stubbed-out environment. You are expected to 
  * implement the methods. Accessing an undefined variable should throw 
  * an exception.
  * 
  * Hint! 
  * Use the Java API to implement your Environment.
  * Browse: 
  * https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html
  * Read about Collections. 
  * Focus on the Map interface and HashMap implementation.
  * Also: 
  * https://www.tutorialspoint.com/java/java_map_interface.htm
  * http://www.javatpoint.com/java-map 
  * and elsewhere.
  */

public class Environment {

	private Map<String, Double> map = new HashMap<String, Double>();

	/**
	 * Maps a value to a variable
	 * @param var
	 * @param val
	 * @return
	 */
	public double put(String var, double val) {
		map.put(var, val);
		return val;
	}

	/**
	 * @param pos
	 * @param var
	 * @return the value from the map
	 * @throws EvalException
	 */
	public double get(int pos, String var) throws EvalException {
		double ret = 0;
		try {
			ret = map.get(var);
		} catch (Exception e) {
			System.out.println(e + " at " + pos);
		}
		return ret;
	}

}
