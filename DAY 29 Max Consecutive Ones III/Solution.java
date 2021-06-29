class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int start = 0, end = 0, fc = 0, maxLen = 0;
        
        while(end < nums.length) {
            if(nums[end] == 1) {
                end++;
            } else {
                if(fc < k) {
                    end++;
                    fc++;
                } else {
                    while(fc == k) {
                        if(nums[start] == 0) {
                            fc--;
                        }
                        start++;
                    }
                }
            }
            
            maxLen = Math.max(maxLen, end-start);
        }
        return maxLen;
        
    }
}
