class Solution {
    public int[] twoSum(int[] arr, int t) {
        int l = 0;
        int r = arr.length - 1;
        int[] ans = new int[2];

        while(l<r){
            if(arr[l] + arr[r] < t){
                l++;
            }
            else if(arr[l] + arr[r] > t){
                r--;
            }
            else{
                ans[0] = l+1;
                ans[1] = r+1;
                break;
            }
        }
        return ans;
    }
}