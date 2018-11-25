import java.io.*;
import java.util.*;

public class Jewels{
	public static void main(String args[]) {
		Stones stones = new Stones();
		System.out.println(stones.numJewelsInStones("aA", "aaaAAhjfbdaA"));
		System.out.println(stones.numJewelsInStones("z", "ZZZAAAkjgsdfesyVCC"));
		System.out.println(stones.numJewelsInStones("op", "jkdsfjsdhfpoywaddsobjesujdxkp"));
	}
}

class Stones {
	public int numJewelsInStones(String J, String S) {
		char[] jChars = J.toCharArray();
		char[] sChars = S.toCharArray();
		int count = 0;

		for(int i = 0; i < jChars.length; i++) {
			for(int j = 0; j < sChars.length; j++) {
				if(jChars[i] == sChars[j]) {
					count++;
				}
			}
		}

		return count;
	}
}