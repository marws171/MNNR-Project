
package mnnrprojct;
import java.util.Scanner;

public class testProjct {
    public static void main (String [] args) {
    Scanner scan = new Scanner (System.in);
    System.out.println ("Enter number of lines : ");
    String[] input = new String [scan.nextInt ()];
    scan.nextLine ();
    String inp = " ";
    System.out.println ("\n Please Enter your program : ");
    for (int i = 0;i <input.length; i ++)
    { 
        input [i] = scan.nextLine ();
        inp = inp.concat (input [i] + " ");
    }
    
    System.out.println ("\n input lines are:");
    String output[] = inp.split (" ");
    for (String out: output)
    {
        System.out.print (" " + out);
    }
    System.out.println (" ");
    int id = 0;
    int token = 0;
    for (int i = 0; i <output.length; i ++)
    {
        if (null != output [i])
        {
            switch(output[i])
            {
                case "String": case "int": case "float":
                case "double":case "boolean": case "for":
                case "class": case "chr": case "while":
                case "void": case "null": case "static":
                    token ++;
                    System.out.println ("< keyword," + output [i] + ">");
                    break;
                case "$$": 
                    token ++;
                    System.out.println ("< comment," + output [i] + ">");   
                case "{": 
                    token ++;
                    System.out.println ("< open bracket," + output [i] + ">");
                case "}":
                    token ++;
                    System.out.println ("< closed braket," + output [i] + ">");
                case "(": 
                    token ++;
                    System.out.println ("< open paren," + output [i] + ">");
                case ")":
                    token ++;
                    System.out.println ("< closed paren," + output [i] + ">");
                case ";":
                    token ++;
                    System.out.println ("< semicolon (EndoStatement)," + output [i]+ ">");
                    break;
                case ",":
                    System.out.println ("< colon," + output [i]+ ">");
                    break;
                case "a": case "b":case "c":case "d":case "e":case "f": case "g":case "h":   
                case "i":case "j":case "k": case "l": case "m": case "n": case "r":case "p":
                case "q":case "s":case "t": case "u":case "v": case "w":case "x":case "y": case "z":
                case "A": case "B":case "C":case "D":case "E":case "F": case "G":case "H":   
                case "I":case "J":case "K": case "L": case "M": case "N": case "R":case "P":
                case "Q":case "S":case "T": case "U":case "V": case "W":case "X":case "Y": case "Z":
                    token++;
                    id++;
                    System.out.println ("< identifer," + output [i]+ ">");
                    break;
                case " ":
                    System.out.println (" ");
                    break;
                case "1":case "2":case "3":case "4":case "5":case "6": case "7":case "8":case "9":
                    token++;
                    System.out.println ("< number, "+ output [i]+ ">");
                    break;
                case "+": case "-": case "*": case "/": case "%": case "=":
                case "==":case "<": case ">": case "&": case "&&": case "||":
                    token++;
                    System.out.println ("< Operator, "+ output [i]+ ">");
                    break;
                default:
                    System.out.println ("there an error in token !!!" + output [i]);
            }
        }
    }
    System.out.println ("\n Total nmbers of tokens in your program: " + token);
                    
    }
}
      