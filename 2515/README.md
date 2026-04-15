# Shortest Distance to Target String in a Circular Array

## Problem Summary
**Input**: A 0-indexed circular string array `words`, a `target` string, and a `startIndex`.  
**Output**: The shortest distance to reach the `target`. Return `-1` if not found.  
**Key Insight**: In a circular array of length `n`, the distance between two indices `i` and `j` is the minimum of the direct distance $|i - j|$ and the wrap-around distance `n - |i - j|`.

## Algorithm Steps
1. **Single Pass**: Iterate through the array to find every occurrence of the `target` word – **O(n)** time.
2. **Distance Logic**: For each match, calculate:
   - `dist = abs(i - startIndex)`
   - `wrapDist = n - dist`
3. **Minimize**: Compare the result of `min(dist, wrapDist)` against the current best result.
4. **Complexity**:
   - **Time**: O(n) to traverse the slice.
   - **Space**: O(1) as no extra data structures are used.

## Visual Example
```text
Words: ["a", "b", "leetcode", "c", "leetcode"], Target: "leetcode", Start: 0

Index 2:
  Direct: |2 - 0| = 2
  Wrap: 5 - 2 = 3
  Min: 2

Index 4:
  Direct: |4 - 0| = 4
  Wrap: 5 - 4 = 1
  Min: 1

Result: 1 (The wrap-around path to index 4 is shorter)
