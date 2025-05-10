
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
// 1+n , +6n, + 6n 이때 n은 0부터 시작

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        long n = Long.parseLong(in.nextLine());
//        Stack<String> stack = new Stack<>();
        String[] str = new String[(int)n];
        int pos1 = 0;
        for(int i=0; i<n; i++){
//            stack.push(in.nextLine());
            String kbs = in.nextLine();
            str[i] = kbs;
            if(kbs.equals("KBS1")){
                pos1 = i;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<pos1;i++) {
            bw.write("1");
        }
        for(int i=0;i<pos1;i++) {
            bw.write("4");
        }
        boolean kbs2 = false;
        int m = 0;
        int pos2 = 0;
        while(!kbs2){
            if(str[m].equals("KBS2")){
                pos2 = m;
                kbs2 = true;
                if(pos2<pos1){
                    //kbs2가 kbs1보다 위에있다면
                    bw.write("1");
                    pos2 += 1;
                }
            } else {
                m++;
                bw.write("1");
            }
        }

        for(int i=pos2;i>1;i--){
            bw.write("4");
        }
        bw.flush();
        bw.close();
    }
}