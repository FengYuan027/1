public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if(heights == null || heights.length == 0) return 0;
        int maxIndex = 0;
        int preMax = 0;
        int count = 0;
        for(int i = 0; i < heights.length; i++){
            maxIndex = heights[i] > heights[maxIndex] ? i : maxIndex;
        }
        for(int i = 0; i < maxIndex; i++){
            if(heights[preMax] > heights[i]){
                count += (heights[preMax] - heights[i]);
            } else preMax = i;
        }
        preMax = heights.length-1;
        for(int i = heights.length-1; i > maxIndex; i--){
            if(heights[preMax] > heights[i]){
                count += (heights[preMax] - heights[i]);
            } else preMax = i;
        }
        return  count;
    }
}

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        int maxArea = 0;
        int start = 0, end = heights.length-1;
        while(start < end){
            maxArea = Math.max(maxArea, Math.min(heights[start], heights[end]) * (end - start));
            if(heights[end] < heights[start]){
                end--;
            } else start++;
        }
        return maxArea;
        
    }
}

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        
        // row
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[i][j]))
                    return false;
            }
        }
        
        //col
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[j][i]))
                    return false;
            }
        }
        
        // sub matrix
        for(int i = 0; i<9; i+= 3){
            for(int j = 0; j<9; j+= 3){
                Arrays.fill(visited, false);
                for(int k = 0; k<9; k++){
                    if(!process(visited, board[i + k/3][ j + k%3]))
                    return false;                   
                }
            }
        }
        return true;
        
    }
    
    private boolean process(boolean[] visited, char digit){
        if(digit == '.'){
            return true;
        }
        
        int num = digit - '0';
        if ( num < 1 || num > 9 || visited[num-1]){
            return false;
        }
        
        visited[num-1] = true;
        return true;
    }
}
