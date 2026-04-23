class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return new String(sb);
    }

    public List<String> decode(String str) {
        List<String> message = new ArrayList<>();
        int n = str.length();
        int i = 0;

        while (i < n) {
            int j = i;
            while (j < n && str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            String msg = str.substring(j + 1, j + 1 + length);
            message.add(msg);
            i = j + 1 + length;
        }
        return message;
    }
}
