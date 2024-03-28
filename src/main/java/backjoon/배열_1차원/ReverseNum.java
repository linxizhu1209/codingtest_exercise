package backjoon.배열_1차원;

import java.io.*;
import java.util.StringTokenizer;

public class ReverseNum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sb = new StringBuilder(bf.readLine()).reverse().toString();
        StringTokenizer token = new StringTokenizer(sb);
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        if(n>m) bw.write(n+"\n");
        else bw.write(m+"\n");
        bw.close();
    }
}
