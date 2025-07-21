
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> stack = new Stack<>();
    int n = Integer.parseInt(br.readLine());
    for(int i=0;i<n;i++){
        StringTokenizer token = new StringTokenizer(br.readLine());
        String str = token.nextToken();
        if(str.equals("push")){
            int x = Integer.parseInt(token.nextToken());
            stack.push(x);
        } else if (str.equals("top")){
            int x = stack.isEmpty() ? -1 : stack.peek();
            System.out.println(x);
        } else if (str.equals("size")){
            System.out.println(stack.size());
        } else if (str.equals("empty")){
            System.out.println(stack.isEmpty() ? 1 : 0);
        } else if (str.equals("pop")){
            int x = stack.isEmpty() ? -1 : stack.pop();
            System.out.println(x);
        }
    }
    }
}
