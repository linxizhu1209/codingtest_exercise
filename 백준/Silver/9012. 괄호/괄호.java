
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main t = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String str = br.readLine();
            bw.write(t.solution(str)+"\n");
        }
        bw.close();
    }

    public String solution(String str){
        int length = str.length();
        int count = 0;
        for(int i=0;i<length;i++){
            if(str.charAt(i)=='(') count++;
            else count--;
            if(count<0) return "NO";
        }
        if(count!=0) return "NO";
        else return "YES";
    }
}
