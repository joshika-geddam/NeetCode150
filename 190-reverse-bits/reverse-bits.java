public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            int bits=(n>>i)&1;
            res+=(bits<<(31-i));
        }
        return res;
    }
}