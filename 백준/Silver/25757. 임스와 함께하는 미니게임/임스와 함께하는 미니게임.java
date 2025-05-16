import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

        /**
         * 1. Y (2명) F (3명) O (4명)
         * 2. 여러번 임스와 함께 플레이 x.
         * 3. 임스와 함께 플레이하는 사람 중 동명이인은 x
         */
        Scanner in = new Scanner(System.in);
        StringTokenizer token = new StringTokenizer(in.nextLine());
        int n = Integer.parseInt(token.nextToken());
        String game = token.nextToken();
        int reqMem = 0; // 플레이할때 임스제외 필요한 멤버 수
        if(game.equals("Y")){
            reqMem = 1;
        } else if(game.equals("F")){
            reqMem = 2;
        } else {
            reqMem = 3;
        }
        Set<String> memberSet = new HashSet<>();
        int play = 0; // 플레이 수
        int count = 0; // 현재 참가자수
        for(int i = 0; i < n; i++) {
            String mem = in.nextLine();
            if(memberSet.contains(mem)){
                // 이미 참여했던 멤버일때
            } else {
                // 처음 참여하는 멤버일때
                count++;
                memberSet.add(mem);
            }

            if(count == reqMem){
                count = 0; // count 다시 리셋
                play++;
            }
        }
        System.out.println(play);
    }
}