import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n+1];
        String[] str = br.readLine().split(" ");
        for(int i=1;i<=n;i++){
            if(Integer.parseInt(str[i-1])==1){
                arr[i] = true;
            }
            else arr[i] = false;
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            String[] str2 = br.readLine().split(" ");
            int s = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            int lt = b-1;
            int rt = b+1;
            if(s==1){
                for(int j=b;j<=n;j+=b) {
                    arr[j]=!arr[j];
                }
            }
            else{
                arr[b] = !arr[b];
                while(1<=lt&&rt<=n){
                    if(arr[lt]==arr[rt]){
                        arr[lt] = !arr[lt];
                        arr[rt] = !arr[rt];
                        lt--;
                        rt++;
                    }
                    else break;
                }
            }
        }
        for(int x=1;x<=n;x++){
            if(arr[x]) System.out.print(1+" ");
            else System.out.print(0+" ");
            if(x%20==0) System.out.println();
        }
    }
}
