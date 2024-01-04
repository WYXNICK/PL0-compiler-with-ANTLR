package org.example;

import antlr.PL0.PL0BaseVisitor;
import antlr.PL0.PL0Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wyx20
 * @version 1.0
 * @title PL0VisitorImpl
 * @description
 * @create 2023/12/11 17:02
 */


public class PL0VisitorImpl<T> extends PL0BaseVisitor<T> {
    private List<IntermediateCode> codeList;
    //临时变量名
    private String tempVar;
    //中间代码地址
    private int addressCount;
    private boolean stopTraversal;

    //变量Map
    Map<String,String> varMap = new HashMap<>();

    //常量Map，声明时赋值，不能再次赋值
    Map<String,String> constMap = new HashMap<>();

    public PL0VisitorImpl() {
        this.codeList =new ArrayList<>();
        this.tempVar = null;
        this.addressCount=100;
        this.stopTraversal=false;
    }


    //更新临时变量名
    public String updateTempVar() {
        if(this.tempVar==null){
            this.tempVar="t0";
            return this.tempVar;
        }
        Pattern pattern = Pattern.compile("(t)(\\d+)");
        Matcher matcher = pattern.matcher(tempVar);

        if (matcher.find()) {
            String prefix = matcher.group(1);
            int currentNumber = Integer.parseInt(matcher.group(2));
            int nextNumber = currentNumber + 1;
            this.tempVar = prefix + nextNumber;
        }
        return this.tempVar;
    }

    @Override
    public T visitStatement(PL0Parser.StatementContext ctx){
        if (stopTraversal) {
            return null;  // 结束遍历
        }
        PL0Parser.BeginstmtContext beginstmt=ctx.beginstmt();
        PL0Parser.AssignstmtContext assignstmt=ctx.assignstmt();
        PL0Parser.IfstmtContext ifstmt=ctx.ifstmt();
        PL0Parser.WhilestmtContext whilestmt=ctx.whilestmt();
        PL0Parser.EmptystmtContext emptystmt=ctx.emptystmt();
        if(beginstmt!=null)
            visitBeginstmt(beginstmt);
        else if(assignstmt!=null)
            visitAssignstmt(assignstmt);
        else if(ifstmt!=null)
            visitIfstmt(ifstmt);
        else if(whilestmt!=null)
            visitWhilestmt(whilestmt);
        return null;
    }

    @Override
    public T visitBeginstmt(PL0Parser.BeginstmtContext ctx){
        if (stopTraversal) {
            return null;  // 结束遍历
        }
        List<PL0Parser.StatementContext> statementList=ctx.statement();

        for(PL0Parser.StatementContext statement : statementList){
            visitStatement(statement);
        }
        return null;
    }



    //变量声明
    @Override
    public T visitVar_stat(PL0Parser.Var_statContext ctx){
        if (stopTraversal) {
            return null;  // 结束遍历
        }
        for(PL0Parser.IdentContext identContext : ctx.ident()){
            if(constMap.containsKey(identContext.getText())){
                // 获取错误位置的 Token 对象
                Token errorToken = identContext.getStart();
                // 输出错误提示到标准错误流，包含行号和字符位置信息
                System.err.println("Error at line " + errorToken.getLine() + ", position " +
                        errorToken.getCharPositionInLine() + ": Constant " + identContext.getText() + " is already defined.");
                this.stopTraversal=true;
                return null;
            }
            else if(varMap.containsKey(identContext.getText())){
                // 获取错误位置的 Token 对象
                Token errorToken = identContext.getStart();
                // 输出错误提示到标准错误流，包含行号和字符位置信息
                System.err.println("Error at line " + errorToken.getLine() + ", position " +
                        errorToken.getCharPositionInLine() + ": Variable " + identContext.getText() + " is already defined.");
                this.stopTraversal=true;
                return null;
            }
            varMap.put(identContext.getText(),null);
        }
        return null;
    }

    @Override
    public T visitConst_stat(PL0Parser.Const_statContext ctx){
        if (stopTraversal) {
            return null;  // 结束遍历
        }
        List<PL0Parser.Const_defContext> constDefContexts=ctx.const_def();
        for(PL0Parser.Const_defContext constDefContext : constDefContexts){
            visitConst_def(constDefContext);
        }
        return null;
    }

