class Solution {
    int idx = 0;
    
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String tmp_string = "";

        while (idx < s.length()) {
            char c = s.charAt(idx);
            idx++;

            if (c == '[') {
                tmp_string = decodeString(s);
                for (int j = 0; j < count; j++) {
                    sb.append(tmp_string);
                }
                count = 0;
            } else if (c == ']') {
                break;
            } else if ('a' <= c && c <= 'z') {
                sb.append(c);
            } else {
                count = count * 10 + c - '0';
            }
        }

        return sb.toString();
    }
}