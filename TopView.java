import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /* 
    
    class Node 
        int data;
        Node left;
        Node right;
    */

    public static HashMap nodes;

    public static void topView(Node root) {
        nodes = new HashMap<Integer, Node>();
        createMap(0, root);

        Map<Integer, Node> map = new TreeMap<>(nodes);
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Node value = map.get(key);
            System.out.print(value.data + " "); 
        }
    }

    public static void createMap(int level, Node root) {
        if(root == null) {
            return;
        }
        if(level == 0) {
            if(nodes.isEmpty()) {
                nodes.put(0, root);
            }
            createMap(-1, root.left);
            createMap(1, root.right);
        }
        else if(level < 0) {
            if(!nodes.containsKey(level)) {
                nodes.put(level, root);
            }
            createMap(level - 1, root.left);
            createMap(level + 1, root.right);
        } else {
            if(!nodes.containsKey(level)) {
                nodes.put(level, root);
            }
            createMap(level + 1, root.right);
            createMap(level - 1, root.left);
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }   
}