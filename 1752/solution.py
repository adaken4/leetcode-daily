from typing import List

class Solution:
    def check(self, nums: List[int]) -> bool:
        n = len(nums)
        if n <= 1:
            return True
        
        count = 0
        for i in range(n):
            # (i + 1) % n seamlessly connects the tail back to the head
            if nums[i] > nums[(i+1)%n]:
                count+=1
                # Optimization: Early exit if we find more than 1 drop
                if count > 1:
                    return False
                
        return True
