import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken()); // 정점의 개수
        int k = Integer.parseInt(token.nextToken()); // 간선의 개수

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        System.out.print("<");
        int count = 1;
        boolean isFirst = true;
        while (!q.isEmpty()){
            if(count == k){
                int x = q.poll();
                if(isFirst){
                    isFirst = false;
                    System.out.print(x);
                } else {
                    System.out.print(", " + x);
                }
                count = 1;
            } else {
                count++;
                q.add(q.poll());
            }
        }
        System.out.println(">");
    }
}
