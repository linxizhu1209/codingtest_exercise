
import java.io.*;
import java.util.*;

/**
 * 1. 맨 처음 큐와 bfs만 사용하여 풀었음 => 메모리 초과, 시간 초과
 * 2. 우선순위 사용하여 풀었음 => 메모리 초과, 시간 초과
 * 3.
 */
class BUS implements Comparable<BUS>{
    int y;
    int cost;

    public BUS(int y, int cost) {
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(BUS o) {
        return this.cost-o.cost;
    }
}
public class Main {
    static ArrayList<ArrayList<BUS>> graph = new ArrayList<>();
    static int[] mindir; // 시간초과,메모리초과 발생하여 이 경로를 지나가는 것 중 가장작은 비용 저장위해 만듦
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 정점 수
        int m = Integer.parseInt(br.readLine()); // 간선의 수
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>()); // 0~n까지의 리스트 생성. 1부터쓰기위해 하나 더 만듦
        }
        StringTokenizer str;
        for(int i=0;i<m;i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            int cost = Integer.parseInt(str.nextToken());
            graph.get(x).add(new BUS(y,cost));
        }
        str = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(str.nextToken());
        int end = Integer.parseInt(str.nextToken());
        Main t = new Main();
        mindir = new int[n+1];
        Arrays.fill(mindir,Integer.MAX_VALUE);
        mindir[start] = 0;
        if(n!=m) {
            t.bfs(start, end);
            bw.write(mindir[end] + "\n");
        }
        else bw.write(0+"\n");
        bw.close();
    }
    private void bfs(int start,int end){
        PriorityQueue<BUS> pq = new PriorityQueue<>();
        pq.offer(new BUS(start,0));
//        for(BUS bus:graph.get(start)) {
//                pq.offer(bus);
//            }
        while(!pq.isEmpty()){
            BUS bus = pq.poll();
            if(bus.cost>mindir[bus.y]) continue;
            for(BUS b:graph.get(bus.y)){
                    if(mindir[b.y]>b.cost+bus.cost) {
                        mindir[b.y] = b.cost+bus.cost;
                        pq.offer(new BUS(b.y, b.cost + bus.cost));
                    }
                }

        }
    }
}

