import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        String[] numarr = br.readLine().split(" ");
        int[] numlist = new int[n];
        for(int i=0;i<n;i++){
            numlist[i] = Integer.parseInt(numarr[i]);
        }
        Arrays.sort(numlist);
        System.out.println(numlist[numlist.length-k]);
    }
   }
