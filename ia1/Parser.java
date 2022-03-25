import java.util.*;
/**
 * This class is a recursive-descent parser, modeled after 
 * the programming language's grammar.It constructs and 
 * has-a Scanner for the program being parsed.
 */
public class Parser {

	private Scanner scanner;

	/**
	 * checks for matching token
	 * @param s
	 * @throws SyntaxException
	 */
	private void match(String s) throws SyntaxException {
		scanner.match(new Token(s));
	}

	/**
	 * @return current token
	 * @throws SyntaxException
	 */
	private Token curr() throws SyntaxException {
		return scanner.curr();
	}

	/**
	 * @return scanner position
	 */
	private int pos() {
		return scanner.pos();
	}

	/**
	 * parsing NodeMulop operators
	 * @return
	 * @throws SyntaxException
	 */
	private NodeMulop parseMulop() throws SyntaxException {
		if (curr().equals(new Token("*"))) {
			match("*");
			return new NodeMulop(pos(), "*");
		}
		if (curr().equals(new Token("/"))) {
			match("/");
			return new NodeMulop(pos(), "/");
		}
		return null;
	}
	
	/**
	 * parsing NodeAddop operators
	 * @return
	 * @throws SyntaxException
	 */
	private NodeAddop parseAddop() throws SyntaxException {
		if (curr().equals(new Token("+"))) {
			match("+");
			return new NodeAddop(pos(), "+");
		}
		if (curr().equals(new Token("-"))) {
			match("-");
			return new NodeAddop(pos(), "-");
		}
		if (curr().equals(new Token("--"))) {
			match("--");
			return new NodeAddop(pos(), "+");
		} 
		return null;
	}

	/**
	 * parsing NodeRelop operators
	 * @return
	 * @throws SyntaxException
	 */
	private NodeRelop parseRelop() throws SyntaxException {
		if (curr().equals(new Token("<"))) {
			match("<");
			return new NodeRelop(pos(), "<");
		}
		if (curr().equals(new Token("<="))) {
			match("<=");
			return new NodeRelop(pos(), "<=");
		}
		if (curr().equals(new Token(">"))) {
			match(">");
			return new NodeRelop(pos(), ">");
		} 
		if (curr().equals(new Token(">="))) {
			match(">=");
			return new NodeRelop(pos(), ">=");
		}
		if (curr().equals(new Token("<>"))) {
			match("<>");
			return new NodeRelop(pos(), "<>");
		}
		if (curr().equals(new Token("=="))) {
			match("==");
			return new NodeRelop(pos(), "==");
		} 
		return null;
	}

	private NodeBoolExpr parseBoolExpr() throws SyntaxException{
		NodeExpr expr = parseExpr();
		NodeRelop relop = parseRelop();
		if(relop == null)
			return new NodeBoolExpr(expr, null, null);
		
		return null;
	}

	private NodeBlock parseBlock() throws SyntaxException{
		NodeStmt stmt = parseStmt();
		if (curr().equals(new Token(";"))) {
			match(";");
			NodeBlock block = parseBlock();
			return new NodeBlock(stmt, block);
		} else {
			return new NodeBlock(stmt, null);
		}
	}
	
	/**
	 * fact parsing
	 * @throws SyntaxException
	 */
	private NodeFact parseFact() throws SyntaxException {
		if (curr().equals(new Token("("))) {
			match("(");
			NodeExpr expr = parseExpr();
			match(")");
			return new NodeFactExpr(expr);
		}
		if (curr().equals(new Token("id"))) {
			Token id = curr();
			match("id");
			return new NodeFactId(pos(), id.lex());
		}
		Token num = curr();
		match("num");
		return new NodeFactNum(num.lex());
	}

	/**
	 * parses in a term
	 * @return term
	 * @throws SyntaxException
	 */
	private NodeTerm parseTerm() throws SyntaxException {
		NodeFact fact = parseFact();
		NodeMulop mulop = parseMulop();
		if (mulop == null)
			return new NodeTerm(fact, null, null);
		NodeTerm term = parseTerm();
		term.append(new NodeTerm(fact, mulop, null));
		return term;
	}

	/**
	 * parses in an expression
	 * @return expr
	 * @throws SyntaxException
	 */
	private NodeExpr parseExpr() throws SyntaxException {
		NodeTerm term = parseTerm();
		NodeAddop addop = parseAddop();
		if (addop == null)
			return new NodeExpr(term, null, null);
		NodeExpr expr = parseExpr();
		expr.append(new NodeExpr(term, addop, null));
		return expr;
	}

	/**
	 * parses in an assignment
	 * @return assn
	 * @throws SyntaxException
	 */
	private NodeAssn parseAssn() throws SyntaxException {
		Token id = curr();
		match("id");
		match("=");
		NodeExpr expr = parseExpr();
		NodeAssn assn = new NodeAssn(id.lex(), expr);
		return assn;
	}

	/**
	 * parses in a statement
	 * @return stmt
	 * @throws SyntaxException
	 */
	private NodeStmt parseStmt() throws SyntaxException {
		
		if (curr().tok().equals("if")) {
			match("if");
			NodeExpr expr1 = parseExpr();
			NodeRelop relop = parseRelop();
			NodeExpr expr2 = parseExpr();
			NodeBoolExpr bool = new NodeBoolExpr(expr1, relop, expr2);
			match("then");
			NodeStmt stmt = parseStmt();
			NodeStmt elseStmt = null;
			if (curr().tok().equals("else")) {
				match("else");
				elseStmt = parseStmt();
			}
			return new NodeIfStmt(bool, stmt, elseStmt);

		}

		if(curr().tok().equals("wr")){
			match("wr");
			NodeExpr expr = parseExpr();

			NodeWr nodeWr = new NodeWr(expr);
			return nodeWr;
		}

		if(curr().tok().equals("rd")){
			match("rd");
			String id = curr().lex();
			match("id");

			NodeRd nodeRd = new NodeRd(id);
			return nodeRd;

		}
		
		NodeAssn assn = parseAssn();
		NodeStmt stmt = new NodeAssnStmt(assn);
		return stmt;
	}

	/**
	 * parses in a program string
	 * @param program
	 * @return stmt
	 * @throws SyntaxException
	 */
	public Node parse(String program) throws SyntaxException {
		scanner = new Scanner(program);
		boolean x = scanner.next();
		NodeBlock block = parseBlock();
		match("EOF");
		return block;
	}

}
