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
    public int pairSum(ListNode head) {
        Map<Integer,Integer> map=new HashMap<>();  //indices track karle
        int i=0;
        ListNode temp=head;

        while(temp!=null){
            map.put(i,temp.val);
            temp=temp.next;
            i++;
        }

        int n=i;  // i jitna hai wahi tera size hai linkedlist ka
        int maxSum=0;

        for(int j=0;j<n/2;j++) { // n/2 element tak hi check kar maximum sum ko track kar
            int sum=map.get(j)+map.get(n-1-j);
            maxSum=Math.max(maxSum,sum);
        }

        return maxSum;
    }
}