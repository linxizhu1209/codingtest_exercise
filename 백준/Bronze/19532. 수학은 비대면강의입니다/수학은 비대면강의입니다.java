
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        int d = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());
        int f = Integer.parseInt(token.nextToken());
        int newa=a*d;
        int newb=b*d;
        int newc = c*d;
        int newd=d*a;
        int newe = e*a;
        int newf= f*a;
        if(a==0) {
            int y = c/b;
            int x = (f-(e*y))/d;
            System.out.println(x+" "+y);
        }
        else if(d==0){
            int y = f/e;
            int x = (c-(b*y))/a;
            System.out.println(x+" "+y);
        }
        else if(b==0){
            int x = c/a;
            int y = (f-(d*x))/e;
            System.out.println(x+" "+y);
        }
        else if(e==0){
            int x = f/d;
            int y = (c-(a*x))/b;
            System.out.println(x+" "+y);
        }
        else if(newb==newe) System.out.println(0+" "+0);
        else {
            int n = newc - newf;
            int y = n / (newb - newe);
            int x = (((b * -1) * y) + c) / a;
            System.out.println(x + " " + y);
        }
    }
}
