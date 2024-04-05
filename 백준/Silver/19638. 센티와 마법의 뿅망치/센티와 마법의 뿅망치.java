
import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
        int n = Integer.parseInt(arr[0]); // 거인의 숫자
        int h = Integer.parseInt(arr[1]); // 센티의 키
        int m = Integer.parseInt(arr[2]); // 뿅망치 개수

        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            pq.offer(x);
        }
        int i = 0;
        if(h<=pq.peek()) {
            while (i != m) {
                if (pq.peek() == 1) break;
                int x = pq.poll();
                pq.offer(x / 2);
                i++;
                if (pq.peek() < h) break;
            }
            if (pq.peek() >= h) {
                bw.write("NO" + "\n");
                bw.write(pq.peek() + "\n");
            } else {
                bw.write("YES" + "\n");
                bw.write(i + "\n");
            }
        }
        else {
            bw.write("YES"+"\n");
            bw.write(0+"\n");
        }
        bw.close();
    }
}
