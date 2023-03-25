package algorithm;

import java.util.*;


/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    private final Map<Integer, Integer> map  = new HashMap<>();
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(nums[i])){
                int pos = map.get(nums[i]);
                return new int[] {pos, i};
            }else{
                map.put(temp, i);
            }
        }
        return new int[0];
    }
}
// @lc code=end

