
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[n+1];
        isPrime[0] = true;
        isPrime[1] = true; // true ==> 소수가 아니다.
        int count = 0;
        if(n>1) {
            for (int i = 2; i * i <= n; i++) {
                if (!isPrime[i]) { // 소수라면~ false 라면~
                    for (int j = i * i; j <= n; j += i) { // 소수의 배수는 소수가 아니다
                        isPrime[j] = true;
                    }
                }
            }
            ArrayList<Integer> primelist = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!isPrime[i]) primelist.add(i); // 소수 모아논 리스트
            }

            int lt = 0;
            int rt = 0;
            int sum = primelist.get(lt);
            while (rt < primelist.size() && lt < primelist.size()) {
                if (sum == n) {
                    count++;
                    sum -= primelist.get(lt++);
                } else if (sum > n) {
                    sum -= primelist.get(lt++);
                } else {
                    if (++rt < primelist.size()) sum += primelist.get(rt);
                }
            }
        }
        System.out.println(count);
    }
}
