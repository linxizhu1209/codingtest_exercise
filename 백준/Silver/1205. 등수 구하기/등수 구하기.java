
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 1. 각 노래마다 랭킹리스트 존재
     * 2. 랭킹리스트는 해당 노래에서 얻은 점수가 내림차순으로 저장
     * 3. 숫자의 개수 N, 신규 점수, 랭킹리스트에 들어갈 수 있는 숫자 P개가 주어짐
     *
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        Arrays.fill(arr, Integer.MIN_VALUE);
        boolean flag = false;
        if(n!=0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // lt rt로 하고, lt+1 의 값을 등수로, 만약 lt와 rt가 같다면 계속 lt+1을 등수로 부여,
            // lt보다 rt가 작아지면 rt위치로 lt를 옮기고 lt+1 등수 부여
            // 만약 arr[rt] 보다 주어진 숫자가 크다면 해당 숫자를 lt+1 등수 부여하고 return, 등수 출력, 플래그 설정
            // 만약 플래그 false인채로 끝낫다면 -1 출력
            int lt = 0;
            int rt = 0;

            while (!flag) {

                if (newScore > arr[rt]) {
                    flag = true;
                    if (rt-1>=0 && newScore == arr[rt - 1]) {
                        System.out.println(lt+1);
                    } else{
                        System.out.println(rt + 1);
                    }
                }
                if (arr[lt] > arr[rt]) {
                    lt = rt;
                }
                rt++;
                if (rt > m - 1) {
                    break;
                }
            }
        }

        if(n==0){
            System.out.println(1);
        } else if(!flag){
            System.out.println(-1);
        }
        //
    }
}
