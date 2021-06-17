class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursive(res, new StringBuilder("("), n - 1, n);
        return res;
    }

    public void recursive(List<String> res, StringBuilder sb, int open, int close) {
        if (open == 0 && close == 0) {
            res.add(sb.toString());
            return;
        }

        if (open > 0) {
            recursive(res, sb.append("("), open - 1, close);
            sb.setLength(sb.length() - 1);
        }

        if (close > open) {
            recursive(res, sb.append(")"), open, close - 1);
            sb.setLength(sb.length() - 1);
        }
    }
}