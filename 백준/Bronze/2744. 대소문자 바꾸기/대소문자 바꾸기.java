
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder builder = new StringBuilder();
        for(char x: str.toCharArray()) {
            if(Character.isLowerCase(x)) builder.append(String.valueOf(x).toUpperCase());
            else builder.append(String.valueOf(x).toLowerCase());
        }
        System.out.println(builder.toString());
    }
}