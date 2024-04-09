
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int count = 0;
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            int nx = Integer.parseInt(str[1]);
            if(s.isEmpty()) s.add(nx);
            else{
             if(s.peek()<nx) s.add(nx);
             else if(s.peek()>nx&&nx!=0) {
                 while(!s.isEmpty()&&s.peek()>nx){
                     s.pop();
                     count++;
                 }
                 if(s.isEmpty() || s.peek() != nx) s.add(nx);
             }
             else if(nx==0){
                 count+=s.size();
                 s.clear();
             }
            }
        }
        while(!s.isEmpty()){
            if(s.peek()>0){
                count++;
            }
            s.pop();
        }
        bw.write(count+"\n");
        bw.close();
    }
}
