package backjoon.과제;

import java.io.*;
import java.util.*;

public class filename {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer token;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            token = new StringTokenizer(bf.readLine(),".");
            String name = token.nextToken();
            String filename = token.nextToken();
            map.put(filename,map.getOrDefault(filename,0)+1);
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        for(String key:keySet){
            bw.write(key+" "+map.get(key)+"\n");
        }
        bw.close();
    }
    }
