
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<n;i++){
            pq.offer(arr[i]-arr[i-1]); // 같은 조에 속한 원생은 인접해있어야하므로 인접한 원생들의 차이를 구해 pq에 넣는다
        }
        int sum=0;
        for(int i=0;i<n-m;i++){
            sum+=pq.poll();
        }
        bw.write(sum+"\n");
        bw.close();
    }

}
