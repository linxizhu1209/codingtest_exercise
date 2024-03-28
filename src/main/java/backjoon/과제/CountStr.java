package backjoon.과제;

import java.io.*;
import java.util.StringTokenizer;

public class CountStr {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int count = 0;
        while (token.hasMoreTokens()){
            token.nextToken();
            count++;
        }
        bw.write(count+"\n");
        bw.close();
    }
}
