
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner in = new Scanner(System.in);
        int[] alpha = new int[26];
        String str;
        while((str = br.readLine()) != null) {
            for(char x: str.toCharArray()){
                if(x!=' ') alpha[x - 'a']++;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int x: alpha){
            max = Math.max(max, x);
        }
        for(int i=0;i<26;i++){
            if(alpha[i] == max){
                System.out.print((char) (i+'a'));
            }
        }
    }
}