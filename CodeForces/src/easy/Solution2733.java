package easy;

import java.util.Arrays;

class Solution2733 {
    public int findNonMinOrMax(int[] nums) {
    	int[] nnum = Arrays.stream(nums).distinct().sorted().toArray();
    	if(nnum.length<3) return -1;
    	return nnum[1];
    }
}
