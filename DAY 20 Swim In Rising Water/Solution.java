class Solution {
    
    private class Node {
        private int x;
        private int y;
        private int time;
        
        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    
    private static final int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.time-b.time);
        
        pq.add(new Node(0,0,grid[0][0]));
        vis[0][0] = true;
        int leastTime = grid[0][0];
        
        while(!pq.isEmpty()) {
            
            Node node = pq.poll();
            leastTime = Math.max(leastTime, node.time);
            
            if(node.x == n-1 && node.y == n-1) break;
            
            for(int[] dir : directions) {
                int newX = node.x + dir[0];
                int newY = node.y + dir[1];
                
                if (newX < 0 ||  newX >= n  || newY < 0  || newY >= n || vis[newX][newY]) continue;
                
                vis[newX][newY] = true;
                pq.add(new Node(newX,newY,grid[newX][newY]));
                
            }
            
        }
        return leastTime;
    }
}
