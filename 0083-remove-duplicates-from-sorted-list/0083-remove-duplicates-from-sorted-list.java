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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first=head;
        ListNode second=head;
        while(second!=null){
            if(first.val==second.val){
                second=second.next;
                first.next=second;
            }
            else{
                second=second.next;
                first=first.next;
            }
        }
        return head;
    }
}