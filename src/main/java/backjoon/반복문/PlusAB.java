package backjoon.반복문;

import java.io.*;
import java.util.StringTokenizer;

public class PlusAB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            token = new StringTokenizer(br.readLine());
            bw.write("Case #"+i+": "+(Integer.parseInt(token.nextToken())+Integer.parseInt(token.nextToken()))+"\n" );
        }
        bw.close();
    }
}
