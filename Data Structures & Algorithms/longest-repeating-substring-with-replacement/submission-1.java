class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>(); 
        int maxLen = 0;
        while(i<=j && j<n){
            // add the new character in substring
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch,0)+1);

            // get the max freq in substring
            int maxFreq = 0;
            for(Character character: map.keySet()) 
                 maxFreq = Math.max(maxFreq, map.get(character));

            // if substring is not valid => shrink
            if(!((j-i+1 - maxFreq) <= k)){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                i++;
            }

            // max lengeth of new substring
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }
}
