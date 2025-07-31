import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            str = str.toLowerCase();
            if(str.equals("#")) break;
            int count = 0;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u'){
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}