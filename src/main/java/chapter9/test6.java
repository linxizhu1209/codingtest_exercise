package chapter9;

import java.util.Scanner;

public class test6 {
    static int[] unf;
    public static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa]=fb;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int m= in.nextInt();
        unf=new int[n+1];
        for(int i=1;i<=n;i++) unf[i]=i;
        for(int i=1;i<=m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            Union(a,b);
        }
        int a=in.nextInt();
        int b=in.nextInt();
        int fa=Find(a);
        int fb=Find(b);
        if(fa!=fb) System.out.println("NO");
        else System.out.println("YES");
    }


}
