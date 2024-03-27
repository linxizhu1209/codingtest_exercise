package backjoon.배열_1차원;

import java.io.*;
import java.util.StringTokenizer;

public class MaxValue {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max= Integer.MIN_VALUE;
        int count = 0;
        for(int i=1;i<=9;i++){
            int n = Integer.parseInt(bf.readLine());
            if(n>max){
                max=n; count=i;
            }
        }
        bw.write(max+"\n");
        bw.write(count+"\n");
        bw.close();
    }
}
