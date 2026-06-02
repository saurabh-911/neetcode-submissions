class Solution {
    public int maxProfit(int[] a) {
        int n = a.length;
        int max = a[n-1];
        int profit = 0;
        for(int i=n-1;i>=0;i--){
            max = Math.max(max, a[i]);
            profit = Math.max(profit, max - a[i]);
            // System.out.println(max + " - " + a[i] + " = "+ profit);
        }
        return profit;
    }
}
