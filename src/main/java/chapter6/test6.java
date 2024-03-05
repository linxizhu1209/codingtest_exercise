package chapter6;
import java.util.*;

public class test6 {
    public List<Integer> solution(int n,int[] arr){
        List<Integer> result = new ArrayList<>();
        // 강의 참고 코드
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for(int i=0;i<n;i++){
            if(arr[i]!=tmp[i]) result.add(i+1);
        }


        // 내가 짠 코드
        //        int lt=0;
//        int rt=0;
//        for(int i=1;i<n;i++){
//            if(arr[i-1]>arr[i]&&rt==0){
//                for(int j=0;j<n;j++){
//                    if(arr[j]==arr[i-1]){
//                        lt=j; // 철수 위치
//                        rt=i;
//                        break;
//                    }
//                }
//            }
//            else if(arr[i-1]>arr[i]) rt=i;
//        }
//        result.add(lt+1);
//        result.add(rt+1);
        return result;
    }


    public static void main(String[] args) {
        test6 T = new test6();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        List<Integer> result = T.solution(n,arr);
        for(int x: result){
            System.out.print(x+" ");
        }}
}


