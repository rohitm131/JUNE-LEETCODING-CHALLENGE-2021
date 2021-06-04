class Solution {
    
    Set<String> visited = new HashSet<>();
    
    public int openLock(String[] deadends, String target) {        
        
        if(target == null || target.length() == 0) return -1;
        
        for(String dead : deadends) {
            visited.add(dead);
        }
        
        Queue<String> q = new LinkedList<>();
        int level = 0;
        q.add("0000");
        
        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-- > 0) {
                String cur = q.poll();
                if(visited.contains(cur)) continue;
                if(cur.equals(target)) return level;
                
                for(String next : getNext(cur)) {
                    if(!visited.contains(next)) {
                        q.add(next);
                    }
                }
                visited.add(cur);
            }
            level++;
        }
        return -1;
    }
    
    public Set<String> getNext(String lock) {
        Set<String> newLocks = new HashSet<>();
        char[] lockChar = lock.toCharArray();
        for(int i=0; i<4; i++) {
            char c = lockChar[i];
            
            //moving clockwise
            lockChar[i] = c == '9'? '0': (char)(c+1);
            newLocks.add(new String(lockChar));
            
            //moving anticlockwise
            lockChar[i] = c == '0' ? '9': (char)(c-1);
            newLocks.add(new String(lockChar));
            lockChar[i] = c;
        }
        return newLocks;
    }
}
