class Solution {
    public String minWindow(String s, String t) {
        int lenS = s.length();
        int countReq = t.length();

        // EDGE CASE
        if (t.length() > lenS)
            return "";

        Map<Character, Integer> map = new HashMap<>();

        for(char character: t.toCharArray()) 
        map.put(character,map.getOrDefault(character, 0) + 1);

        int start = 0;
        int minLen = Integer.MAX_VALUE;

        int i = 0;
        for (int j = 0; j < lenS; j++) {
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch) > 0){
                countReq--;
            }
            map.put(ch, map.getOrDefault(ch, 0) - 1);

            while(countReq == 0 && i<=j && i<lenS){

                if(minLen > j-i+1){
                start = i;
                minLen = j-i+1;
                }

                char ch2 = s.charAt(i);
                map.put(ch2, map.getOrDefault(ch2, 0) + 1);
                if(map.get(ch2)>0){
                    countReq++;
                }
                i++;
            }
        }

        // EDGE CASE
        return  (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLen);
    }
}
