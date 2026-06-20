class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(char ch : s1.toCharArray())  s1Freq[ch - 'a']++;

        int i = 0;
        for (int j = 0; j < n2; j++) {

            char ch = s2.charAt(j);

            if (j - i + 1 > n1) {
                s2Freq[s2.charAt(i) - 'a']--;
                i++;
            }

            s2Freq[ch - 'a']++;

            if (Arrays.equals(s1Freq, s2Freq)) {
                return true;
            }
        }

        return false;
    }
}
