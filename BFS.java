import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class BFS{
static void levelOrder(Node root){
    //Write your code here
    Queue<Node> bfs = new LinkedList();
    bfs.offer(root);
    doBfs(bfs, root);
    while(bfs.size() > 0) {
        Node node = bfs.poll();
        System.out.print(node.data + " ");
    }
}

static void doBfs(Queue bfs, Node currentNode) {
    if(currentNode != null) {
        if(currentNode.left != null) {
            bfs.offer(currentNode.left);
        }
        if(currentNode.right != null) {
            bfs.offer(currentNode.right);
        } 
        doBfs(bfs, currentNode.left);
        doBfs(bfs, currentNode.right);
    }  
}
public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }	
}