
import java.util.*;

/**
 * This class is a scanner for the program and programming language being
 * interpreted.
 * 
 */
public class Scanner {

	private String program; // source program being interpreted
	private int pos; // index of next char in program
	private Token token; // last/current scanned token

	// sets of various characters and lexemes
	private Set<String> whitespace = new HashSet<String>();
	private Set<String> digits = new HashSet<String>();
	private Set<String> letters = new HashSet<String>();
	private Set<String> legits = new HashSet<String>();
	private Set<String> keywords = new HashSet<String>();
	private Set<String> operators = new HashSet<String>();
	private boolean nonToken;

	// initializers for previous sets
	/**
	 * Helper function to help fill out sets
	 * @param s
	 * @param lo
	 * @param hi
	 */
	private void fill(Set<String> s, char lo, char hi) {
		for (char c = lo; c <= hi; c++)
			s.add(c + "");
	}

	/**
	 * whitespace (non-token)
	 * @param s
	 */
	private void initWhitespace(Set<String> s) {
		String space = " ";
		String newline = "\n";
		String tab = "\t";

		String[] strings = { space, newline, tab };
		for (int i = 0; i < strings.length; i++) {
			s.add(strings[i]);
		}

	}

	/**
	 * digit tokens
	 * @param s
	 */
	private void initDigits(Set<String> s) {
		fill(s, '0', '9');
		s.add("."); // allows for doubles
	}

	/**
	 * leter tokens
	 * @param s
	 */
	private void initLetters(Set<String> s) {
		fill(s, 'A', 'Z');
		fill(s, 'a', 'z');
	}

	/**
	 * legitimate tokens
	 * @param s
	 */
	private void initLegits(Set<String> s) {
		s.addAll(letters);
		s.addAll(digits);
	}

	/**
	 * operator tokens
	 * @param s
	 */
	private void initOperators(Set<String> s) {
		s.add("=");
		s.add("+");
		s.add("-");
		s.add("*");
		s.add("/");
		s.add("(");
		s.add(")");
		s.add(";");
		s.add("--");
		s.add("---");
	}

	private void initKeywords(Set<String> s) {
	}

	// constructor:
	// - squirrel-away source program
	// - initialize sets
	public Scanner(String program) {
		this.program = program;
		pos = 0;
		token = null;

		if (program.startsWith("~") && program.endsWith("~")) {
			whitespace.add(program);
		}

		initWhitespace(whitespace);
		initDigits(digits);
		initLetters(letters);
		initLegits(legits);
		initKeywords(keywords);
		initOperators(operators);
	}

	// handy string-processing methods
	public boolean done() {
		return pos >= program.length();
	}

	private void many(Set<String> s) {
		while (!done() && s.contains(program.charAt(pos) + ""))
			pos++;
	}

	// This method advances the scanner,
	// until the current input character
	// is just after a sequence of one or more
	// of a particular character.
	// Arguments:
	// c = the character to search for
	// Members:
	// program = the scanner's input
	// pos = index of current input character
	private void past(char c) {
		while (!done() && c != program.charAt(pos))
			pos++;
		if (!done() && c == program.charAt(pos))
			pos++;
	}

	// scan various kinds of lexeme
	/**
	 * Number lexeme
	 */
	private void nextNumber() {
		int old = pos;
		many(digits);
		String preLexeme = program.substring(old, pos);
		token = new Token("num", preLexeme);
	}

	/**
	 * Keyword lexeme
	 */
	private void nextKwId() {
		int old = pos;
		many(letters);
		many(legits);
		String lexeme = program.substring(old, pos);
		token = new Token((keywords.contains(lexeme) ? lexeme : "id"), lexeme);
	}

	/**
	 * Operators lexeme
	 */
	private void nextOp() {
		int old = pos;
		pos = old + 2;
		if (!done()) {
			String lexeme = program.substring(old, pos);
			if (operators.contains(lexeme)) {
				token = new Token(lexeme); // two-char operator
				return;
			}
		}
		pos = old + 1;
		String preLexeme = program.substring(old, pos);
		String lexeme = commentCapture(preLexeme);
		token = new Token(lexeme); // one-char operator
	}

	/**
	 * ignores comments (~...~)
	 */
	private void ignoreComments() {
		pos++;
		while (!(program.charAt(pos) + "").equals("~")) {
			pos++;
		}
		pos++;
		if (!done()) {
			next();
		} else {
			nonToken = true;
		}
	}

	/**
	 * This method determines the kind of the next token (e.g., "id"), and calls a
	 * method to scan that token's lexeme (e.g., "foo").
	 * 
	 * @return
	 */

	public boolean next() {
		many(whitespace);
		if (done()) {
			token = new Token("EOF");
			return false;
		}
		String c = program.charAt(pos) + "";

		if (digits.contains(c))
			nextNumber();
		else if (letters.contains(c))
			nextKwId();
		else if (operators.contains(c))
			nextOp();
		else if (c.contains("~")) {
			ignoreComments();
		} else {
			System.err.println("illegal character at position " + pos);
			pos++;
			return next();
		}
		return true;
	}

	// This method scans the next lexeme,
	// if the current token is the expected token.
	public void match(Token t) throws SyntaxException {
		if (!t.equals(curr()))
			throw new SyntaxException(pos, t, curr());
		next();
	}

	/**
	 */
	public Token curr() throws SyntaxException {
		if (token == null)
			throw new SyntaxException(pos, new Token("ANY"), new Token("EMPTY"));
		return token;
	}

	/**
	 * @return the position of the scanner
	 */
	public int pos() {
		return pos;
	}

	/**
	 * Attempt to capture comments
	 * 
	 * @param word
	 * @return
	 */
	public String commentCapture(String word) {
		String retVal = "";
		if (word.startsWith("~") && word.endsWith("~")) {
			whitespace.add(word);
		} else {
			retVal = word;
		}
		return retVal;
	}

	/**
	 * Main class to allow for unit testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(args[0]);
			while (scanner.next()) {
				System.out.println(scanner.curr());
			}
		} catch (SyntaxException e) {
			System.err.println(e);
		}
	}

}
