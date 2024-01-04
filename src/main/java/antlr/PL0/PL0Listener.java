// Generated from E:/软件学院/编译原理/期末项目/PL0-compiler/src/grammar/PL0.g4 by ANTLR 4.13.1
package antlr.PL0;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PL0Parser}.
 */
public interface PL0Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PL0Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PL0Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PL0Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#program_header}.
	 * @param ctx the parse tree
	 */
	void enterProgram_header(PL0Parser.Program_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#program_header}.
	 * @param ctx the parse tree
	 */
	void exitProgram_header(PL0Parser.Program_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PL0Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PL0Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#const_stat}.
	 * @param ctx the parse tree
	 */
	void enterConst_stat(PL0Parser.Const_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#const_stat}.
	 * @param ctx the parse tree
	 */
	void exitConst_stat(PL0Parser.Const_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#const_def}.
	 * @param ctx the parse tree
	 */
	void enterConst_def(PL0Parser.Const_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#const_def}.
	 * @param ctx the parse tree
	 */
	void exitConst_def(PL0Parser.Const_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#var_stat}.
	 * @param ctx the parse tree
	 */
	void enterVar_stat(PL0Parser.Var_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#var_stat}.
	 * @param ctx the parse tree
	 */
	void exitVar_stat(PL0Parser.Var_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PL0Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PL0Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#emptystmt}.
	 * @param ctx the parse tree
	 */
	void enterEmptystmt(PL0Parser.EmptystmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#emptystmt}.
	 * @param ctx the parse tree
	 */
	void exitEmptystmt(PL0Parser.EmptystmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#assignstmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignstmt(PL0Parser.AssignstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#assignstmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignstmt(PL0Parser.AssignstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#beginstmt}.
	 * @param ctx the parse tree
	 */
	void enterBeginstmt(PL0Parser.BeginstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#beginstmt}.
	 * @param ctx the parse tree
	 */
	void exitBeginstmt(PL0Parser.BeginstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(PL0Parser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(PL0Parser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(PL0Parser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(PL0Parser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void enterWhilestmt(PL0Parser.WhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void exitWhilestmt(PL0Parser.WhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PL0Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PL0Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#optionalSign}.
	 * @param ctx the parse tree
	 */
	void enterOptionalSign(PL0Parser.OptionalSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#optionalSign}.
	 * @param ctx the parse tree
	 */
	void exitOptionalSign(PL0Parser.OptionalSignContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#addOperator}.
	 * @param ctx the parse tree
	 */
	void enterAddOperator(PL0Parser.AddOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#addOperator}.
	 * @param ctx the parse tree
	 */
	void exitAddOperator(PL0Parser.AddOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#multiplyOperator}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyOperator(PL0Parser.MultiplyOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#multiplyOperator}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyOperator(PL0Parser.MultiplyOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(PL0Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(PL0Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(PL0Parser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(PL0Parser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(PL0Parser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(PL0Parser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(PL0Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(PL0Parser.NumberContext ctx);
}