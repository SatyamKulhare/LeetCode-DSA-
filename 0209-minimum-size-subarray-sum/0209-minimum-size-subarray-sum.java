class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0, high = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int n = nums.length;

        while (high < n) {
            sum += nums[high];
            while (target <= sum) {
                int length = high - low + 1;
                res = Math.min(res, length);
                sum -= nums[low];
                low++;
            }
            high++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}