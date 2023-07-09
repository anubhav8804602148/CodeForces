package medium;

import java.util.HashMap;
import java.util.Map.Entry;


public class Solution1865{
	public static void main(String[] args) {
		FindSumPairs pair = new FindSumPairs(new int[] {1,1,2,2,2,3}, new int[] {1,4,5,2,5,4});
		pair.count(7);
		pair.add(3,2);
		pair.count(8);
		pair.count(4);
		pair.add(0,1);
		pair.add(1,1);
		pair.count(7);
	}
}

class FindSumPairs {
	
	HashMap<Integer, Integer> tab1;
	HashMap<Integer, Integer> tab2;
	int[] nums;

    public FindSumPairs(int[] nums1, int[] nums2) {
    	nums = nums2;
    	for(int x : nums1) {
        	Integer c = tab1.get(x);
        	if(c==null) {
        		tab1.put(x, 1);
        	}
        	else {
        		tab1.put(x, c+1);
        	}
        }
    	for(int x : nums2) {
        	Integer c = tab2.get(x);
        	if(c==null) {
        		tab2.put(x, 1);
        	}
        	else {
        		tab2.put(x, c+1);
        	}
        }
    }
    
    public void add(int index, int val) {
    	int old = nums[index];
    	tab2.put(old, tab2.get(old)-1);
    	val += old;
    	nums[index] = val;
    	Integer c = tab2.get(val);
    	if(c==null) tab2.put(val, 1);
    	else tab2.put(val, c+1);
    }
    
    public int count(int tot) {
    	int count = 0;
    	for(Entry<Integer, Integer> e: tab1.entrySet()) {
    		count += e.getValue() * tab2.getOrDefault(tot-e.getKey(), 0);
    	}
    	return count;
    }
}

