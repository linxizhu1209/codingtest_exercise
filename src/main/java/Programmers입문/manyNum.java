package Programmers입문;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class manyNum {
    public int solution(int[] array){
        int answer = 0;
        int count = 0;
        int maxcount=0;
        Map<Integer,Integer> counting = new HashMap<>();
        for(int x:array) {
            count = counting.getOrDefault(x, 0) + 1;
            if (maxcount < count) {
                maxcount = count;
                answer = x;
            } else if (maxcount == count) {
                answer = -1;
            }
            counting.put(x, count);

        }
        return answer;
        /**
         * array배열의 max값+1만큼의 배열 arr을 만들어서 개수를 카운팅하는 방식
         */
//        int length = array.length;
//        int max = Arrays.stream(array).max().orElse(0);
//        if(length==1&&array[0]!=0) return array[0];
//        if(length==1&&array[0]==0) return 0;
//        if(max==0) return 0;
//        int[] arr = new int[max+1];
//        for(int x:array){
//            arr[x]=arr[x]+1;
//        }
//        int[] arr2 = arr.clone();
//        Arrays.sort(arr);
//        if(arr[max]==arr[max-1]) return -1;
//        else{
//            for(int i=0;i<arr2.length;i++){
//                if(arr[max]==arr2[i]) return i;
//            }
//        }
//        return 0;
    }

    public static void main(String[] args) {
        manyNum t= new manyNum();
        int[] array = {0,0,0};
        System.out.println(t.solution(array));

    }
    }
