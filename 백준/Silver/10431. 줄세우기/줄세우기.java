import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        int p = Integer.parseInt(in.nextLine()); // 테스트 케이스 수
        // 우선 맨뒤에 들어가기
        // 내 앞에 키큰애가 한명이라도 있으면 1등으로 서기 (max로 판단? max보다 지금 숫자가 더 크다면 키큰애가 없다는거니까)
        // 뒤에 있는 애들은 한칸씩 밀리기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<p;i++){
            StringTokenizer token =  new StringTokenizer(in.nextLine());
            int tc = Integer.parseInt(token.nextToken());
            int[] arr = new int[20];
            for(int j=0;j<20;j++){
                arr[j] = Integer.parseInt(token.nextToken());
            }

            int moveCount = 0;

            for(int k=0;k<21;k++){
                for(int m=k+1;m<20;m++){
                   if(arr[m] < arr[k]){
                       moveCount++;
                   }
                }
            }

            bw.write(tc+" "+moveCount+"\n");

        }
        bw.flush();
        bw.close();
    }
}