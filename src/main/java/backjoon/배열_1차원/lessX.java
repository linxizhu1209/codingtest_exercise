package backjoon.배열_1차원;

import java.io.*;
import java.util.StringTokenizer;

public class lessX {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        String str = bf.readLine();
        token = new StringTokenizer(str);
        int n = Integer.parseInt(token.nextToken());
        int x = Integer.parseInt(token.nextToken());
        String str2 = bf.readLine();
        token = new StringTokenizer(str2);
        while(token.hasMoreTokens()){
            int num = Integer.parseInt(token.nextToken());
            if(x>num) bw.write(num+" ");
        }
        bw.close();
    }
}