    @Override
    public T visitConst_def(PL0Parser.Const_defContext ctx){
        if (stopTraversal) {
            return null;  // 结束遍历
        }
        PL0Parser.IdentContext ident=ctx.ident();
        PL0Parser.NumberContext number=ctx.number();
        if(constMap.containsKey(ctx.ident())){
            // 输出错误提示到标准错误流
            System.err.println("Error: Constant "+ ctx.ident().getText()+ " is already defined.");
            this.stopTraversal=false;
            return null;
        }
        generateCode(":=", number.getText(), "_", ident.getText());
        //加入常量Map
        constMap.put(ident.getText(),number.getText());
        return null;
    }

    @Override
    public T visitAssignstmt(PL0Parser.AssignstmtContext ctx) {
        if (stopTraversal) {
            return null;  // 结束遍历
        }
        String target = ctx.ident().getText();
        T expression = this.visitExpression(ctx.expression());
        //检测是否属于常量重复赋值和未定义变量赋值，如果是则提示出错
        if(constMap.containsKey(target)){
            // 获取错误位置的 Token 对象
            Token errorToken = ctx.ident().getStart();
            // 输出错误提示到标准错误流，包含行号和字符位置信息
            System.err.println("Error at line " + errorToken.getLine() + ", position " +
                    errorToken.getCharPositionInLine() + ": Constant " + target + " cannot be reassigned.");
            this.stopTraversal=true;
            return null;
        }
        else if(!varMap.containsKey(target)){
            // 获取错误位置的 Token 对象
            Token errorToken = ctx.ident().getStart();
            // 输出错误提示到标准错误流，包含行号和字符位置信息
            System.err.println("Error at line " + errorToken.getLine() + ", position " +
                    errorToken.getCharPositionInLine() + ": Using undefined variable " + target);
            this.stopTraversal=true;
            return null;
        }
        //生成赋值语句中间代码
        generateCode(":=", (String) expression, "_", target);
        //添加值到varMap中
        varMap.put(target, (String) expression);
        return null;
    }

    @Override
    public T visitExpression(PL0Parser.ExpressionContext ctx){
        if (stopTraversal) {
            return null;  // 结束遍历
        }
        //获取term列表
        List<PL0Parser.TermContext> termList=ctx.term();

        //获取加法运算符列表
        List<PL0Parser.AddOperatorContext> oprList=ctx.addOperator();

        //若为纯数字或变量(无加减法运算)
        if(oprList.isEmpty()){
            if(!ctx.optionalSign().getText().equals("")){
                generateCode(ctx.optionalSign().getText(),(String) visitTerm(termList.get(0)),"_",updateTempVar());
            }
            else {
                return visitTerm(termList.get(0));
            }
        }
        else{
            for(int i=0;i< termList.size()-1;i++){
                if(i==0){
                    //判断是否含有前置可选+、-
                    if(!ctx.optionalSign().getText().equals(""))
                        generateCode(ctx.optionalSign().getText(),(String) visitTerm(termList.get(i)),"_",updateTempVar());
                    else
                        generateCode(oprList.get(i).getText(),(String) visitTerm(termList.get(i)),(String)visitTerm(termList.get(i+1)),updateTempVar());
                }
                else {
                    generateCode(oprList.get(i).getText(),this.tempVar,(String)visitTerm(termList.get(i+1)),updateTempVar());
                }
            }

        }
        return (T) this.tempVar;
    }

    @Override
    public T visitTerm(PL0Parser.TermContext ctx){
        if (stopTraversal) {
            return null;  // 结束遍历
        }
        List<PL0Parser.FactorContext> factorList=ctx.factor();
        List<PL0Parser.MultiplyOperatorContext> multiplyList=ctx.multiplyOperator();
        if(multiplyList.isEmpty()){
            return (T) visitFactor(factorList.get(0));
        }
        else{
            for(int i=0;i< factorList.size()-1;i++){
                if(i==0){
                    //判断是否为首项（不需要使用tempVar)
                    generateCode(multiplyList.get(i).getText(),(String) visitFactor(factorList.get(i)),(String)visitFactor(factorList.get(i+1)),updateTempVar());
                }
                else {
                    generateCode(multiplyList.get(i).getText(),this.tempVar,(String)visitFactor(factorList.get(i+1)),updateTempVar());
                }
            }
        }

        return (T) this.tempVar;
    }

