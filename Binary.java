import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Binary {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int m = n;
        int bin[] = null;
        if(m > 1) {
            while (m > 0) {
                boolean found = false;
                for(int i = 1; i < m; i++) {
                    if(((int)Math.pow(2, i)) > m) {
                        System.out.println("if 1 : i = " + i + " m = " + m);
                        if(bin == null) {
                            bin = new int[i];    
                        }
                        bin[(bin.length - 1) -(i - 1)] = 1;
                        m = m - (i - 1);
                        found = true;
                        break;
                    }
                        
                    if(((int)Math.pow(2, i)) == m) {
                        System.out.println("if 2 : i = " + i + " m = " + m);
                        if(bin == null) {
                            bin = new int[i + 1];    
                        }
                        bin[(bin.length - 1) - i] = 1;
                        m = m - (i);
                        found = true;
                        break;
                    } 
                }
                if(!found) {
                    m = 0;    
                }
            }    
        } else {
            bin = new int[1];
            bin[0] = m;
        }
        
        
        for(int i = 0; i < bin.length; i++) {
            System.out.print(bin[i]);
        }
        
        scanner.close();
    }
}
