package backjoon.과제;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class numCard {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        Map<Integer,Integer> map = new HashMap<>();
        StringTokenizer token = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(token.nextToken());
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int m =Integer.parseInt(bf.readLine());
        token = new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++){
            int x = Integer.parseInt(token.nextToken());
            bw.write(map.getOrDefault(x,0)+" ");
        }
        bw.close();
    }
}
