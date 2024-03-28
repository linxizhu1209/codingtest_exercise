package backjoon.배열_1차원;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Haligali {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =Integer.parseInt(bf.readLine());
        Map<String,Integer> fruitMap = new HashMap<>();
        StringTokenizer token;
        String answer = "NO";
        for(int i=0;i<n;i++) {
             token = new StringTokenizer(bf.readLine());
             String fruit = token.nextToken();
             int num = Integer.parseInt(token.nextToken());
            fruitMap.put(fruit, fruitMap.getOrDefault(fruit,0)+num);
        }
        for(int x:fruitMap.values()){
            if(x==5) {
                answer="YES";
                break;
            }
        }
        bw.write(answer);
        bw.close();
    }
    }
