package chapter6;


import java.util.Arrays;
import java.util.Scanner;

public class test8 {
    public int solution(int n, int m, int[] arr) {
/** 이분검색이란?
 *  검색할 범위를 반으로 줄여가며 찾아가는 검색
 *  정렬된 데이터에 사용할 수 있다.
 *  찾고싶은데이터(키 값), 시작 위치, 종료위치, 중간 위치가 필요함
 *  중간위치와 키 값을 비교하여 같다면 검색 종료, 작다면 왼쪽 데이터를 다시 검사, 크다면 오른쪽 데이터를 다시 검사
 */
        Arrays.sort(arr);
        int answer=0;
        int f = 0; // 처음 숫자
        int l = n-1; // 마지막 숫자
        while(f!=l){
            if(arr[(l+f)/2]==m){
                return ((l+f)/2)+1;
            }
            else if(arr[(l+f)/2]>m){
                l=((l+f)/2)-1;
            }
            else if(arr[(l+f)/2]<m){
                f= ((l+f)/2)+1;
            }
        }
        answer = f+1;
        return answer;

    }

    public static void main(String[] args) {
        test8 T = new test8();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n,m,arr));
    }
}

