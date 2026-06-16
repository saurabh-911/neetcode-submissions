class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (!isAlpha(s.charAt(i)) && i < j) {
                i++;
            }
            while (!isAlpha(s.charAt(j)) && i < j) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) == 
                               Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlpha(Character ch) {
    return (('A' <= ch && ch <= 'Z') ||
            ('a' <= ch && ch <= 'z') ||
            ('0' <= ch && ch <= '9'));
    }
}