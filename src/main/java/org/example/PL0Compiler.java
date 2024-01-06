package org.example;

import antlr.PL0.PL0BaseVisitor;
import antlr.PL0.PL0Lexer;
import antlr.PL0.PL0Parser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PL0Compiler {


    public static void main(String[] args) throws Exception {
        // 读取 PL0 源代码文件
        ANTLRInputStream input = new ANTLRFileStream("E:\\软件学院\\编译原理\\期末项目\\PL0-compiler\\src\\examples\\example1.txt");

        // 创建词法分析器
        PL0Lexer lexer = new PL0Lexer(input);

        // 创建词法记号流
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        tokenStream.fill();

//        //输出词法分析结果
//        for (Token token : tokenStream.getTokens()) {
//            System.out.println(token);
//        }

        PL0Parser parser = new PL0Parser(tokenStream);
                parser.setBuildParseTree(true);
        PL0Parser.ProgramContext tree = parser.program();
        PL0BaseVisitor<String> visitor = new PL0VisitorImpl();
        visitor.visit(tree);
        System.out.println("======The intermediatecode is as follows======");
        // 创建控制台输出的 PrintWriter
        PrintWriter consoleWriter = new PrintWriter(System.out);
        // 创建保存到文件的 PrintWriter
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter("src/result/output.txt"))) {
            // 调用你的方法，同时输出到控制台和文件
            ((PL0VisitorImpl<String>) visitor).printIntermediateCode(consoleWriter);
            ((PL0VisitorImpl<String>) visitor).printIntermediateCode(fileWriter);
            // 手动刷新缓冲区，确保内容被写入到控制台
            consoleWriter.flush();
            System.out.println();
            System.out.println("Intermediate code has been saved to 'output.txt'");
        } catch (IOException e) {
            e.printStackTrace(); // 处理文件写入异常
        }
        System.out.println("======The varMap is as follows======");
        ((PL0VisitorImpl<String>) visitor).printVarMap();
        System.out.println("======The constMap is as follows======");
        ((PL0VisitorImpl<String>) visitor).printConstMap();



    }
}





