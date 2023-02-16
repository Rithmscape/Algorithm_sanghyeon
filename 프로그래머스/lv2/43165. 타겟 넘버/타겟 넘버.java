class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
        private static int dfs(int[] numbers, int target, int sum, int current) {
        int answer = 0;

        if (current == numbers.length) {
            if (target == sum) {
                return 1;
            }
            return 0;
        }

        answer += dfs(numbers, target, sum + numbers[current], current + 1);
        answer += dfs(numbers, target, sum + numbers[current] * -1, current + 1);

        return answer;
    }
    
}