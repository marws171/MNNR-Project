import java.util.LinkedList;
import java.util.Scanner;
public class KMP2 {
    
    public static int[] PrefixLen(String pattern) {
        
        int patternsize = pattern.length();
        int[] array = new int[patternsize + 1];
        array[0] = -1;
        array[1] = 0;
        int prefixLength = 0;
        int indx = 1;
        while (indx < patternsize) {
            if (pattern.charAt(prefixLength) == pattern.charAt(indx)) {
                prefixLength++;
                indx++;
                array[indx] = prefixLength;
            } else if (prefixLength > 0) {
                prefixLength = array[prefixLength];
            } else {
                indx++;
                array[indx] = 0; 
            }
        }
        return array;
    }
    public static LinkedList<Integer> KMPOF(String text, String pattern) {
        int i = 0;
        int j = 0;
        int i_Length = text.length();
        int j_Length = pattern.length();
        LinkedList<Integer> matching = new LinkedList<>();
        int[] prefixLen = PrefixLen(pattern);
        while (i < i_Length) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
                if (j == j_Length) {
                    System.out.println("The pattern at index " + "< " +(i - j)+" >");
                    matching.add(i-j);
                    j = prefixLen[j]; 
                }
            } else {
                j = prefixLen[j];
                if (j < 0) {
                    i++;
                    j++;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        String text ;
        String pattern ;
        Scanner input = new Scanner(System.in);
        System.out.println ("Enter the text please : ");
        text = input.nextLine();
        System.out.println ("Enter the pattern please : ");
        pattern = input.nextLine();
        System.out.println("text = "+"( "+ text +" )");
        System.out.println("pattern = " +"( "+ pattern+" )");
        KMPOF(text, pattern);
	}
}
//runing time is O( m + n )
/*
text = abcbaccbaacbbcbbbbbaacbcaccbacbcbabcbbcbcbabbbbaccbaccbcbcbbcbcbcabababcbcbcbcbcbcbcbcbcbcbababababbaccbabcccabaaabbacbcbcbabacbacbaccbcaccbabbcabbcbacbbacbabbacbababbcbcbabbcababbacbbabcbabcabbcabcabbcabbacbbcabcabcabbabbcabcbcbcbabbabbabbabbcbcbacbbcbbcbcbbcbcbababbacbacbbacbbacbacbbacbcbcabcabbacbcabbacbaaccbacbacbacbacb
pattern = accba  */