class Solution {
    public int maxArea(int h, int w, int[] hc, int[] vc) {
        
        long hm = 0, vm = 0, hp = 0, vp = 0;
        Arrays.sort(hc);
        Arrays.sort(vc);
        for (int c : hc) {
            hm = Math.max(hm, c - hp);
            hp = c;
        }
        hm = Math.max(hm, h - hp);
        for (int c : vc) {
            vm = Math.max(vm, c - vp);
            vp = c;
        }
        vm = Math.max(vm, w - vp);
        return (int) ((hm * vm) % (Math.pow(10, 9) + 7));
    }
}
