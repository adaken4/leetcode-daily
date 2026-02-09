## Problem Summary
**Input**: Unbalanced BST (valid BST, unique values).  
**Output**: Height-balanced BST with same node values.  
**Key Insight**: Inorder traversal of any BST yields sorted order, so reconstruct balanced tree from that sorted array.[code]

## Algorithm Steps
1. **Inorder Traversal**: Get sorted list of all values (`storeInorder`) – O(n) time.[code]
2. **Balanced Build**: Recursively pick middle element as root, left/right subarrays for children (`buildBalancedTree`) – O(n) time.[code]
3. **Result**: Height balanced tree (height = O(log n)).[code]

```
Unbalanced BST (right-skewed):
    1
     \
      2
       \
        3
         \
          4

Inorder traversal → [1, 2, 3, 4]

Balanced BST:
      2
     / \
    1   3
         \
          4
```
