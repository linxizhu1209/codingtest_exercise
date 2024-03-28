package backjoon.과제;

import java.io.*;
import java.util.StringTokenizer;

public class Average {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        float[] arr = new float[n];
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int i = 0;
        int max = Integer.MIN_VALUE;
        while(token.hasMoreTokens()){
            int x = Integer.parseInt(token.nextToken());
            arr[i] = x;
            i++;
            max = Math.max(max,x);
        }
        float sum = 0;
        for(int j=0;j<n;j++){
                sum+=Math.round((arr[j]/max)*100);
        }
        bw.write(sum/n+"\n");
        bw.close();
    }
}
