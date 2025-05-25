
import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /**
     * 1. 시작하고 지난 일수 N, 측정해볼 일수 X
     * 2. N개의 숫자 주어짐
     * 3. 슬라이딩윈도우로 하나씩 밀면서 왼쪽빼고, 오른쪽더하고 하면될듯
     * 4. 기존 max값과 비교하고, 기존 max보다 크다면 max갱신, 이때 count 1로 초기화. max와 같다면 count++ 해줘서 max를 찍는 연속일자가 몇번인지 출력
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int x = Integer.parseInt(token.nextToken());
        int[] arr = new int[n];
        token = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int xcount = 0;
        int lt = 0; // index 0부터이므로
        int rt = x; // x-1 까지 sum했으니.
        int sum = 0;
        for(int i=0;i<x;i++){
            sum += arr[i];
        }

        int max = sum;
        int count = 1;
        while(rt<n){
            sum = sum - arr[lt];
            sum = sum + arr[rt];
            if(sum > max){
                max = sum;
                count = 1;
            }
            else if (sum == max){
                count++;
            }
            lt++;
            rt++;
        }
        if(max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}