    @Override
    public T visitFactor(PL0Parser.FactorContext ctx) {
        if (stopTraversal) {
            return null;  // 结束遍历
        }
        if(ctx.ident()!=null&&varMap.containsKey(ctx.getText())&&varMap.get(ctx.getText())==null){
            // 输出错误提示到标准错误流，包含行号和字符位置信息
            Token errorToken = ctx.getStart();
            System.err.println("Error at line " + errorToken.getLine() + ", position " + errorToken.getCharPositionInLine() +
                    ": Using unassigned variable: " + ctx.getText());
            this.stopTraversal=true;
            return null;
       }
        else if(ctx.ident()!=null&&!varMap.containsKey(ctx.ident().getText())){
            // 输出错误提示到标准错误流，包含行号和字符位置信息
            Token errorToken = ctx.getStart();
            System.err.println("Error at line " + errorToken.getLine() + ", position " + errorToken.getCharPositionInLine() +
                    ": Using undefined variable: " + ctx.getText());
            this.stopTraversal=true;
            return null;
        }
        return (T) ctx.getText();
    }

    @Override
    public T visitIfstmt(PL0Parser.IfstmtContext ctx){
        if (stopTraversal) {
            return null;  // 结束遍历
        }
        PL0Parser.ConditionContext condition = ctx.condition();
        PL0Parser.StatementContext statement = ctx.statement();
        visitCondition(condition);
        //不满足if条件的,先生成地址，等待回填
        int tempAddress=addressCount;
        //该中间代码已经生成，等待回填
        this.addressCount++;
        //条件满足时执行下面的语句(访问statement)
        visitStatement(statement);
        generateCode(tempAddress,"j","_","_",Integer.toString(this.addressCount));
        return null;
    }

    @Override
    public T visitCondition(PL0Parser.ConditionContext ctx){
        if (stopTraversal) {
            return null;  // 结束遍历
        }
        List<PL0Parser.ExpressionContext> expressionList=ctx.expression();
        generateCode("j"+ctx.RELATIONAL_OPERATOR().getText(),(String) visitExpression(expressionList.get(0)),(String) visitExpression(expressionList.get(1)),Integer.toString(this.addressCount+2));
        return null;
    }

    @Override
    public T visitWhilestmt(PL0Parser.WhilestmtContext ctx){
        if (stopTraversal) {
            return null;  // 结束遍历
        }
        PL0Parser.ConditionContext condition = ctx.condition();
        PL0Parser.StatementContext statement = ctx.statement();
        int conditionAddress=this.addressCount;
        visitCondition(condition);
        //不满足while条件的,先生成地址，等待回填
        int tempAddress=addressCount;
        //该中间代码已经生成，等待回填
        this.addressCount++;
        //条件满足时执行下面的语句(访问statement)
        visitStatement(statement);
        //进入循环，跳到condition判断处
        generateCode("j","_","_",Integer.toString(conditionAddress));
        generateCode(tempAddress,"j","_","_",Integer.toString(this.addressCount));
        return null;
    }


    public String generateCode(int address,String operator, String operand1, String operand2, String result){
        //回填操作，需要用到之前生成的地址，不需要addressCount+1
        IntermediateCode code=new IntermediateCode(address,operator,operand1,operand2,result);
        this.codeList.add(code);
        return code.generateFormatCode();

    }

    public String generateCode(String operator, String operand1, String operand2, String result){
        //正常语句，不需要用到之前地址
        IntermediateCode code=new IntermediateCode(this.addressCount,operator,operand1,operand2,result);
        this.codeList.add(code);
        this.addressCount++;
        return code.generateFormatCode();

    }


    public String printIntermediateCode(PrintWriter writer){
        Collections.sort(codeList, Comparator.comparing(IntermediateCode::getAddress));
        StringBuilder intermediateCode = new StringBuilder();

        for(IntermediateCode code : this.codeList){
            code.printFormatCode(writer);
            intermediateCode.append(code.generateFormatCode()+"\n");
        }
        return intermediateCode.toString();
    }

    public void printVarMap(){
        for (Map.Entry<String, String> entry : varMap.entrySet()) {
            System.out.println("Var: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

}






