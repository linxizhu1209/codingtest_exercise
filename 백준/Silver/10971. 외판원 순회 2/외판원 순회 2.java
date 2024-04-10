import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] W; //
    private static int[] ch; // 방문 체크배열
    private static double min = 1e9;
    private static long sum = 0;
    private static int n = 0;
    private static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        W = new int[n][n];
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                W[i][j] = Integer.parseInt(str[j]);
            }
        }
        Main t = new Main();
        for(int i=0;i<n;i++) {
            ch = new int[n];
            sum = 0;
            ans = -1;
            ch[i] = 1;
            t.dfs(i,0,i,0); //출발 도시
        }
        // 모든 도시를 돌 수 있는 경로가 없는 경우 비용이 안드니까 0 출력..
        // 모든 도시를 돌 수 있는 경우가 하나라도 있으면 ans의 초기값이 바뀔것이므로 바뀌지않았을때에만 0출력하도록함
        if(ans==-1) System.out.println(0);
        else System.out.println((int)min);
    }
    private void dfs(int j,int L,int startCity,int sum){
        if(L==n-1){
            if(W[j][startCity]!=0){
                min = Math.min(sum+W[j][startCity],min);
                ans = 1;
            }
        }
        else{
            for(int x=0;x<n;x++){
                if(ch[x]==0&&W[j][x]!=0){
                    ch[x]=1;
                    dfs(x,L+1,startCity,sum+W[j][x]);
                    ch[x]=0;
                }
            }
        }
    }
}
