package chapter7;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data=val;
        lt=rt=null;
    }
}

public class test9 {
    Node root;
//    public int DFS(int L, Node root) {
//        if(root.lt==null && root.rt==null) return L;
//        else return Math.min(DFS(L+1,root.lt),DFS(L+1,root.rt));
//    }

    public int BFS(int L,Node root){
        Queue<Node> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++) {
                Node cur = q.poll();
                if (cur.lt == null && cur.rt == null) return L;
                if (cur.lt != null) q.offer(cur.lt);
                if (cur.rt != null) q.offer(cur.rt);
                }
            L++;
        }
        return L;
    }


    public static void main(String[] args) {
        test9 tree = new test9();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(0,tree.root));
    }
}

