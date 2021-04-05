//ملاحظه : مروة بتمسك جزئية الفايل 
package mnnrprojct;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class MNNR {
    
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
                if (token.equals("int") || token.equals("float") || token.equals("for") 
                        || token.equals("chr") || token.equals("while") || token.equals("void") 
                        || token.equals("static") || token.equals("null") || token.equals("class")) {
                    tokenName = " is keyword";
                }
                else if ("=".contains(token)) {
                    tokenName = " is assignment";
                }
                else if ("==".contains(token) || "||".contains(token)||"&&".contains(token) 
                         || "!=".contains(token)"<=".contains(token) ||">=".contains(token)) {
                    tokenName = " is comparison";
                } 
                 Else if ("math.cos".contains(token)||"math.sin".contains(token)||"sqrt".contains(taken)||"math.power".contains(taken)||"*".contains(taken)||
                  "/".contains(taken)||"+".contains(taken)||"-".contains(taken)||"%".contains(taken)){
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
                else if (Pattern.matches("[[*][_a-zA-Z0-5]+]", token)) {
                    tokenName = " is Identitier";
                }
                else if (Pattern.matches("[0-9]+", token)) {
                    tokenName = " is integer number";
                }
                else if (Pattern.matches("[0-9]+[.][0-9]+", token)) {
                    tokenName = " is float number";
                }
                else {
                    System.out.print("there an error in token !!! in line :" + line);
                }
                System.out.println("(" + token +")"+ "*****" +"("+ tokenName +")");
                if (token.endsWith(";")) {
                    line++;
                }
            }
            
        }catch(FileNotFoundException e){
            System.out.println("File code not found !!");
        }
    }
      
}
