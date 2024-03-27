package backjoon.배열_1차원;

import java.io.*;
import java.util.StringTokenizer;

public class pushBall {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        StringTokenizer token = new StringTokenizer(str);
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int[] arr = new int[n];
        for(int i=0;i<m;i++){
            String matter = bf.readLine();
            token = new StringTokenizer(matter);
            int num1 = Integer.parseInt(token.nextToken());
            int num2 = Integer.parseInt(token.nextToken());
            int ball = Integer.parseInt(token.nextToken());
            for(int j=num1-1;j<num2;j++) {
                arr[j] = ball;
            }
        }
        for(int x:arr){
            bw.write(x+" ");
        }
        bw.close();
    }
}
