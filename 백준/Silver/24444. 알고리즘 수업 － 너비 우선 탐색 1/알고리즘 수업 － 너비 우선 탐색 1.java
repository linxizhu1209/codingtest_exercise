import java.io.*;
import java.util.*;
public class Main {
    static Queue<Integer> dq;
    static int[] arr,check;
    static  ArrayList<ArrayList<Integer>> arlist;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] num = br.readLine().split(" ");
        Main t = new Main();
        int n = Integer.parseInt(num[0]);
        int m = Integer.parseInt(num[1]);
        int r = Integer.parseInt(num[2]);
        dq = new LinkedList<>();
        arr = new int[n+1];
        check = new int[n+1];
        arlist = new ArrayList<>();
        for(int i=0;i<=n;i++){
            arlist.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            arlist.get(x).add(y);
            arlist.get(y).add(x);
        }
        for(int i=1;i<=n;i++) {
            Collections.sort(arlist.get(i));
        }

        t.BFS(r);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(arr[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    public void BFS(int r){
        int count = 0;
        check[r] = 1;
        arr[r] = ++count;
        dq.add(r);
        while(!dq.isEmpty()){
            int n = dq.poll();
            for(int x:arlist.get(n)) {
                if(check[x]!=1) {
                    check[x] = 1;
                    arr[x] = ++count;
                    dq.offer(x);
                }
            }
        }
    }
}
