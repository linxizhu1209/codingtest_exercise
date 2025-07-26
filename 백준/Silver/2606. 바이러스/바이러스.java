
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        int[] visited = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            List<Integer> linked = list.get(cur);
            for(int x: linked){
                if(visited[x] == 0){
                    visited[x] = 1;
                    q.add(x);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
 }
