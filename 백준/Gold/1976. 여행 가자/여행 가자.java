import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] unf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        unf = new int[n+1];
        for(int i=0;i<=n;i++){
            unf[i] = i;
        }
        StringTokenizer token;
        for(int i=1;i<=n;i++){
            token = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                int a = Integer.parseInt(token.nextToken());
                if(a==1){
                    Union(i,j);
                }
            }
        }
        token = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<m;i++){
            int a = Integer.parseInt(token.nextToken());
            set.add(Find(a));
        }
        if(set.size()!=1){
            System.out.println("NO");
        }
        else System.out.println("YES");
    }
    private static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }
    private static int Find(int a){
        if(unf[a]==a) return a;
        else return unf[a] = Find(unf[a]);
    }
}
