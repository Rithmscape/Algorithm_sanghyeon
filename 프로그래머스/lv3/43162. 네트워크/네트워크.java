class Solution {
    public int solution(int n, int[][] computers) {
         int[] net = new int[n];
        int answer = 0;
        for(int i=0; i<n; i++) {
            if(net[i] == 0) {
                DFS(i, net, computers);
                answer++;
            }
        }
        return answer;
    }
    static void DFS(int i, int[] net, int[][] computers) {
        net[i] = 1;
        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && net[j] == 0) {
                DFS(j, net, computers);
            }
        }
    }
}