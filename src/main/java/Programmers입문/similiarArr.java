package Programmers입문;

import java.util.Arrays;

public class similiarArr {

    public int solution(String[] s1, String[] s2){
        int answer=0;
        Arrays.sort(s1);
        Arrays.sort(s2);
        for(String x: s1){
            for(int i=0;i<s2.length;i++){
                if(x.equals(s2[i])){
                    answer++;
                    break;
                }
            }
        }
        return answer;


    }

    public static void main(String[] args) {
        similiarArr t = new similiarArr();
        String[] s1 = {"a","b","c"};
        String[] s2 = {"com","b","d","p","c"};
        System.out.println(t.solution(s1,s2));
    }



}
