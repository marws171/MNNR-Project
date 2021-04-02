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
      static String digit = "[0-5]+";
    static String identiferRegularExperssion = "[*][_a-zA-Z0-5]+";
    static String comment = "[$$][a-z0-5]+";
    static String Output="#[a-zA-Z]+#";
   
    static String token;
    static Scanner inputCode;
    //نبغى نغيره ونخليه من اليوزر 
    static String Filename = "ErrorTrueCode.txt";
  // استخدمنا لينكد ليست 
    static List keywords = new LinkedList();
    static List symbols = new LinkedList();
    static List Operation = new LinkedList();
    static List logialOP = new LinkedList();
    public static void Scanner() {
         //انها هاذي public
        keywords.add("pub");
        //هاذي هيا نفسها private
        keywords.add("Secret");
        keywords.add("IF");keywords.add("Else");keywords.add("ElseIF");
        keywords.add("For");keywords.add("While");/*const*/keywords.add("constant");
        //انه دي return 
        keywords.add("Back");keywords.add("this"); 
        keywords.add("short");keywords.add("double");keywords.add("float");
        keywords.add("static");keywords.add("char");keywords.add("null");
        keywords.add("boolean");keywords.add("class");keywords.add("void");
        keywords.add("true");keywords.add("println");
        keywords.add("NAD");keywords.add("ITANA");keywords.add("MARWS");keywords.add("RTOJ");
        //يمدينا نعدل عليها بشكل واضح
        //بدايه loop
        symbols.add("{.");
        //نهايه loop
        symbols.add(".}"); 
        symbols.add(";");
        //تستخدم ل print
        symbols.add("'"); 
        symbols.add("!");symbols.add('&');
        symbols.add('^');symbols.add('%');
        symbols.add('$');symbols.add('#');
        symbols.add('@');symbols.add('?');
        symbols.add('~');symbols.add("(");
        symbols.add(")"); 
       
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
        //token Category الي بينحفظ فيه النوع كل مره
        String tokenCat;
        //العداد 
        int i = 1;
        try {
            inputCode = new Scanner(new File(Filename));
            while (inputCode.hasNext()) {
                token = inputCode.next();
                if (keywords.contains(token)) {
                    //ممكن نعدل على المتغير عليها بحيث تنكتب بطريقه تانيه
                    tokenCat = "keyword";
                } else if (symbols.contains(token)) {
                    tokenCat = "this Symbol";
                } else if (Operation.contains(token)) 
                    tokenCat = "operation";
                } else if (logialOP.contains(token)) {
                    tokenCat = "Logical Operation";
                } else if (Pattern.matches(identiferRegularExperssion, token)) {
                    tokenCat = "identifire";
                } else if (Pattern.matches(comment, token)) {
                    tokenCat = "comment";
                } else if (Pattern.matches(digit, token)) {
                    tokenCat = "digit";
                } else if (Pattern.matches(Output, token)) {
                    tokenCat = "Output to the user";
                } else {
                    tokenCat = "you have error in token, in this line ::" + i;
                }
                System.out.println("Here is the result of Scanner ->>");
                System.out.println("(" + token +")"+ "*****" +"("+ tokenCat + ")");
                if (token.endsWith(";")) {
                    line++;
                }
            }

        } 
        //في حال عدم العثور على الملف يطلع ذا الارور
        catch (FileNotFoundException ex) {
            //قابل للتعديل نقول الكلام انه مالقى الملف وكالام
            //تم
            System.out.println("I can't found the file code!");
        }
    }
}
