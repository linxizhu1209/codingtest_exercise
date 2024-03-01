package chapter3;

import java.util.*;

public class test2 {
    // 강의 참고 코드
    public ArrayList<Integer> solution(int[] arr1, int[] arr2, int n1, int n2) {
    ArrayList<Integer> answer = new ArrayList<>();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    int p1=0, p2=0;
    while(p1<n1 && p2<n2) {
        if (arr1[p1] == arr2[p2]) {
            answer.add(arr1[p1++]);
            p2++;
        } else if (arr1[p1] < arr2[p2]) p1++;  // arr1과 arr2는 오름차순 정렬이 되어있기에,
            // arr1[p1]<arr2[p2]라는 건 arr1[p1]이 arr2에 겹치는 수가 없다는 것을 뜻하므로 바로 p1++; 해줌
        else p2++; // 이는 arr1[p1]>arr2[p2] 인 경우이므로, arr1에는 arr2[p2]와 겹치는게 있을수가 없으므로 바로 p2++;
    }
    return answer;
    }



    // 내가 짠 코드
//    public Set<Integer> solution(int[] arr1, int[] arr2, int n1, int n2) {
//        Set<Integer> numSet = new HashSet<>();
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//        int p1 = 0, p2 = 0;
//
//        while (p1 < n1 && p2 < n2) {
//            int count = 0;
//            if (arr1[p1] == arr2[p2]) {
//                numSet.add(arr1[p1++]);
//                p2=0;
//            } else if(arr1[p1]!=arr2[p2] && p2==n2-1){
//                p2=0;
//                p1++;
//            }
//            else {
//                p2++;
//                count++;
//            }
//            if (count == n2) {
//                p1++;
//                p2=0;
//            }
//        }
//    return numSet;
//    }

    public static void main(String[] args) {
        test2 T = new test2();
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

