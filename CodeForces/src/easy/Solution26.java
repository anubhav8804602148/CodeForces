package easy;

public class Solution26 {
	public int removeDuplicates(int[] nums) {
		int count=1;
		int current=nums[0];
		int n = nums.length;
		for(int i=1;i<n;i++) {
			if(nums[i]!=current) {
				nums[count]=nums[i];
				count++;
				current = nums[i];
			}
		}
        return count;
    }
}
