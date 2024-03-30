
import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> wordSet = new HashSet<>();
        boolean check = false;
        boolean lastblank = false;
        boolean onlyone = false;
        StringBuilder sb = new StringBuilder();
        char[] word = new char[2];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            if(n==1) {
                onlyone=true;
                break;
            }
            if(str.equals("?")){
                if(i==0) {
                    check=true;
                    lastblank=true;
                    continue;
                }
                if(i==n-1){
                    word[0]=sb.reverse().charAt(0);
                    lastblank=true;
                    continue;
                }
                word[0] = sb.reverse().charAt(0); // 전의 str.charAt을 가져와야함
                check = true;
                continue;
            }
            if(check) {
                word[1] = str.charAt(0);
                check = false;
            }
            sb.append(str);
            wordSet.add(str);
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            String str = br.readLine();
            if(onlyone) {
                System.out.println(str);
                break;
            }
            if(!wordSet.contains(str)){
                if(!lastblank&&str.charAt(0)==word[0]&&str.charAt(str.length()-1)==word[1]) System.out.println(str);
                else if(lastblank&&str.charAt(0)==word[0]||lastblank&&str.charAt(str.length()-1)==word[1]) System.out.println(str);
            }
        }
    }
}