package Programmers입문;

import java.util.Scanner;

public class CountK {
    public int solution(int i, int j, int k){
        int answer = 0;
        String k2 = String.valueOf(k);
        char k3 = k2.charAt(0);
        for(int o=i;o<=j;o++){
            String str = o+"";
            for(char x:str.toCharArray()){
                if(x==k3) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CountK t = new CountK();
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        System.out.println(t.solution(i,j,k));

    }
}
