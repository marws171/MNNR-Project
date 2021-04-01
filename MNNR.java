
package mnnrprojct;

import java.util.regex.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MNNR {
    
    public static void main(String[] args) {
        Scanner();
    }
    
    static String identiferRegularExperssion = "[_][0-9][_a-zA-Z]+";
    static String digit = "[0-9]+";
    static String comment = "[/][*][_a-zA-Z]+";
    static String Output="\'[a-zA-Z]+\'";
    
    static String token;
    static Scanner inputCode;
    //نبغى نغيره ونخليه من اليوزر 
    static String Filename = "ErrorTrueCode.txt";
  
    static List keywords = new ArrayList();
    static List symbols = new ArrayList();
    static List Operation = new ArrayList();
    static List logialOP = new ArrayList();

    public static void Scanner() {
        
        keywords.add("if");keywords.add("else");keywords.add("elseif");
        keywords.add("for");keywords.add("while");keywords.add("do");
        keywords.add("return");keywords.add("public");keywords.add("privet");
        keywords.add("protect");keywords.add("package");keywords.add("new");
        keywords.add("int");keywords.add("double");keywords.add("float");
        keywords.add("static");keywords.add("const");keywords.add("char");
        keywords.add("goto");keywords.add("boolean");keywords.add("long");
        keywords.add("void");keywords.add("this");keywords.add("try");
        keywords.add("catch");keywords.add("true");keywords.add("print");
        keywords.add("enter");
        
        
        symbols.add("!");symbols.add('&');symbols.add('^');symbols.add('%');
        symbols.add('$');symbols.add('#');symbols.add('@');symbols.add('?');
        symbols.add('~');
        symbols.add("(*"); //begin the condition
        symbols.add("*)"); //end the condition 
        symbols.add("{*"); //begin the loop
        symbols.add("*}"); //end for loop
        symbols.add(";");
        symbols.add("'"); //use to print
       
        Operation.add("+");
        Operation.add("-");
        Operation.add("*");
        Operation.add("/");
        Operation.add("=");

        logialOP.add("||");
        logialOP.add("&&");
        logialOP.add("==");
        logialOP.add("<=");
        logialOP.add(">=");
        logialOP.add(">");
        logialOP.add("<");

        String tokenCategory;
        int line = 1;
        try {
            inputCode = new Scanner(new File(Filename));
            while (inputCode.hasNext()) {
                token = inputCode.next();
                if (keywords.contains(token)) {
                    tokenCategory = "keyword";
                } else if (symbols.contains(token)) {
                    tokenCategory = "Symbol";
                } else if (Operation.contains(token)) {
                    tokenCategory = "operation";
                } else if (logialOP.contains(token)) {
                    tokenCategory = "Logical Operation";
                } else if (Pattern.matches(identiferRegularExperssion, token)) {
                    tokenCategory = "identifire";
                } else if (Pattern.matches(comment, token)) {
                    tokenCategory = "comment";
                } else if (Pattern.matches(digit, token)) {
                    tokenCategory = "digit";
                } else if (Pattern.matches(Output, token)) {
                    tokenCategory = "Output to the user";
                } else {
                    tokenCategory = "there an error in token !!! in line :" + line;
                }
                System.out.println("<" + token + "," + tokenCategory + ">");
                if (token.endsWith(";")) {
                    line++;
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File code not found !!");
        }
    }
}
