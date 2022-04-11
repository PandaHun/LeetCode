class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int count = 0;
        int sum;
        while (left <= right) {
            sum = people[left] + people[right];
            if (sum <= limit) {
                left++;
            }
            right--;
            count++;
        }
        return count;
    }
}