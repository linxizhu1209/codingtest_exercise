import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                answer+=set.size();
                set.clear();
            } else {
                set.add(str);
            }
        }
        answer+=set.size();
        System.out.println(answer);
    }
}