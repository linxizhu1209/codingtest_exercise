package backjoon.과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BigO {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int a1 = Integer.parseInt(token.nextToken());
        int a0 = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());

        if(a0<=(C*n-a1*n) && C>=a1){
            System.out.println(1);
        }
        else System.out.println(0);
    }

}
