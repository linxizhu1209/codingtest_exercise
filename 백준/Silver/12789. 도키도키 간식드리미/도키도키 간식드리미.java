
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        int j = 1;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()){
                if(j==stack.peek()) {
                    stack.pop();
                    j++;
                }
                else break;
            }
            int m = Integer.parseInt(str[i]);
            if(j==m){ // 만약 1과 같다면~
                j++;
            }
            else{ // 만약 같지않다면 stack에 들어있는 애랑도 비교
                stack.add(m);
            }
        }
        boolean isPossible = true;
        while(!stack.isEmpty()){
            if(stack.pop()==j) j++;
            else {
                isPossible = false;
                break;
            }
        }
        if(isPossible) bw.write("Nice"+"\n");
        else bw.write("Sad"+"\n");
        bw.close();
    }
}
