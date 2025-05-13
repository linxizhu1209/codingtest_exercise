
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException {

        /**
         * 1. 몸무게 x, 키 y (x,y)
         * 2. 몸무게와 키 둘다 크면 덩치가 크다
         * 3. 몸무게나 키 둘중에 하나만 크고 다른건 작으면 덩치가 같다고본다
         */

        // 배열로 풀 수 있나?
        // 2차원 배열 int[][] 로 행에는 사람 순번, 열에는 list로 몸무게와 키

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[][] arr = new int[n+1][2]; // 열에는 몸무게랑 키가 들어감 인덱스0에는 몸무게, 인덱스1에는 키
        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(in.nextLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1;i<=n;i++){
            int count = 1;
            int x = arr[i][0]; // 몸무게
            int y = arr[i][1]; // 키
            for(int j=1;j<=n;j++){
                int ax = arr[j][0]; // 상대의 몸무게
                int ay = arr[j][1]; // 상대의 키
                if(x<ax && y<ay){
                    // 상대가 나보다 덩치가 크면 내순위는 +1
                    count++;
                }
            }
            bw.write(count+" ");
        }
            bw.flush();
            bw.close();
    }
}