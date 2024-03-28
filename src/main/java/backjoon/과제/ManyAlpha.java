package backjoon.과제;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ManyAlpha {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character,Integer> count = new HashMap<>();
        String str = bf.readLine().toUpperCase();
        int max = Integer.MIN_VALUE;
        char answer=' ';
        for(char x:str.toCharArray()) {
            int num = count.getOrDefault(x,0)+1;
            count.put(x, num);
            if(num>max) {
                answer=x;
                max=num;
            }
            else if(num==max) answer = '?';
        }
        bw.write(answer+"\n");
        bw.close();
    }

}
