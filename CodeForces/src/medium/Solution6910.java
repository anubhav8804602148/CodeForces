package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution6910 {
	
	static int UP = 1000000007;
	
	public static void main(String[] args) {
		System.out.println(new Solution6910().numberOfGoodSubarraySplits(new int[] {0,1,0}));
	}

	public int numberOfGoodSubarraySplits(int[] nums) {
		boolean ex = false;
		for(int a : nums) if(a==1) {
			ex = true;
			break;
		}
		if(!ex) return 0;
		
		List<Integer> arr = new ArrayList<>();
		int i=0;
		int j=0;
		int n = nums.length;
		while(i<n && nums[i]==0) i++;
		while(i<n) {
			if(nums[i]==1) {
				if(j!=0)arr.add(j);
				j = 0;
			}
			i++;
			j++;
		}
		return (int)prod(arr, 1);
	}

	private long prod(List<Integer> arr, long i) {
		if(arr.isEmpty()) return i%UP;
		i *= arr.remove(0);
		i %= UP;
		return prod(arr, i);
	}
}
