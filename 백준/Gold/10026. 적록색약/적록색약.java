
import java.io.*;
import java.util.Arrays;

public class Main {
    static char[][] numarr;
    static int[][] check;
    static int[] dx;
    static int[] dy;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        numarr = new char[n][n];
        check = new int[n][n];
        dx = new int[]{0,-1,0,1};
        dy = new int[]{-1,0,1,0};
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                numarr[i][j] = str.charAt(j);
            }
        }
        Main t = new Main();
        int answer1 = 0;
        int answer2= 0;
        // 적록색약이 아닌 사람일때 => for문을 돌며 "G"인 경우 => "R"로 바꿔주는 작업을 동시에 진행
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(check[i][j]==0){
                    t.DFS(i,j);
                    answer1++;
                }
                if(numarr[i][j]=='G') numarr[i][j]='R';
            }
        }
        for(int i=0;i<n;i++) {
            Arrays.fill(check[i], 0);
        }
        //적록색약 일때
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(check[i][j]==0){
                    check[i][j]=1;
                    t.DFS(i,j);
                    answer2++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer1+" "+answer2);
        bw.write(sb.toString());
        bw.close();
    }
    public void DFS(int i,int j){
        for(int x=0;x<4;x++){
            if(i+dx[x]<0||j+dy[x]<0||i+dx[x]>=n||j+dy[x]>=n){
                continue;
            }
            if(numarr[i+dx[x]][j+dy[x]]==numarr[i][j]&&check[i+dx[x]][j+dy[x]]==0){
                // 다음 위치에 있는 것과 현재 있는 것과 비교하니까 if문이 안넘어
                check[i+dx[x]][j+dy[x]]=1;
                DFS(i+dx[x],j+dy[x]);
            }
        }

    }
}
