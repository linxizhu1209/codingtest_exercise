package chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    public int v1;
    public int cost;

    public Edge(int v1, int cost) {
        this.v1 = v1;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost-o.cost;
    }
}


public class test8 {
    static int[] ch;
    static int answer;
    static ArrayList<ArrayList<Edge>> graph;
    public void solution(int vex,int cost){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        Edge edge = new Edge(vex,cost);
        pQ.offer(edge);
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int vex2 = tmp.v1;
            if(ch[vex2]==0){
                ch[vex2]=1;
                answer+= tmp.cost;
            }
            for(Edge eg :graph.get(vex2)){
                if(ch[eg.v1]==0){
                    pQ.offer(eg);
                }
            }
        }
    }
    public static void main(String[] args){
        test8 T = new test8();
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int m= in.nextInt();
        ch=new int[n+1];
        graph=new ArrayList<ArrayList<Edge>>();
        for(int i=0;i<=n;i++) {
            ch[i]=0;
            graph.add(new ArrayList<Edge>());
        }
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();
            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }

        T.solution(1,0);
        System.out.println(answer);
    }
}
