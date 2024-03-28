package backjoon.과제;

import java.io.*;

public class Checkin {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[31];
        for(int i=1;i<29;i++){
            int n = Integer.parseInt(bf.readLine());
            arr[n] = 1;
        }
        for(int i=1;i<31;i++){
            if(arr[i]==0) bw.write(i+"\n");
        }
        bw.close();
    }
}
