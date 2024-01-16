class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanInteger = new HashMap<>();

        romanInteger.put('I', 1);
        romanInteger.put('V', 5);
        romanInteger.put('X', 10);
        romanInteger.put('L', 50);
        romanInteger.put('C', 100);
        romanInteger.put('D', 500);
        romanInteger.put('M', 1000);

        int answer = 0;
        int length = s.length();
        for (int i = 0 ; i < length; i++) {
            if ( i < length -1 && romanInteger.get(s.charAt(i)) < romanInteger.get(s.charAt(i+1))) {
                answer -= romanInteger.get(s.charAt(i));
            } else {
                answer += romanInteger.get(s.charAt(i));
            }
        }
        return answer;
    }
}