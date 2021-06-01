class Solution {
    
    public int dfs(int i, int j, int[][] grid) {
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]<=0) return 0;
        
        grid[i][j] = -1; //marking as visited
        int left = dfs(i,j-1,grid);
        int right = dfs(i,j+1,grid);
        int up = dfs(i-1,j,grid);
        int down = dfs(i+1,j,grid);
        
        int total = left + right + up + down + 1;
        return total;
        
    }
    
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int area = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    area = Math.max(area, dfs(i,j,grid));
                }
            }
        }
        return area;
    }
}
