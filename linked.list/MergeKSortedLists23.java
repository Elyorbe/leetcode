package linked.list;

/*
23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 */
public static class MergeKSortedLists23 {
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return dummyHead.next;
    }

    private ListNode bruteForce(ListNode[] lists) {
        PriorityQueue<Integer> values = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                values.offer(node.val);
                node = node.next;
            }
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        while (!values.isEmpty()) {
            int value = values.poll();
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummyHead.next;
    }

}
