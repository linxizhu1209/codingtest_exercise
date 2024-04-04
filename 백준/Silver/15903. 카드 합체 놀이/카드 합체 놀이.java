
import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        long n = Integer.parseInt(str[0]);
        long m = Integer.parseInt(str[1]);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        String[] numarr = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            pq.offer(Long.parseLong(numarr[i]));
        }
        for(int i=0;i<m;i++){
            long x = pq.poll();
            long y = pq.poll();
            long z = x+y;
            pq.offer(z);
            pq.offer(z);
        }
        long sum = 0;
        for(long x:pq){
            sum+=x;
        }
        bw.write(sum+"\n");
        bw.close();
    }
}
