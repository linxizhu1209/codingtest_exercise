
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(token.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int x = Integer.parseInt(token.nextToken());
            if(set.contains(x)) {
                System.out.print("1 ");
            }
            else {
                System.out.print("0 ");
            }
        }
    }
}