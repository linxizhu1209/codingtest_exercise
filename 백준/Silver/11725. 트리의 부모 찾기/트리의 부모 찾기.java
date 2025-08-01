import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        parent = new int[n+1];
        parent[1] = 1;
        dfs(1);
        for(int i=2;i<=n;i++){
            System.out.println(parent[i]);
        }
    }

    static private void dfs(int root){
        List<Integer> ls = list.get(root);
        for(int x:ls){
            if(parent[x]==0){
                parent[x]=root;
                dfs(x);
            }
        }
    }
}