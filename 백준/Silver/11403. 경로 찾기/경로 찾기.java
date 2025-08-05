import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=1;i<=n;i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                int x = Integer.parseInt(token.nextToken());
                if(x==1) {
                    list.get(i).add(j);
                }
            }
        }
        int[][] visited;
        for(int i=1;i<=n;i++){
            visited = new int[n+1][n+1];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()){
                int x = q.poll();
                List<Integer> ls = list.get(x);
                for(int y:ls){
                    if(visited[i][y]!=1){
                        visited[i][y]=1;
                        q.add(y);
                    }
                }

            }

            for(int j=1;j<=n;j++){
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
    }
}