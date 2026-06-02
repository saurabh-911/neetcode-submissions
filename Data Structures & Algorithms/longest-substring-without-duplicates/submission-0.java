class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < n; r++) {
            char curr = s.charAt(r);
            if (map.containsKey(curr)) {
                l = Math.max(l, map.get(curr) + 1);
            }
            map.put(curr, r);
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}
