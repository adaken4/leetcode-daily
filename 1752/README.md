# Check if Array Is Sorted and Rotated

## Problem Summary

Input: A 0-indexed integer array nums.

Output: true if the array was originally sorted in non-decreasing order and then rotated 0 or more positions; otherwise, return false.

Key Insight: A sorted array has at most one "drop" point where an element is strictly greater than the next one. When an array is circularly rotated, that single drop point shifts but remains unique. If we treat the array as a circular ring, checking the connection from the tail back to the head must still yield $\le 1$ total drops.

### Algorithm Steps

   1. Edge Case: If the array has 1 or fewer elements, it is always valid – O(1).
   2. Circular Traversal: Iterate through the entire array from index 0 to n-1 – O(n) time.
   3. Drop Detection: At each index i, compare the current element to the next circular element using (i + 1) % n.
   * If nums[i] > nums[(i + 1) % n], increment the count.
   4. Early Termination: If count exceeds 1 at any point, immediately return false.
   5. Final Evaluation: If the loop finishes with count <= 1, return true.

## Visual Example

Nums: [3, 4, 5, 1, 2], Length n = 5

i = 0: nums[0] (3) <= nums[1] (4) -> No drop. Count = 0
i = 1: nums[1] (4) <= nums[2] (5) -> No drop. Count = 0
i = 2: nums[2] (5) >  nums[3] (1) -> Drop found! Count = 1
i = 3: nums[3] (1) <= nums[4] (2) -> No drop. Count = 1
i = 4: nums[4] (2) <= nums[0] (3) -> (Wraparound) No drop. Count = 1

Result: true (Exactly 1 drop found, valid rotation)

## Complexity

* Time Complexity: $O(n)$ – We traverse the array exactly once.
* Space Complexity: $O(1)$ – No extra data structures are used; mutations are evaluated in place.
