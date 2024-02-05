import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> last = new HashMap<>();
        Map<Character, Integer> first = new HashMap<>();
        int length = s.length();
        for (int i = 0 ; i < length; i++) {
            last.put(s.charAt(i), i);
            first.putIfAbsent(s.charAt(i), i);
        }
        int result = 1000000;
        for (int i = 0 ; i < length; i++) {
            int index = last.get(s.charAt(i));
            int target = first.get(s.charAt(i));
            if (i == index && index == target) {
                result = i;
                break;
            }
        }
        return result == 1000000 ? -1 : result;
    }
}