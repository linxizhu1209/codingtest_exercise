package backjoon.배열_1차원;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaxMin {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        int i=0;
        while(token.hasMoreTokens()){
            arr[i] = Integer.parseInt(token.nextToken());
            i++;
        }
        Arrays.sort(arr);
        bw.write(arr[0]+" "+arr[n-1]);
        bw.close();
    }


}
