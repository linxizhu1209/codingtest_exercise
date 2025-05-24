import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            q.add(i);
        }
        if(n == 1){
            System.out.println(n);
        } else {
            while (!q.isEmpty()) {
                int wipe = q.poll();
                if (q.size() == 1) {
                    System.out.println(q.peek());
                    return;
                }
                int last = q.poll();
                q.add(last);
            }
        }
    }
}