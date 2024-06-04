import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class NodeRoute implements Comparable<NodeRoute>{
    int nx;
    int dis;

    public NodeRoute(int nx, int dis) {
        this.nx = nx;
        this.dis = dis;
    }


    @Override
    public int compareTo(NodeRoute o) {
        return this.dis - o.dis;
    }
}
public class Main {
    static ArrayList<ArrayList<NodeRoute>> graph;
    static long INF;
    static long[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int E = Integer.parseInt(token.nextToken());
        graph = new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int num = Integer.parseInt(token.nextToken());
            graph.get(a).add(new NodeRoute(b,num));
            graph.get(b).add(new NodeRoute(a,num));
        }
        INF = Integer.MAX_VALUE;
        ch = new long[N+1];
        token = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(token.nextToken());
        int v2 = Integer.parseInt(token.nextToken());
        long sumCase1 = 0; // 시작점 - v1 - v2 - 끝점 경로 최단 시간
        long sumCase2 = 0; // 시작점 - v2 - v1 - 끝점 경로 최단 시간
        sumCase1 += dijkstra(1,v1,ch);
        sumCase1 += dijkstra(v1,v2,ch);
        sumCase1 += dijkstra(v2,N,ch);
        sumCase2 += dijkstra(1,v2,ch);
        sumCase2 += dijkstra(v2,v1,ch);
        sumCase2 += dijkstra(v1,N,ch);
        long answer = Math.min(sumCase1,sumCase2);
        if(answer>=INF) System.out.println(-1);
        else System.out.println(answer);
    }
    private static long dijkstra(int start, int end, long[] ch){
        Arrays.fill(ch,INF);
        PriorityQueue<NodeRoute> pq = new PriorityQueue<>();
        pq.add(new NodeRoute(start,0));
        ch[start] = 0;
        while(!pq.isEmpty()){
            NodeRoute route = pq.poll();
            int nx = route.nx;
            int dis = route.dis;
            if(ch[nx]<dis) continue;
            ch[nx] = dis;
            for(NodeRoute node:graph.get(nx)){
                if(ch[node.nx]>dis+node.dis) {
                    pq.offer(new NodeRoute(node.nx, node.dis + dis));
                }
            }
        }
        return ch[end];
    }
}
