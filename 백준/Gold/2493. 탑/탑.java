import java.io.*;
import java.util.Stack;

class Topbuild{
    int n;
    int h;

    public Topbuild(int n, int h) {
        this.n = n;
        this.h = h;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        Stack<Topbuild> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int tmp = Integer.parseInt(str[i]);
            while(!stack.isEmpty()){
            if(stack.peek().h>tmp){
                sb.append(stack.peek().n+" ");
                break; // while문을 끝내기위함
            }
            else{
                stack.pop();
                /** while문을 돌면서, 현재의 값보다
                 * stack에 마지막에 들어온 값이 작다면 그 곳에는 신호를 전송할 수 없다는 뜻이므로
                 * stack의 마지막 값을 pop해서 빼준다.
                 * 이 값을 빼는 이유는, 현재 tmp가 이 값보다 크기때문에 tmp이후에 들어올 값들은
                 * 신호를 보내도 현재 tmp에 보낼 것이지 이 값에는 절대 못 보낼 것이기 때문이다.
                 */
                 }
            }
            if(stack.isEmpty()){
                sb.append("0 ");
            }
            stack.add(new Topbuild(i+1,tmp));
        }
        bw.write(sb.toString());
        bw.close();
    }
}
