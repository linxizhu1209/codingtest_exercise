import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i=0;i<tc;i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            if(x<24 && y<60) System.out.print("Yes ");
            else System.out.print("No ");

            if(x==0 || y==0) System.out.println("No");
            else if(x==1 || x==3 || x==5 || x==7 || x==8 || x==10 || x==12){
                if(y<32) System.out.println("Yes");
                else System.out.println("No");
            }
            else if(x==4 || x==6 || x==9 || x==11){
                if(y<31) System.out.println("Yes");
                else System.out.println("No");
            }
            else if (x==2 && y<30) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");

            }
        }
    }
}