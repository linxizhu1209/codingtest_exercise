package chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class test3 {
    // 강의 참고 코드
    public List<Integer> solution(int n1,int n2, int[] arr){
      ArrayList<Integer> answer = new ArrayList<>();
      HashMap<Integer,Integer> HM = new HashMap<>();
      for(int i=0;i<n2-1; i++){
          HM.put(arr[i],HM.getOrDefault(arr[i],0)+1);
      }
      int lt=0;
      for(int rt=n2-1;rt<n1;rt++){
          HM.put(arr[rt],HM.getOrDefault(arr[rt],0)+1);
          answer.add(HM.size());
          HM.put(arr[lt],HM.get(arr[lt])-1);
          if(HM.get(arr[lt])==0) HM.remove(arr[lt]);
          lt++;
      }
    return answer;
    }

    // 내가 짠 코드
//    public List<Integer> solution(int n1,int n2, int[] arr){
//        List<Integer> numList = new ArrayList<>();
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<n2;i++){
//            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
//        }
//        numList.add(map.size());
//        for(int i=n2;i<n1;i++) {
//            if (map.get(arr[i - n2]) == 1) map.remove(arr[i - n2]);
//            else {
//                map.put(arr[i - n2], map.get(arr[i - n2]) - 1); // 창문의 첫번째 것 지우고 한 칸 뒤로 미는 과정
//            }
//            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // getOrDefault 는 있으면 x의 value, 없으면 default값을 반환함
//            numList.add(map.size());
//        }
//        return numList;
//    }

    public static void main(String[] args) {
        test3 T = new test3();
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int[] arr = new int[num1];
        for(int i=0;i<num1;i++){
            arr[i] = in.nextInt();
        }
        List<Integer> result = T.solution(num1,num2,arr);
        for(int x:result){
            System.out.print(x+" ");
        }

    }
}

