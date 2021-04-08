package mnnrprojct;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class MNNR {

    private static CharSequence taken;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        System.out.println ("Enter the name of File : ");
        String token;
        Scanner inputCode;
        String Filename;
        Filename = input.nextLine();
        String tokenName = null;
        int line = 1;
        try{
            inputCode = new Scanner(new File(Filename));
            while (inputCode.hasNext()) {
                token = inputCode.next();
                if ("int".equals(token) || "float".equals(token) ||"for".equals(token)|| "String".equals(token)
                        || "chr".equals(token)|| "public".equals(token) || "private".equals(token)|| "while".equals(token)
                    || "void".equals(token)|| "static".equals(token) || "null".equals(token) || "class".equals(token) ) {
                    tokenName = " is keyword";
                    
                }
                else if ("=".contains(token)) {
                    tokenName = " is assignment";
                }
                else if ("==".contains(token) || "||".contains(token)||"&&".contains(token)
                        || "!=".contains(token)||"<=".contains(token)||">=".contains(token) ||"+=".contains(token)) {
                    tokenName = " is comparison";
                } 
                 else if ("math.cos".contains(token)||"math.sin".contains(token)
                         ||"sqrt".contains(token)||"math.power".contains(token)||"*".contains(token)||
                  "/".contains(token)||"+".contains(token)||"-".contains(token)||"%".contains(token)){
                    tokenName = " is operator";
                } 
                else if ("{".contains(token)) {
                    tokenName = " is open bracket";
                } 
                else if ("}".contains(token)) {
                    tokenName = " is closed braket";
                } 
                else if ("(".contains(token)) {
                    tokenName = " is open paren";
                } 
                else if (")".contains(token)) {
                    tokenName = " is closed paren";
                } 
                else if (";".contains(token)) {
                    tokenName = " is semicolon";
                }
                else if (Pattern.matches("[[*][_a-z A-Z 0-5]+]", token)) {
                    tokenName = " is Identifier";
                }
                else if (Pattern.matches("[0-9]+", token)) {
                    tokenName = " is integer number";
                }
                else if (Pattern.matches("[0-9]+[.][0-9]+", token)) {
                    tokenName = " is float number";
                }
                else {
                    System.out.print("Error!! We did not recognize the token in line :" 
                            + line +" in this word --> "+"(" +token+")...");
                    
                } 
                
                System.out.println("(" + token +")"+ "*****" +"("+ tokenName +")");
                if (token.endsWith(";")) {
                    line++;
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File code not found !!");
        }
    }//C:\Users\USER\Desktop\mnnr.txt
}
