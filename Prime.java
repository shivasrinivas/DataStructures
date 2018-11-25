import java.io.*;
import java.util.*;

public class Prime {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.println(isPrime(scanner.nextInt()));
        }
    }
    
    public static String isPrime(int n) {
        if(n < 2) {
            return "Not prime";
        }
        if(n == 2) {
            return "Prime";
        }
        for(int i = 2; i*i <= n; i++) {
            if(n % i == 0) {
                return "Not prime";
            }
        }
        return "Prime";
    }
}
