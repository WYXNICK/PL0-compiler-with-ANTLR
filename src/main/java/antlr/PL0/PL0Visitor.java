// Generated from E:/软件学院/编译原理/期末项目/PL0-compiler/src/grammar/PL0.g4 by ANTLR 4.13.1
package antlr.PL0;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PL0Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PL0Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PL0Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PL0Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#program_header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_header(PL0Parser.Program_headerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PL0Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#const_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_stat(PL0Parser.Const_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#const_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_def(PL0Parser.Const_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#var_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_stat(PL0Parser.Var_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PL0Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#emptystmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptystmt(PL0Parser.EmptystmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#assignstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignstmt(PL0Parser.AssignstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#beginstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginstmt(PL0Parser.BeginstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(PL0Parser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(PL0Parser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#whilestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestmt(PL0Parser.WhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PL0Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#optionalSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalSign(PL0Parser.OptionalSignContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#addOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOperator(PL0Parser.AddOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#multiplyOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyOperator(PL0Parser.MultiplyOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(PL0Parser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(PL0Parser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(PL0Parser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(PL0Parser.NumberContext ctx);
}