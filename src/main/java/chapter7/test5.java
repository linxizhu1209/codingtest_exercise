package chapter7;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data=val;
        lt=rt=null;
    }
}

public class test5 {
    Node root;
  // 강의 참고 코드
    public void DFS(Node root) { // 1번 노드!
        if (root == null) return;
        else {
            System.out.println(root.data+" "); //전위순회
            DFS(root.lt);
            System.out.println(root.data+" "); //중위순회
            DFS(root.rt);
            System.out.println(root.data+" "); //후위순회
        }
    }

    public static void main(String[] args) {
        test5 tree = new test5();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.DFS(tree.root);

    }
    }


