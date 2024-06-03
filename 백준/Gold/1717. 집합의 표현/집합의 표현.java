import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] uni;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        uni = new int[n+1];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=n;i++){
            uni[i]=i;
        }
        for(int i=0;i<m;i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            if(Integer.parseInt(token.nextToken())==0){
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                Union(a,b);
            }
            else{
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                int fa = Find(a);
                int fb = Find(b);
                if(fa==fb) sb.append("YES"+"\n");
                else sb.append("NO"+"\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static int Find(int n){
        if(n==uni[n]) return n;
        else return uni[n]=Find(uni[n]);
    }
    private static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) uni[fa]=fb;
    }
}
