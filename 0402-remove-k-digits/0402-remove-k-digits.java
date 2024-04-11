class Solution {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        
        if (length == k) {
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while ( i < length ) {
            while ( k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        
        while ( k > 0 ) {
            stack.pop();
            k--;
        }
        
        StringBuilder builder = new StringBuilder();
        while ( !stack.isEmpty() ) {
            builder.append(stack.pop());
        }
        builder.reverse();
        
        while ( builder.length() > 1 && builder.charAt(0) == '0' ) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }
}