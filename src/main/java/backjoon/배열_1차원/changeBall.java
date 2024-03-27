package backjoon.배열_1차원;

import java.io.*;
import java.util.StringTokenizer;

public class changeBall {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++) arr[i] = i;
        for(int i=0;i<m;i++){
            token = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }
        for(int i=1;i<=n;i++) bw.write(arr[i]+" ");
        bw.close();
    }
}
