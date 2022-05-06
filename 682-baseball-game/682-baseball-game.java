class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> scores = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    int a = scores.pop();
                    int b = scores.peek();
                    scores.push(a);
                    scores.push(a + b);
                    break;
                case "D": 
                    scores.push(scores.peek() * 2);
                    break;
                case "C":
                    scores.pop();
                    break;
                default:
                    scores.push(Integer.parseInt(op));
                    break;
            }
        }
        int answer = 0;
        while (!scores.isEmpty()) {
            answer += scores.pop();
        }
        return answer;
    }
}