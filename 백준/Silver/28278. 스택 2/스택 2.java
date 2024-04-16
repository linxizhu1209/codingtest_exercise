import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 1일때 오른쪽에 주어진 정수를 스택에 넣는다
 * 2일때 스택에 정수가 있으면 맨 위의 정수를 빼고 출력, 없으면 -1 출력(isEmpty확인)
 * 3일때 스택에 들어있는 정수의 개수 출력(사이즈)
 * 4일때 스택이 비어있으면 1, 아니면 0 (isEmpty)
 * 5일때 스택에 정수가 있다면 맨위의 정수를 출력(빼진 않음). 없으면 -1 출력
 */
public class Main {
    static Stack<Integer> stack;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        for(int i=0;i<n;i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            order(token);
        }
        bw.close();
    }
    static private void order(StringTokenizer token) throws IOException {
        int x = Integer.parseInt(token.nextToken());
        if(x==1){
            int t = Integer.parseInt(token.nextToken());
            stack.add(t);
        }
        else if(x==2){
            if(stack.isEmpty()) bw.write(-1+"\n");
            else bw.write(stack.pop()+"\n");
        }
        else if(x==3){
            bw.write(stack.size()+"\n");
        }
        else if(x==4){
            if(stack.isEmpty()) bw.write(1+"\n");
            else bw.write(0+"\n");
        }
        else if(x==5){
            if(stack.isEmpty()) bw.write(-1+"\n");
            else bw.write(stack.peek()+"\n");
        }
    }
}
