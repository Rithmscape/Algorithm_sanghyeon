import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
          int[] list = new int[n];
        int answer = n;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int lostCount = 0;
        int reserveCount = 0;
        for (int i = 0; i < n; i++) {
            list[i] = 1;
            if (lostCount < lost.length && lost[lostCount] - 1 == i) {
                lostCount++;
                list[i] -= 1;
            }
            if (reserveCount < reserve.length && reserve[reserveCount] - 1 == i) {
                reserveCount++;
                list[i] += 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (list[i] == 2) {
                if (i - 1 >= 0 && list[i - 1] == 0) {
                    list[i] = 1;
                    list[i - 1] = 1;
                    continue;
                }
                if (i + 1 < n && list[i + 1] == 0) {
                    list[i] = 1;
                    list[i + 1] = 1;
                    continue;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (list[i] == 0) answer--;
        }
        return answer;
    }
}