//ملاحظه : مروة بتمسك جزئية الفايل 
package mnnrprojct;

import java.util.regex.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MNNR {
    
    public static void main(String[] args) {
        Scanner();
    }
    
    static String identiferRegularExperssion = "[*][_a-zA-Z0-5]+";
    static String digit = "[0-5]+";
    static String comment = "[$$][a-z0-5]+";
    static String Output="#[a-zA-Z]+#";
   
    static String token;
    static Scanner inputCode;
    //نبغى نغيره ونخليه من اليوزر 
    static String Filename = "ErrorTrueCode.txt";
  //نقول استخدمنا لينكد ليست 
    static List keywords = new LinkedList();
    static List symbols = new LinkedList();
    static List Operation = new LinkedList();
    static List logialOP = new LinkedList();
    public static void Scanner() {
        
        keywords.add("IF");keywords.add("Else");keywords.add("ElseIF");
        keywords.add("For");keywords.add("While");
        //انه دي ريتيرن 
        keywords.add("Back");
        //انها هاذي ببلك
        keywords.add("pub");
        //هاذي هيا نفسها برايفت
        keywords.add("Secret");
        keywords.add("short");keywords.add("double");keywords.add("float");
        keywords.add("static");/*const*/keywords.add("constant");keywords.add("char");
        keywords.add("boolean");keywords.add("class");keywords.add("void");keywords.add("this"); 
        keywords.add("true");keywords.add("println");keywords.add("null");
        keywords.add("NAD");keywords.add("ITANA");keywords.add("MARWS");keywords.add("RTOJ");
        //يمدينا نعدل عليها بشكل واضح
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
        //تربيع
        Operation.add("^");
        //سيقما
        Operation.add("&");
        //-100من كل رقم 
        Operation.add("!");
        Operation.add("-");
        //تعطيني ارقام عشريه
        Operation.add("%");
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
                    //ممكن نعدل على المتغير عليها بحيث تنكتب بطريقه تانيه
                    tokenCategory = "keyword";
                } else if (symbols.contains(token)) {
                    tokenCategory = "this Symbol";
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
                System.out.println("(" + token +")"+ "*****" +"("+ tokenCategory + ")");
                if (token.endsWith(";")) {
                    line++;
                }
            }

        } 
        catch (FileNotFoundException ex) {
            //قابل للتعديل نقول الكلام انه مالقى الملف وكالام
            System.out.println("File code not found !!");
        }
    }
}
