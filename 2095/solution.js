/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteMiddle = function(head) {
    if (!head || !head.next) return null;
    
    // By starting fast two steps ahead, slow will stop at the node
    // immediately before the middle node. This avoids needing a 'prev' pointer.
    let slow = head;
    let fast = head.next.next;
    
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    slow.next = slow.next.next;
    return head;
};