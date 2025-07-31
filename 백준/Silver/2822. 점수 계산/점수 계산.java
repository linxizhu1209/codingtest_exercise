import java.io.*;
import java.util.*;

public class Main {
    static class score implements Comparable<score> {
        int x; // 순서
        int y; // 점수

        score(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(score o) {
            return o.y - this.y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<score> pq = new PriorityQueue<>();
        for(int i=1;i<=8;i++){
            int x = Integer.parseInt(br.readLine());
            pq.add(new score(i,x));
        }
        int[] arr = new int[5];
        int sum = 0;
        for(int i=0;i<5;i++){
            score s = pq.poll();
            sum += s.y;
            arr[i] = s.x;
        }
        System.out.println(sum);
        Arrays.sort(arr);
        for(int x:arr){
            System.out.print(x+" ");
        }
    }
}