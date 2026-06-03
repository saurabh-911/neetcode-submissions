class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){

            if(i>0 && a[i] == a[i-1]) continue;

            int t = -a[i];
            int l =i+1;
            int r = n-1;
            while(l<r){

                if(a[l]+a[r] == t){
                   List<Integer> triplets = new ArrayList<>();
                    triplets.add(a[i]);
                    triplets.add(a[l]);
                    triplets.add(a[r]);
                    ans.add(triplets);
                    l++;
                    r--;
            while(l<r && a[l] == a[l-1]) l++;
            while(l<r && a[r] == a[r+1]) r--;
                }
                else if(a[l]+a[r]<t){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return ans;
    }
}