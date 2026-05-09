class Solution {
    public boolean isAnagram(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if(lenS != lenT) return false;
        int[] arr = new int[26];

        for(int i=0; i<lenS; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            arr[ch1 - 'a']++;
            arr[ch2 - 'a']--;
        }
        for(int count: arr){
            if(count != 0) return false;
        }
        return true;
    }
}
