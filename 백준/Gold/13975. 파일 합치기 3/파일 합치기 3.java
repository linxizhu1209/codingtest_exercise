import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            String[] str = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                pq.offer(Long.parseLong(str[j]));
            }
            Long total = 0L;
            while (pq.size()!=1){
                Long o1 = pq.poll();
                Long o2 = pq.poll();
                Long sum = o1+o2;
                total+=sum;
                pq.offer(sum);
            }
            bw.write(total+"\n");
        }
        bw.close();
    }
}
