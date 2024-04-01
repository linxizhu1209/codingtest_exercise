
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        boolean[][] chess = new boolean[n][m];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                if(str.charAt(j)=='B'){
                    chess[i][j] = true;
                }
                else chess[i][j] = false;
            }
        }
        /**
         * - 주어진 보드판에는 8x8면적의 체스판이 몇개 있는지(몇번 탐색을 해야하는지)는
         * (n-7)*(m-7) --> 만약 8x8 보드판이라면 8x8 체스판은 한번만 탐색해도 찾을 수 있고
         * 9x9 보드판이라면 8x8 체스판을 4번 탐색하면 찾을 수 있음
         *
         * - 체스판의 맨 왼쪽윗부분이 W일때와 B일때도 체크해봐야하기에 2*(N-7)*(M-7)이 최종 탐색횟수가 된다
         */

        int s = (n-7)*(m-7);
        int min = 64;
        for(int i=0;i<n-7;i++){
            for(int j=0;j<m-7;j++) {
                // s개의 8x8 체스판을 돌며 맨 처음 블럭이 B일때 true, W일때 false라고 하고
                // 그 블럭의 색이 패턴에 맞지않다면 다시 칠해야하는 개수 count를 ++ 해준다.
                boolean TF = chess[i][j];
                int thisBlockMin = 0;
                int count = 0;
                for(int l=i;l<i+8;l++){
                    for(int o=j;o<j+8;o++){
                        if(chess[l][o]!=TF) count++;
                        TF=(!TF); // 다음 블럭의 색깔은 지금 색깔과 정반대여야 하기에 true->false/ false->true로 변경
                    }
                    TF=(!TF); // => 맨끝 블럭과 그 다음 행의 맨처음 블럭은 색이 같기에 위에서 변환된걸 다시 변환
                }
                thisBlockMin=Math.min(count,(64-count)); // 64-count와 count를 비교하는 이유는
                // 만약 맨처음 블럭의 색깔만 바뀐다면 제대로된 패턴의 수는 count가 될 것이고, 다시 칠해야하는 블럭의 수는 64-count가 될 것이기때문
                min=Math.min(thisBlockMin,min);
            }
        }
        System.out.println(min);
    }
}
