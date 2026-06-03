// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> map = new HashMap<>();
//         for (int i = 0; i < strs.length; i++) {
//             // 1. Sort the anagram
//             char[] chars = strs[i].toCharArray();
//             Arrays.sort(chars);
//             String sortedString = new String(chars);

//             // Store anagram
//             map.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(strs[i]);
//         }
//         return new ArrayList<>(map.values());
//     }
// }

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            // 0. for each string create its freq count arr
            int[] count = new int[26];

            // 1. Calculate Count of each char in str
            for (char c : strs[i].toCharArray()) {
                count[c - 'a']++;
            }

            // 1. Create Frequency String
            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append('#'); // Delimiter to avoid 1 vs 11
                sb.append(num);
            }
            String freqString = new String(sb);

            // Store anagram
            map.computeIfAbsent(freqString, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}