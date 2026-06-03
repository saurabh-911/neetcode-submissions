// import java.util.*;

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int n : nums) {
//             map.put(n, map.getOrDefault(n, 0) + 1);
//         }

//         // Min-Heap based on frequency
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
//         for (int key : map.keySet()) {
//             pq.add(key);
//             if (pq.size() > k) {
//                 pq.poll(); // Remove least frequent
//             }
//         }

//         int[] result = new int[k];
//         for (int i = k - 1; i >= 0; i--) {
//             result[i] = pq.poll();
//         }
//         return result;
//     }
// }
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Count frequencies using a HashMap
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. Create buckets where index = frequency
        // bucket[i] will store a list of numbers that appear 'i' times
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        // 3. Collect the top k elements from the highest frequency buckets downward
        int[] result = new int[k];
        int counter = 0;
        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (int num : bucket[pos]) {
                    result[counter++] = num;
                    if (counter == k) break;
                }
            }
        }
        return result;
    }
}


