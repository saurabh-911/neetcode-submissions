class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length + 1];
        pref[0] = 1;
        int[] suff = new int[nums.length + 1];
        suff[suff.length - 1] = 1;

        for(int i=0; i<nums.length; i++){
            pref[i+1] = pref[i] * nums[i];
            suff[suff.length - 1 - i - 1] = suff[suff.length - 1 - i] * nums[nums.length - 1 - i];
        }

        int[] ans = new int[nums.length];
        for(int i=1; i<=nums.length; i++){
            ans[i-1] = pref[i-1] * suff[i];
        }

        return ans;
    }
}