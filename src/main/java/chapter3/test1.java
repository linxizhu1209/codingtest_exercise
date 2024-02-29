package chapter3;

import java.util.*;

public class test1 {
    // 강의 참고 코드
    public ArrayList<Integer> solution(int[] arr1, int[] arr2, int n1, int n2){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        while(p1<n1 && p2<n2){
            if(arr1[p1]<arr2[p2]) {
                answer.add(arr1[p1++]);
            }
            else{
                answer.add(arr2[p2++]);
            }
        }
        while (p1<n1){
            answer.add(arr1[p1++]);
        }
        while (p2<n2){
            answer.add(arr2[p2++]);
        }
        return answer;
    }

    // 내가 짠 코드
//    public int[] solution(int[] arr1, int[] arr2, int n1, int n2){
//        List<Integer> numList = new ArrayList<>();
//        for(int i=0;i<n1;i++){
//            numList.add(arr1[i]);
//        }
//        for(int i=0;i<n2;i++){
//            numList.add(arr2[i]);
//        }
//        int[] result = numList.stream().mapToInt(i->i).toArray();
//        Arrays.sort(result);
//        return result;
//    }

    public static void main(String[] args) {
        test1 T = new test1();
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int[] arr1 = new int[num1];
        for(int i=0;i<num1;i++){
            arr1[i] = in.nextInt();
        }
        int num2 = in.nextInt();
        int[] arr2 = new int[num2];
        for(int i=0;i<num2;i++){
            arr2[i] = in.nextInt();
        }
        ArrayList<Integer> result = T.solution(arr1,arr2,num1,num2);
        for(int x:result){
            System.out.print(x+" ");
        }
    }
}

