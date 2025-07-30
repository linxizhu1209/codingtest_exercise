
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            sum = Integer.MIN_VALUE;
            String str = br.readLine();
            int n = isPalindrome(str);
            System.out.println(n +" " + sum);
        }
    }

    static private int isPalindrome(String str){
        return recursion(str, 0, str.length()-1, 1);
    }

    static private int recursion(String str, int l, int r, int count){
        sum = Math.max(count, sum);
        if(l>=r) return 1;
        else if(str.charAt(l) != str.charAt(r)) return 0;
        else return recursion(str, l+1, r-1, count+1);
    }
 }
