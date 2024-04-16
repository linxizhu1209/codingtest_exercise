
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x!=0) stack.add(x);
            else stack.pop();
        }
        int sum = 0;
        int size = stack.size();
        for(int i=0;i<size;i++){
            sum+=stack.pop();
        }
        bw.write(sum+"\n");
        bw.close();
    }
}
