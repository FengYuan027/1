public class Solution1 {
    public int minDistance(String word1, String word2) {
        int M = word1.length(), N = word2.length();
        int[][] distance = new int[M+1][N+1];
        for (int i = 1; i < M + 1; i++) distance[i][0] = i;
        for (int i = 1; i < N + 1; i++) distance[0][i] = i;
        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) distance[i][j] = distance[i-1][j-1];
                else distance[i][j] = Math.min(distance[i-1][j], Math.min(distance[i-1][j-1], distance[i][j-1])) + 1;
            }
        }
        return distance[M][N];
    }
}

public class Solution2 {
    public int minDistance(String word1, String word2) {
        int M = word1.length(), N = word2.length();
        int[] distance = new int[N+1];
        for (int i = 1; i <= N; i++) distance[i] = i;
        for (int i = 1; i <= M; i++) {
            int pre = distance[0];
            distance[0] = i;
            for (int j = 1; j <= N; j++) {
                int temp = distance[j];
                if (word1.charAt(i-1) == word2.charAt(j-1)) distance[j] = pre;
                else distance[j] = Math.min(distance[j-1], Math.min(distance[j], pre)) + 1;
                pre = temp;
            }
        }
        return distance[N];
    }
}
