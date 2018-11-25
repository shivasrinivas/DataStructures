import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalencedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        char[] brackets = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < brackets.length; i++) {
            if(brackets[i] == '(' || brackets[i] == '[' || brackets[i] == '{') {
                stack.push(brackets[i]);
            } else {
                if(stack.size() == 0) {
                    return "NO";
                }
                char current = stack.peek();
                if(getBracket(current) == brackets[i]) {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static char getBracket(char openBracket) {
        switch(openBracket) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
        }
        return ' ';
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }

        scanner.close();
    }
}
