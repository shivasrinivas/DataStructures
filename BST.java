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
class BST{
	public static int getHeight(Node root){
      //Write your code here
        int maxHeight = 1;
        int leftHeight = root.left == null ? 0 : getHeight(root.left) + 1;
        int rightHeight = root.right == null ? 0 : getHeight(root.right) + 1;
        if(leftHeight == 0 && rightHeight == 0) {
        	System.out.println("node: " + root.data + " left: " + leftHeight + " right:" + rightHeight);
            return 0;
        } else if(leftHeight > rightHeight) {
            maxHeight += leftHeight;
            System.out.println("node: " + root.data + " left: " + leftHeight + " right:" + rightHeight);
        } else {
            maxHeight += rightHeight;
            System.out.println("node: " + root.data + " left: " + leftHeight + " right:" + rightHeight);
        }
        return maxHeight;
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
        int height=getHeight(root);
        System.out.println(height);
    }
}