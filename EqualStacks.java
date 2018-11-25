import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class EqualStacks {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */

         int[] a1 = getAddedArray(h1);
         int[] a2 = getAddedArray(h2);
         int[] a3 = getAddedArray(h3);
        
        for(int i = 0; i < a1.length; i++) {
            boolean a2Exists = false;
            boolean a3Exists = false;

            for(int j = 0; j < a2.length; j++) {
                if(a1[i] == a2[j]) {
                    a2Exists = true;
                }
            }

            for(int k = 0; k < a3.length; k++) {
                if(a1[i] == a3[k]) {
                    a3Exists = true;
                }
            }

            if(a2Exists && a3Exists) {
                return a1[i];
            }
        }

        return 0;
    }

    public static int[] getAddedArray(int[] a) {
        int[] result = new int[a.length];
        int sum = 0;
        for(int i = a.length - 1; i >= 0; i--) {
            sum += a[i];
            result[a.length - (i + 1)] = sum;  
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        System.out.println(String.valueOf(result));
        
    }
}
