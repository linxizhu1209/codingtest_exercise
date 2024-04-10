import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int count,s,n;
    private static int[] arr,ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        s = Integer.parseInt(str[1]);
        arr = new int[n];
        ch = new int[n];
        String[] numarr = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(numarr[i]);
        }
        Main t = new Main();
        t.dfs(0,0);
        if(s==0) count-=1;
        System.out.println(count);
    }
    private void dfs(int sum,int L){
        if(L==n){
            if(sum==s) count++;
        }
        else{
            dfs(sum+arr[L],L+1);
            dfs(sum,L+1);

        }
    }
}
