import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /**
     * 24 18
     * 최대공약수 최소공배수
     */
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int nm = n*m;
        int maxk = 0; // 최대공약수
        int mink = 0; // 최소공배수
        while (m!=0){
            int tempM = m;
            m = n%m;
            n = tempM;
        }
        maxk = n;
        mink = nm/maxk;

        System.out.println(maxk);
        System.out.println(mink);
    }

 }
