import java.io.*;
import java.util.*;
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        
        while(fast != null && fast.next != null) {
            if(slow.val == fast.val) {
                return true;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }
}