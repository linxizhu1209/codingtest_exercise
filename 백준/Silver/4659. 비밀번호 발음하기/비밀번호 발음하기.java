
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException {

        /**
         * 1. 모음(a,e,i,o,u) 하나를 반드시 포함
         * 2. 모음이 3개 또는 자음이 3개 연속 x
         * 3. 같은 글자 연속 x. 다만 ee와 oo는 허용
         */
        Scanner in = new Scanner(System.in);
        boolean isEnd = false;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(!isEnd){
            String pwd = in.nextLine();
            if(pwd.equals("end")){
                isEnd = true;
                break;
            }
            boolean isOkay = true;
            if(!pwd.contains("a")&&!pwd.contains("e")&&!pwd.contains("i")&&!pwd.contains("o")&&!pwd.contains("u")){
                bw.write("<" + pwd + "> is not acceptable." + "\n");
                continue;
            };
            int mcount = 0; // 모음 count가 연속 3번되면 out, count는 자음만나는순간 reset
            int jcount = 0; // 자음 count가 연속 3번되면 out, count는 모음만나는순간 reset
            char preWord = ' '; // 직전 글자. 직전글자가 현 글자와 같으면 out, 다만 ee와 oo는 제외
            for(char x: pwd.toCharArray()) {
                if (preWord == x) {
                    if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                        mcount++;
                        jcount = 0;
                    } else {
                        jcount++;
                        mcount = 0;
                    }

                    if (x != 'e' && x != 'o') {
                        // 근데 모음이 연속 3번이면 out이니까 얘도 count가 3인지 확인
                        if (mcount == 3) {
                            bw.write("<" + x + "> is not acceptable." + "\n");
                            mcount = 0;
                            isOkay = false;
                            break;
                        }
                        bw.write("<" + pwd + "> is not acceptable." + "\n");
                        isOkay = false;
                        break;
                    }
                    if (mcount == 3 || jcount == 3) {
                        bw.write("<" + pwd + "> is not acceptable." + "\n");
                        isOkay = false;
                        break;
                    }
                } // if문 끝
                else {
                // preword != x 인 경우에도 모음 자음 연속성 체크
                if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                    mcount++;
                    jcount = 0;
                } else {
                    jcount++;
                    mcount = 0;
                }
                if (mcount == 3 || jcount == 3) {
                    bw.write("<" + pwd + "> is not acceptable." + "\n");
                    isOkay = false;
                    break;
                }
                }

                preWord = x;
            }
            if(isOkay){
                bw.write("<"+pwd+"> is acceptable." + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}