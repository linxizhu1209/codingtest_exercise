
import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            pq.offer(Integer.parseInt(str[i]));
        }
        int sum = 0;
        int time = 0;
        while(!pq.isEmpty()){
            int x = pq.poll();
            sum += time+x;
            time = time+x;
        }
        bw.write(sum+"\n");
        bw.close();
    }
}
