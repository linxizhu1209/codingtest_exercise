
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken()); // 정점의 개수
        int m = Integer.parseInt(token.nextToken()); // 간선의 개수
        int v = Integer.parseInt(token.nextToken()); // 시작 정점의 번호
//        int[][] arr = new int[n+1][n+1];
        list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
//            arr[a][b] = 1;
//            arr[b][a] = 1;
        }
        for(List<Integer> l : list) {
            Collections.sort(l);
        }
        visited = new boolean[n+1];
        // (v,v) 에서 시작
//        visited[v] = true;
        dfs(v);
        System.out.println();
        visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur+" ");
            List<Integer> ls = list.get(cur);
            for(int x: ls){
                if(!visited[x]){
                    visited[x] = true;
                    q.add(x);
                }
            }
        }

    }
    static private void dfs(int v){
        if(visited[v]) return;
        List<Integer> ls = list.get(v);
        visited[v] = true;
        System.out.print(v+" ");
        for(int x: ls){
            if(!visited[x]){
                dfs(x);
            }
        }
    }
}
