
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
         * 1. (1,1) 부터 시작해서 (n,n) 까지 있음
         * 2. 심장 바로 위쪽 1칸이 머리, 심장 왼쪽부터 왼팔, 오른쪽부터 오른팔, 아래쪽은 허리, 허리의 대각선왼쪽은 왼발, 대각선 오른쪽 오른발
         * 3. 첫째줄에는 심장이 위치한 행의번호와 열의 번호를 공백으로 구분해서 출력
         * 4. 두번째 줄에는 왼팔, 오른팔, 허리, 왼쪽다리, 오른쪽다리의 길이를 공백구분하여 출력
         * 5. 입력은 첫째줄은 n, 다음줄부터는 ___*___ 이런식으로 입력되는데, *은 신체부분 _는 빈부분
         */
        Scanner in = new Scanner(System.in);
        StringTokenizer token = new StringTokenizer(in.nextLine());
        int n = Integer.parseInt(token.nextToken());
        char[][] arr = new char[n+1][n+1];
        boolean isHead = false; // 젤 첫번째로 true 되는 순간 머리니까. 심장위치 파악
        int[] heart = new int[2]; // 심장 좌표
        for(int i=1;i<=n;i++){
            String str = in.nextLine();
            for(int j=1;j<=n;j++){
                char x = str.charAt(j-1);
                if(!isHead && x=='*'){
                    isHead = true;
                    heart[0] = i+1;
                    heart[1] = j;
                } // 심장위치 파악
                arr[i][j] = x;
            }
        }


        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        int hearti = heart[0]; // 심장 x좌표
        int heartj = heart[1]; // 심장 j좌표
        for(int j=heartj-1;j>=1;j--){
            // 왼팔어디까지
            char x = arr[hearti][j];
            if(x=='*'){
                leftArm++;
            } else{
                break;
            }
        }
        for(int j=heartj+1;j<=n;j++){
            // 오른팔 어디까지
            char x = arr[hearti][j];
            if(x=='*'){
                rightArm++;
            } else break;
        }
        int[] arr2 = new int[2]; // 허리의 마지막 좌표
        for(int i=hearti+1;i<=n;i++){
            // 허리어디까지
            char x = arr[i][heartj];
            if(x=='*'){
                waist++;
            } else {
                // 허리가 끊기는 순간의 좌표
                arr2[0] = i-1;
                arr2[1] = heartj;
                break;
            }
        }
        int waisti = arr2[0];
        int waistj = arr2[1];
        // 왼 다리는 허리 끝 좌표의 x좌표 +1, y좌표 -1
        for(int i=waisti+1;i<=n;i++){
            char x = arr[i][waistj-1];
            if(x=='*'){
                leftLeg++;
            } else break;
        }
        for(int i=waisti+1;i<=n;i++){
            char x = arr[i][waistj+1];
            if(x=='*'){
                rightLeg++;
            } else break;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(hearti+" "+heartj+"\n");
        bw.write(leftArm+" "+rightArm+" "+waist+" "+leftLeg+" "+rightLeg);
        bw.flush();
        bw.close();
    }
}