import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int cola = Integer.parseInt(token.nextToken());
        int beer = Integer.parseInt(token.nextToken());
        int sum = cola/2 + beer;
        if(sum>n) System.out.println(n);
        else System.out.println(sum);
    }
}