/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode fastDummy=new ListNode(-1);
        ListNode slowDummy=new ListNode(-1);

        ListNode fast=fastDummy;
        ListNode slow=slowDummy;

        while(head!=null){

            if(head.val<x){
                slow.next=head;
                slow=slow.next;
            }

            else{
                fast.next=head;
                fast=fast.next;
            }
            head=head.next;
        }
        fast.next=null;
        slow.next=fastDummy.next;

        return slowDummy.next;
    }
}