
import java.io.*;
import java.util.Arrays;
import java.util.Stack;

class NumberMax{
    int i;
    int n;

    public NumberMax(int i, int n) {
        this.i = i;
        this.n = n;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<NumberMax> s = new Stack<>();
        String[] arr = br.readLine().split(" ");
        s.add(new NumberMax(0,Integer.parseInt(arr[0])));
        int[] numarr = new int[n];
        Arrays.fill(numarr,-1);
        for(int i=1;i<n;i++){
            NumberMax tmp = s.peek();
            int rightNum = Integer.parseInt(arr[i]);
            if(rightNum>tmp.n) {
                numarr[tmp.i] = rightNum;
                s.pop();
                while(!s.isEmpty()){
                    tmp = s.peek();
                    if(rightNum>tmp.n){
                        numarr[tmp.i] = rightNum;
                        s.pop();
                    }
                    else break;
                }
            }
            s.add(new NumberMax(i, rightNum));
        }
        StringBuilder sb = new StringBuilder();
        for(int x:numarr){
            sb.append(x+" ");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
