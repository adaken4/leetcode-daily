# Delete the Middle Node of a Linked List

## Problem Summary
**Input**: The `head` of a singly linked list.  
**Output**: The `head` of the modified linked list after removing the middle node.  
**Key Insight**: A two-pointer approach (fast and slow) can find the middle of a linked list. By starting the fast pointer two steps ahead, the slow pointer stops at the node *immediately preceding* the middle node. This eliminates the need for tracking a `prev` pointer.

## Algorithm Steps
1. **Edge Case**: If the list contains only one node, the middle node to delete is the head itself. Return `null`.
2. **Two Pointers Setup**: Use a `slow` pointer starting at the `head`, and a `fast` pointer starting at `head.next.next`.
3. **Traverse**: Move `fast` forward by 2 nodes and `slow` forward by 1 node in each iteration. Continue until `fast` or `fast.next` becomes `null`.
4. **Delete Middle**: The `slow` pointer is now positioned just before the middle node. Set `slow.next = slow.next.next` to remove the middle node.
5. **Complexity**:
   - **Time**: O(n) to traverse the list.
   - **Space**: O(1) auxiliary space as we only use two pointer variables.

## Visual Example
```text
Linked List: [1, 3, 4, 7, 1, 2, 6] (n = 7)
Middle Node to Delete: floor(7 / 2) = 3rd node (0-indexed) -> Node value 7

Initial:
  1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6
  ^         ^
  slow      fast

Step 1:
  1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6
       ^              ^
       slow           fast

Step 2:
  1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6 -> null
            ^                   ^
            slow                fast

Fast pointer reaches the end.
Delete middle node (node 7):
  slow.next = slow.next.next (4.next = 1)

Result: [1, 3, 4, 1, 2, 6]
```

## Optimization & Efficiency Notes

### 1. Eliminating the `prev` Pointer (One-Pass)
The naive one-pass fast & slow pointer algorithm uses three variables: `slow`, `fast`, and `prev`. Inside the loop, it performs three assignments:
```javascript
prev = slow;
slow = slow.next;
fast = fast.next.next;
```
By starting `fast` at `head.next.next`, we eliminate `prev` entirely and reduce the loop updates to:
```javascript
slow = slow.next;
fast = fast.next.next;
```
This saves CPU cycles on every step by avoiding variable re-assignment and reducing object property lookups.

### 2. Two-Pass vs. One-Pass in JavaScript (V8 Engine)
In compiled languages like Go, a two-pass solution (first counting the length, then walking to `middle - 1`) often achieves 100% runtime (0ms). This can also be true in JavaScript's V8 engine:
* **Simpler Loops**: In a two-pass approach, the first loop only does `current = current.next` and `length++`. The second loop only does `current = current.next` for `middle - 1` steps.
* **JIT Optimization**: V8 can optimize these extremely simple loops with very straightforward branch prediction and minimal check instructions.
* **Instruction Cache**: In contrast, the one-pass approach checks two conditions (`fast && fast.next`) and does double pointer steps in each iteration.

However, the optimized one-pass approach keeps the code elegant, maintains $O(1)$ auxiliary space, and reduces memory overhead in JS environments.
