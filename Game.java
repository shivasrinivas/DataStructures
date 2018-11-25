import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Game {

    /*
     * Complete the twoStacks function below.
     */
    static int twoStacks(int x, int[] a, int[] b) {
        /*
         * Write your code here.
         */

        int sum = 0;
        int count = 0;

        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        for(int i = a.length - 1; i >= 0; i--) {
            stack1.push(a[i]);
        }

        for(int i = b.length - 1; i >= 0; i--) {
            stack2.push(b[i]);
        }

        while(stack1.size() != 0 || stack2.size() != 0) {
            int value = 0;
            if(stack1.size() == 0) {
                value = stack2.peek();
                stack2.pop();
                System.out.println("pop stack 2");
            } else if(stack2.size() == 0) {
                value = stack1.peek();
                stack1.pop();
                System.out.println("pop stack 1");
            } else {
                int s1 = stack1.peek();
                int s2 = stack2.peek();

                if(s1 > s2) {
                    value = s2;
                    stack2.pop();
                    System.out.println("pop stack 2");
                } else {
                    value = s1;
                    stack1.pop();
                    System.out.println("pop stack 1");
                }
            }
            
            if((sum + value) <= x) {
                sum += value;
                System.out.println("sum = " + sum);
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            System.out.println("\n Answer of " + gItr + " is : " + String.valueOf(result));
            
        }

    }
}
