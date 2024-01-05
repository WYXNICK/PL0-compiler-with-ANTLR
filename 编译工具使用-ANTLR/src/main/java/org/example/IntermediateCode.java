package org.example;

import java.io.PrintWriter;

/**
 * @author wyx20
 * @version 1.0
 * @title IntermediateCode
 * @description
 * @create 2024/1/3 11:10
 */
//中间代码数据结构
public class IntermediateCode {
    private Integer address;
    private String operator;
    private String operand1;
    private String operand2;
    private String result;

    public IntermediateCode() {
        this.address=0;
        this.operator="";
        this.operand1="";
        this.operand2="";
        this.result="";
    }

    public IntermediateCode(Integer address, String operator, String operand1, String operand2, String result) {
        this.address = address;
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }

    //生成格式化代码
    public String generateFormatCode(){
        String formatCode=this.address+": "+String.format("(%s, %s, %s, %s)", this.operator, this.operand1, this.operand2, this.result);
        return formatCode;
    }

    //打印中间代码
    public void printFormatCode(PrintWriter writer){
        writer.println(generateFormatCode());
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getAddress() {
        return address;
    }

    public String getOperator() {
        return operator;
    }

    public String getOperand1() {
        return operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public String getResult() {
        return result;
    }
}
