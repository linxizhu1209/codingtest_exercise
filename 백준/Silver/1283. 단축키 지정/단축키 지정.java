import java.io.*;
import java.util.*;

public class Main {
    /**
     * 1. "단어" 의 각 앞글자를 우선 검사. 만약 앞글자가 모두 단축키가 안된다면, 하나씩 이동하면서 확인
     * 2. 단축키로 어느것도 설정할 수 없다면 그냥 return
     */

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Set<String> set = new HashSet<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            String str = in.nextLine();
            String[] arr = str.split(" ");
            boolean isFinish = false;
            int index = 0;
            int count = 0;
            for (String str2 : arr) {
                String firstWord = String.valueOf(str2.charAt(0)).toUpperCase();
                if (!set.contains(firstWord)) {
                    set.add(firstWord);
                    isFinish = true;
                    index = str.indexOf(firstWord); // 인덱스를 어떻게 찾아서 괄호를 붙일거냐?
                    break;
                }
                count++;
            }
            if (!isFinish) { // 앞글자가 단축키안될때 하나씩 돌면서
                boolean isFinish2 = false;
                for (char c : str.toCharArray()) {
                    String c2 = String.valueOf(c).toUpperCase();
                    if (!set.contains(c2) && !isFinish2 && c != ' ') {
                        set.add(c2);
                        sb.append("[").append(c).append("]");
                        isFinish2 = true;
                    } else {
                        sb.append(c);
                    }
                }
                bw.write(sb + "\n");
            } else { // 앞글자가 단축키일때,
                int count2 = 0;
                boolean isFirst = true;
                for (char c : str.toCharArray()) {
                    if(c == ' '){
                        count2++;
                        isFirst = true;
                        sb.append(c);
                        continue;
                    }
                    if(count == count2 && isFirst){
                        sb.append("[").append(c).append("]");
                        isFirst = false;
                    } else {
                        sb.append(c);
                    }
                }
                bw.write(sb + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}