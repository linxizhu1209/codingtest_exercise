import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class CowFood implements Comparable<CowFood>{
    int y;
    int food;

    public CowFood(int y, int food) {
        this.y = y;
        this.food = food;
    }

    @Override
    public int compareTo(CowFood o) {
        return this.food-o.food;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        ArrayList<ArrayList<CowFood>> graph = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }
        PriorityQueue<CowFood> pq = new PriorityQueue<>();
        int[] dy = new int[n+1];
        for(int i=0;i<m;i++){
            token = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(token.nextToken());
            int y=Integer.parseInt(token.nextToken());
            int food = Integer.parseInt(token.nextToken());
            graph.get(x).add(new CowFood(y,food));
            graph.get(y).add(new CowFood(x,food));
        }
        Arrays.fill(dy,Integer.MAX_VALUE);
        dy[1] = 0;
        pq.offer(new CowFood(1,0));
        while(!pq.isEmpty()){
            CowFood cf = pq.poll();
            int y = cf.y;
            int cost = cf.food;
            for(CowFood cow:graph.get(y)) {
                if(dy[cow.y]>dy[cf.y]+cow.food) {
                    dy[cow.y]=dy[cf.y]+cow.food;
                    pq.offer(new CowFood(cow.y,dy[cow.y])); // 다음목적지의 dy[cow.y]가 현재 위치까지의 비용+다음위치에서의 비용보다 클 경우에만 큐에 추가하도록함 => 중복하여 방문하는 것을 막고, 최소값만 들어오게함
                }
            }
        }
        bw.write(dy[n]+"\n");
        bw.close();
    }
}
