import java.io.*;
import java.util.*;
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode head1=head,head2=head;
        while(head2!=null && head2.next != null){
            head2=head2.next.next;
            head1=head1.next;
        }
        ListNode cur = head1, newList= null;
        while(cur!=null){
            head2 = cur.next;
            cur.next = newList;
            newList = cur;
            cur=head2;
        }
        while(head!=head1 && newList.next!=null){
            if(head.val!=newList.val){
                return false;
            }
            head=head.next;
            newList=newList.next;
        }
        return head==null || head.val==newList.val;
    }
}