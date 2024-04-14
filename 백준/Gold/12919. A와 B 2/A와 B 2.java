import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder s;
    static boolean possible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());
        Main ab= new Main();
        possible = false;
        ab.dfs(t);
        if(possible) System.out.println(1);
        else  System.out.println(0);
    }
    private boolean dfs(StringBuilder t){
        if(possible) return possible;
        if(s.toString().equals(t.toString())) {
            possible = true;
            return possible;
        }
        if(s.length()>=t.length()) return false;
        else{
            if(t.lastIndexOf("A")==t.length()-1){
                dfs(t.deleteCharAt(t.length()-1));
                t.append("A");
            }
            if(possible) return possible;
            if(t.charAt(0)=='B') {
                dfs(t.deleteCharAt(0).reverse());
                t.append("B").reverse();
            }
        }
        return possible;
    }
}
