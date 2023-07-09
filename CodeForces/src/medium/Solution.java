package medium;

/*
 * 2^i + num2
 * num1 = 2^a+num2 + 2^b + num2 +  . . . .
 * num1 - k*num2 = 2^a + 2^b + 2^c + 2^d +  . . . (k times);
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(new Solution().makeTheIntegerZero(3, -2));
	}
	
	public int makeTheIntegerZero(int num1, int num2) {
		int count = 0;
		while(num1!=0) {
			num1 -= num2;
			if(num1<0) return -1;
			count ++;
			int t = countBits(num1);
			if(t==count) return t;
			if(t<count) return count;
		}
		return count;
	}
	
	public int shiftNum(int n) {
		int t = n;
		int i;
		for(i=0;t!=1;i++) {
			t = t>>1;
		}
		while(i-->0) {
			t = t<<1;
		}
		return n & ~t;
	}
	
	public int countBits(int n) {
		int count = 0;
		while(n>0) {
			if(n%2==1) count++;
			n = n>>1;
		}
		return count;
	}
}
