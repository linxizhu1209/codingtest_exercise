
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
        for(int i=1;i<n;i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                pq.offer(Integer.parseInt(arr[j]));
                pq.poll();
                /**
                 * 주의 : pq offer로 먼저 넣어주고, poll을 해줘야 한다.
                 */
                }
            }
        bw.write(pq.poll()+"\n");
        bw.close();
    }
}
