import java.io.*;
import java.util.*;

public class Main {
    /**
     * 1. 도감 기록 포켓몬의 개수 n, 내가 맞춰야하는 문제의 개수 m
     * 2. n번까지 순서대로 포켓몬 이름이 주어짐
     */


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        String[] arr = new String[n];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            arr[i] = in.readLine(); // 해당 순서에 있는 포켓몬 기록
            map.put(arr[i],i+1); // 해당 포켓몬의 순번 기록
        }
        for(int i = 0; i < m; i++) {
            String s = in.readLine();
            if(map.containsKey(s)) {
                System.out.println(map.get(s));
            } else {
                int x = Integer.parseInt(s);
                System.out.println(arr[x-1]);
            }
        }
    }
}