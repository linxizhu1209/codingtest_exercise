package Programmers입문;

import java.util.*;

public class 약수구하기 {
    public int[] solution(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(n%i==0) {
                list.add(i);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        약수구하기 t = new 약수구하기();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(Arrays.toString(t.solution(n)));
    }
}
