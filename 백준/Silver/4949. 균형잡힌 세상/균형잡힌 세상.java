
import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            Stack<Character> stack = new Stack<>();
            String str = in.nextLine();
            boolean pallen = true;
            String replaceTest = str.replaceAll("[^()\\[\\]]", "");
            if (!str.equals(".")) {
                for (char x : replaceTest.toCharArray()) {
                    if (x == '(' || x == '[') {
                        stack.add(x);
                    } else if (x == ')' || x == ']') {
                        if (stack.isEmpty() || x == ']' && stack.peek() != '[') {
                            System.out.println("no");
                            pallen = false;
                            break;
                        } else if (stack.isEmpty() || x == ')' && stack.peek() != '(') {
                            System.out.println("no");
                            pallen = false;
                            break;
                        } else stack.pop();
                    }
                }
                if (stack.isEmpty() && pallen) System.out.println("yes");
                else if (!stack.isEmpty()&&pallen) System.out.println("no");
            }
        }
        in.close();
    }
}
