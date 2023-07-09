package easy;

class Solution6466 {
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isBea(nums[i], nums[j])) count++;
            }
        }
        return count;
    }

	private boolean isBea(int x, int y) {
		String i = String.valueOf(x);
		String j = String.valueOf(y);
		int a = Integer.parseInt(i.substring(0,1));
		int b = Integer.parseInt(j.substring(j.length()-1));
		return gcd(a,b)==1;
	}

	private int gcd(int a, int b) {
		if(a>b) {
			int t = a;
			a = b;
			b = t;			
		}
		if(a==0) return b;
		return gcd(b%a, a);
	}	
}