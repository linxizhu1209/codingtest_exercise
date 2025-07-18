import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i=0;i<tc;i++){
            StringTokenizer token =new StringTokenizer(br.readLine());
            int people = Integer.parseInt(token.nextToken());
            int[] arr = new int[people];
            int sum = 0;
            for(int j=0;j<people;j++){
                arr[j] = Integer.parseInt(token.nextToken());
                sum += arr[j];
            }
            int avg = sum/people;
            int count = 0;
            for(int j=0;j<people;j++){
                if(arr[j]>avg){
                    count++;
                }
            }
            double total = ((double) count / people)*100;
            System.out.println(String.format("%.3f", total)+"%");

        }
    }
}
