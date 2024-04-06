
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static BufferedWriter bw;
    static int n;
    static int[] check, answer;
    static int m,count;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        Main t = new Main();
        n=Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        int r = Integer.parseInt(arr[2]);
        graph = new ArrayList<>();
        check = new int[n+1];
        answer = new int[n+1];
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=1;i<=m;i++){
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for(int i=1;i<=n;i++) {
            Collections.sort(graph.get(i));
        }
        count =1;
        check[r] = 1;
        answer[r] = count;
        answer = t.DFS(r,1);
        for(int i=1;i<=n;i++){
            bw.write(answer[i]+"\n");
        }
        bw.close();
    }
    public int[] DFS(int r,int L){
        if(L==n){
            return answer;
        }
        else {
            for (int x:graph.get(r)) {
                if (check[x] == 0) {
                    check[x] = 1;
                    answer[x] = ++count;
                    DFS(x, L + 1);
                }
            }
        }
        return answer;
    }
}
