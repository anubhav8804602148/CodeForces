package medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution22 {
	
	public static void main(String[] args) {
		System.out.println(new Solution22().generateParenthesis(3));;
	}
	
	public List<String> generateParenthesis(int n) {
        Set<String> allRes = new HashSet<>();
        for(int i=0;i<n;i++) {
        	allRes = updateList(allRes, i);
        }
        return allRes.stream().toList();
    }

	private Set<String> updateList(Set<String> allRes, int n) {
		if(n==0) {
			allRes.add("()");
			return allRes;
		}
		Set<String> updatedSet = new HashSet<>();
		for(String curr: allRes) {
			int up = curr.length();
			for(int i=0;i<up;i++) {
				if(curr.charAt(i)=='(') {
					int open=0;
					for(int j=i;j<up;j++) {
						if(curr.charAt(j)=='(') open++;
						else open--;
						if(open==0) {
							updatedSet.add(getUpdatedString(curr, i, j));
						}
					}
				}
			}
			updatedSet.add("()"+curr);
			updatedSet.add(curr+"()");
		}
		return updatedSet;
	}

	private String getUpdatedString(String curr, int i, int j) {
		return curr.substring(0, i)+"("+curr.substring(i,j+1)+")"+curr.substring(j+1);
	}
}
