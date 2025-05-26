
import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /**
     * 1. 3000자리까지 이어붙인수가 주어짐. 최악의 경우 n이 30000까지 갈 수 있는데, 3000자리가 주어지더라도 0~9까지 10개가 한자리에 주어지기때문
     * 2. 기존에 풀었던 방식은 단순히 contains로 풀었는데, contains로 풀면안되고, i를 배열로 만들어서, 해당 배열을 끝까지 탐색후 i를 올리기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;
        int length = str.length();
        int min = 1;
        for(int i=1;i<=30000;i++){
            String istr = String.valueOf(i);

            for(int j=0;j<istr.length();j++){
                char x = str.charAt(count);
                if(istr.charAt(j)==x){
                    count++;
                    min = i;
                }
//                else {
//                    min = i;
//                    break;
//                }
                /**
                else 문 주석을 풀었을때에는 오답이 되는데, 그 이유는 첫째자리부터 일치하지 않으면 바로 break를 하니까, 그 뒤에 숫자가 맞더라도 체크를 안해서 결론적으로 더 큰수를 출력해버림
                **/
                if(count==length){
                    break;
                }
            }
            if(count==length){
                break;
            }
        }
        System.out.println(min);

    }
}