
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals("0")) break;
            int isPel = pellindrom(str, 0, str.length() - 1);
            if(isPel == 1) System.out.println("yes");
            else System.out.println("no");
        }
    }
    private static int pellindrom(String str, int l, int r) {
        if(str.charAt(l) != str.charAt(r)) {
            return 0;
        }
        if(l>=r) return 1;
        return pellindrom(str, l + 1, r-1);
    }
 }
