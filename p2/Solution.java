/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum =0;
        int c = 0;
        ListNode p = new ListNode(-1);
        ListNode head = p;
        int add1 = 0;
        int add2 = 0;
        while(l1!=null || l2!=null){
            if(l1!=null){
                add1 = l1.val;
                l1 = l1.next;
            }else{
                add1 = 0;
            }
            if(l2!=null){
                add2 = l2.val;
                 l2 = l2.next;
            }else{
                add2 = 0;
            }
            sum = add1+add2+c;
            c = sum/10;
            sum %= 10;
            p.next = new ListNode(sum);
            p = p.next;
        }
        if(c!=0){
            p.next = new ListNode(c);
        }
        head = head.next;
        return head;
    }
}
