// This is the main class/method for the interpreter.
// Each command-line argument is a complete program,
// which is scanned, parsed, and evaluated.
// All evaluations share the same environment,
// so they can share variables.

public class Interpreter {

    public static void main(String[] args) {
		//args = new String[1];
		//args[0] = "if 1 < 2 then wr 1";
	Parser parser=new Parser();
	
	Environment env=new Environment();
	for (String stmt: args)
	    try {
	    	// if(stmt.contains(".")) {
	    	// 	System.out.println(parser.parse(stmt).eval(env));
	    	// } else {
	    	// 	System.out.println((int)parser.parse(stmt).eval(env));
	    	// }
			parser.parse(stmt).eval(env);
	    } catch (SyntaxException e) {
		System.err.println(e);
	    } catch (EvalException e) {
		System.err.println(e);
	    }
    }

}
