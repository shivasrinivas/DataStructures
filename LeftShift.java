import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftShift {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int temp = a[0];
        int previousIndex = 0;
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                a[i] = a[i + d];
                continue;
            }

            int current = a[i];
            
            
        }

        for(int i = 0; i < d; i++) {
            int temp = -1;
            for(int j = 0; j < n; j++) {
                if(j == 0) {
                    temp = a[j];
                    continue;
                } 

                a[j - 1] = a[j];

                if(j == n - 1) {
                    a[j] = temp;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        scanner.close();
    }
}
