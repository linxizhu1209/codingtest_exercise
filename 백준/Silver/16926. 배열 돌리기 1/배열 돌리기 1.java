
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bf.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int s = Integer.parseInt(arr[2]);
        int[][] twoMension = new int[n][m];
        for(int i=0;i<n;i++) {
            String[] numarr = bf.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                twoMension[i][j] = Integer.parseInt(numarr[j]); // i는 행 번호 numarr에 들어있는 건 그 행의 값들
            }
        }

        for(int i=0;i<s;i++){ // S만큼 for문 반복 (회전 수)
            for(int j=0;j<Math.min(n,m)/2;j++){
                int tmp = twoMension[j][j]; // 맨왼쪽의 끝 숫자를 저장

                for(int x=j+1;x<m-j;x++){ // left  왼쪽으로 회전할때에 왼쪽부터 넣어줘야지 덮어씌어지지않는다
                    twoMension[j][x-1] = twoMension[j][x];
                }
                for(int x=j+1;x<n-j;x++){ // up 위로 회전할때 위쪽부터 넣어줘야지 덮임 x
                    twoMension[x-1][m-1-j] = twoMension[x][m-1-j];
                }
                for(int x=m-j-1;x>j;x--){ // right 오른쪽 회전 시 오른쪽부터 넣어줘야함
                    twoMension[n-j-1][x] = twoMension[n-j-1][x-1];
                }
                for(int x=n-j-1;x>j;x--){ // down 아래로 회전 시 아래부터 넣어줘야함
                    twoMension[x][j] = twoMension[x-1][j];
                }
                twoMension[j+1][j] = tmp;
            }
        }

        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<m;j++){
                sb.append(twoMension[i][j]+" ");
            }
            System.out.println(sb);
        }
    }
}
