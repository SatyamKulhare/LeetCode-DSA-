class Solution {
    public int[] twoSum(int[] nums, int target) {
 int n=nums.length;
        int low=0;
        int high=n-1;
        int arr[] = new int[2];
        for(int i=0;i<n;i++){
            if(nums[low]+nums[high]==target){
                arr[0]=low+1;
                arr[1]=high+1;
            } else if(nums[low]+nums[high]<target){
                low++;
            } else{
                high--;
            }
        }
        return arr;
    }
}