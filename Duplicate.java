import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class Duplicate
{
public static Node removeDuplicates(Node head) {
      //Write your code here
        List<Integer> exists = new ArrayList<Integer>();
        Node currentNode = head;
        Node previousNode = null;
        while(currentNode != null) {
        	System.out.println("exists: ");
        	for(int i = 0; i < exists.size(); i++) {
        		System.out.println(exists.get(i) + " ");
        	}
        	System.out.println("current: " + currentNode.data);
            if(exists.contains(currentNode.data)) {
            	System.out.println("in if");
                previousNode.next = currentNode.next;
                //previousNode = previousNode.next;
                //currentNode = currentNode.next;
            } else {
            	System.out.println("in else");
                exists.add(currentNode.data);
                previousNode = currentNode;
                //currentNode = currentNode.next;
            }
            currentNode = currentNode.next;
        }
        return head;
    }
    public static  Node insert(Node head,int data)
     {
        Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
        {
              Node start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              Node head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

       }
    }