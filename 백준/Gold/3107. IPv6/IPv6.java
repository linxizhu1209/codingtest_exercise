
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split(":");
        int strLength = str.length();
        int length = arr.length;
        StringBuilder sb;
        String[] newArr = new String[8];
        if(length==8){
            for(int i=0;i<8;i++){
                int num = arr[i].length();
                int count = 4-num;
                sb = new StringBuilder("0".repeat(count)+arr[i]);
                arr[i] = sb.toString();
            }
        }
        else{
            int lt =0;
            int rt =strLength-1;
            StringBuilder sbLt = new StringBuilder();
            StringBuilder sbRt = new StringBuilder();
            int LcolonCount =0;
            int RcolonCount = 0;
            int ltCount = 0;
            int rtCount = 0;
            boolean Lcheck = false;
            boolean Rcheck = false;
            while(lt<=rt) {
                if (str.charAt(lt) == ':') {
                    if (Lcheck) {
                    } else {
                        sbLt = sbLt.insert(0, "0".repeat(4 - ltCount));
                        newArr[LcolonCount++] = sbLt.toString();
                        sbLt = new StringBuilder();
                        Lcheck = true;
                        ltCount = 0;
                        lt++;
                    }
                } else {
                    sbLt.append(str.charAt(lt));
                    lt++;
                    ltCount++;
                    Lcheck = false;
                }
                if(str.charAt(rt)==':') {
                    if (Rcheck) {
                    } else {
                        sbRt = sbRt.reverse().insert(0, "0".repeat(4 - rtCount));
                        newArr[8 - RcolonCount - 1] = sbRt.toString();
                        sbRt = new StringBuilder();
                        RcolonCount++;
                        Rcheck = true;
                        rt--;
                        rtCount = 0;
                    }
                }
                else{
                        sbRt.append(str.charAt(rt));
                        rt--;
                        rtCount++;
                        Rcheck=false;
                    }
                }

            for(int i=0;i<8;i++){
                if(newArr[i]==null) {
                    newArr[i] = "0000";
                }
            }
            arr = newArr;
            }

        System.out.print(arr[0]);
        for(int i=1;i<8;i++){
            System.out.print(":"+arr[i]);
        }
    }
}
