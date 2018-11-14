using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Node{
    public Node left,right;
    public int data;
    public Node(int data){
        this.data=data;
        left=right=null;
    }
}
class BFS{

    static void levelOrder(Node root){
  		//Write your code here
        List<Node> queue = new List<Node>();
        queue.Add(root);
        
        while(queue.Count > 0) {
            Node poppedElement = queue.ElementAt(0);
            Console.Write(poppedElement.data + " ");
            queue.Remove(poppedElement);
            if(poppedElement.left != null) {
                queue.Add(poppedElement.left);    
            }
            
            if(poppedElement.right != null) {
                queue.Add(poppedElement.right);
            }
        }
    }
static Node insert(Node root, int data){
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
    static void Main(String[] args){
        Node root=null;
        int T=Int32.Parse(Console.ReadLine());
        while(T-->0){
            int data=Int32.Parse(Console.ReadLine());
            root=insert(root,data);            
        }
        levelOrder(root);
        
    }
}