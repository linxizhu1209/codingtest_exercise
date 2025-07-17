import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in  = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int newNum = n;
        int cycle = 0;
        while (true){
            if(newNum == n && cycle != 0){
                break;
            }
            String newnumStr = "";
            if(newNum < 10){
                StringBuilder sb = new StringBuilder(String.valueOf(newNum));
                sb.insert(0,"0");
                newNum = Integer.parseInt(sb.toString());
                newnumStr = String.valueOf(newNum);
            } else {
                newnumStr = String.valueOf(newNum);
            }
            int sum = 0;
            for(int i=0;i<newnumStr.length();i++){
                sum += newnumStr.charAt(i)-'0';
            }
            String sumStr = String.valueOf(sum);
            char x = sumStr.charAt(sumStr.length()-1);
            char y = newnumStr.charAt(newnumStr.length()-1);
            String xy = y+""+x;
            newNum = Integer.parseInt(xy);
            cycle++;
        }
        System.out.println(cycle);
    }
}
