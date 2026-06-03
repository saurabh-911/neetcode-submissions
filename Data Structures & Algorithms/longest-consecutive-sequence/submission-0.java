// TLE     
        //    if(arr.length == 0) return 0;

        //      Set<Integer> set = new HashSet<>();
        //       for(int i: arr){
        //         set.add(i);
        //        }
        // int curr = 1;
        // int max = Integer.MIN_VALUE;
        // for(int i=0;i<arr.length;i++){
        //     int next = arr[i]+1;          // a[i] --> 10
        //     while(set.contains(next)){    // next --> 102 
        //         curr++;                      // cuur =3
        //         next++;                      // next = 103
        //     }
        //     max = Math.max(curr, max);
        //     curr=1;
        // }
        // return max;


public class Solution{
    public int longestConsecutive(int[] arr) {

        if(arr.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int i: arr){
            set.add(i);
        }

        int n = arr.length;
        Set<Integer> start = new HashSet<>();
        for(int i=0;i<n;i++){
            int prev = arr[i] - 1;
            if(set.contains(prev)) continue;
            start.add(arr[i]);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i: start){
            int currLen = 1;
            int next = i + 1;
            while(set.contains(next)){
                currLen++;
                next++;
            }
            max = Math.max(max, currLen);
        }
        return max;
    }
}