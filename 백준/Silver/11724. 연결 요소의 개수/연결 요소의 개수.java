import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
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
        }
        int count = 0;
        visited = new boolean[n+1];
        // dfs 로 푸는게 나을거같기도?
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }
    private static void dfs(int i){
        List<Integer> ls = list.get(i);
        for(int j:ls){
            if(!visited[j]){
                visited[j] = true;
                dfs(j);
            }
        }
    }
}