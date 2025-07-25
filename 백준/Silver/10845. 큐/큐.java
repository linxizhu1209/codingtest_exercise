import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q= new ArrayDeque<>();
//        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")){
                q.add(Integer.parseInt(st.nextToken()));
            } else if (s.equals("pop")){
                System.out.println(q.isEmpty()? -1 : q.poll());
            } else if (s.equals("size")){
                System.out.println(q.size());
            } else if (s.equals("empty")){
                System.out.println(q.isEmpty()? 1 : 0);
            } else if (s.equals("front")){
                System.out.println(q.isEmpty()? -1 : q.peek());
            } else if (s.equals("back")){
                System.out.println(q.isEmpty()? -1 : q.getLast());
            }
        }
        }
 }
