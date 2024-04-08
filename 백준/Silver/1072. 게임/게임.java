
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        long x = Long.parseLong(str[0]);
        long y = Long.parseLong(str[1]);
        long z = (y*100)/x;
        long min=0;
        long max = x*2;
        long gameMin = Integer.MAX_VALUE;
        boolean check = false;
        if(z>=99) System.out.println(-1);
        else {
            while (min <= max) {
                Long mid = (min + max) / 2;
                if (((y+mid) * 100) / (x+mid) > z) {
                    gameMin = Math.min(gameMin, mid);
                    check = true;
                    max = mid - 1;
                } else min = mid + 1;
            }
            if(!check) System.out.println(-1);
            else System.out.println(gameMin);
        }
    }
}
