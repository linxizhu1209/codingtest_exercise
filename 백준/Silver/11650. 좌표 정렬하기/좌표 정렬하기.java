import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x==o.x) return this.y-o.y;
        else return this.x-o.x;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String[] arr = br.readLine().split(" ");
            pq.offer(new Point(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])));
        }
        while(!pq.isEmpty()){
            Point p = pq.poll();
            System.out.println(p.x+" "+p.y);
        }
    }
}
