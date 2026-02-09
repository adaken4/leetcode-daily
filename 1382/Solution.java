import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Given a binary search tree, return a balanced binary search tree with the
 * same node values.
 * <p>
 * A binary search tree is balanced if the depth of the two subtrees of every
 * node never differs by more than 1.
 */
public class Solution {

    /**
     * Balances an unbalanced BST by:
     * 1. Performing inorder traversal to extract sorted values
     * 2. Rebuilding a height-balanced BST from the sorted list using a recursive
     * approach
     */
    public TreeNode balanceBST(TreeNode root) {
        // Edge case: empty tree
        if (root == null) {
            return null;
        }

        // Step 1: Store inorder traversal of the BST in an array list
        ArrayList<Integer> arr = new ArrayList<>();
        storeInorder(root, arr);

        // Step 2: Build a balanced BST from the sorted array
        return buildBalancedTree(arr, 0, arr.size() - 1);
    }

    /**
     * Performs inorder traversal of the BST
     * and stores the node values in sorted order.
     */
    private void storeInorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        storeInorder(root.left, arr);
        arr.add(root.val);
        storeInorder(root.right, arr);
    }

    /**
     * Recursively builds a height-balanced BST from
     * a sorted list by choosing the middle element as root.
     */
    private TreeNode buildBalancedTree(ArrayList<Integer> arr, int start, int end) {
        // Base case: no elements to construct the subtree
        if (start > end) {
            return null;
        }

        // Choose middle element to ensure balance
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr.get(mid));

        // Recursively build left and right subtrees
        node.left = buildBalancedTree(arr, start, mid - 1);
        node.right = buildBalancedTree(arr, mid + 1, end);

        return node;
    }
}