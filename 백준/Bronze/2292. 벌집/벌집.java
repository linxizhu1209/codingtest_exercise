
import java.io.IOException;
import java.util.*;
// 1+n , +6n, + 6n 이때 n은 0부터 시작

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        long n = Long.parseLong(in.nextLine());
        long sum = 1;
        long m = 1;
        while(true){
            if(n==1) break;
            sum = sum + (6*m);
            if(n<=sum){
                break;
            }
            m+=1;
        }
        if(n==1) System.out.println(1);
        else System.out.println(m+1);
    }
}