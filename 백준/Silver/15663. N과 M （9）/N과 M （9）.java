import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] numbers;
    static int[] check;
    static int[] assemble;
    static BufferedWriter bw;
    public void DFS(int L) throws IOException {
        if(L==m){
            for(int x:assemble) {
                bw.write(x+" ");
            }
            bw.write("\n");
        }
        else{
            int before = 0;
            for(int i=0;i<n;i++){
                if(before == numbers[i]){
                    continue;
                }
                if(check[i]==0) {
                    check[i]=1;
                    assemble[L] = numbers[i];
                    before = numbers[i];
                    DFS(L+1);
                    check[i] = 0;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
     Main t = new Main();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        numbers = new int[n];
        check = new int[n];
        assemble = new int[m];
        token = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            numbers[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(numbers);
        t.DFS(0);
        bw.close();
    }
}
