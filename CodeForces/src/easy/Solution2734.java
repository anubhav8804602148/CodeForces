package easy;

public class Solution2734 {
	public String smallestString(String s) {
        int start = 0;
        int n = s.length();
        while(start<n && s.charAt(start)=='a') start++;
        StringBuilder b = new StringBuilder(s.substring(0,start));
        int curr=start;
        boolean done = false;
        while(curr<n) {
        	if(s.charAt(curr)=='a') break;
        	b.append((char)(s.charAt(curr)-1));
        	done=true;
        	curr++;
        }
        if(!done) {
        	char lchar = s.charAt(n-1);
        	return s.substring(0,n-1)+(lchar=='a'?'z':(char)(lchar-1));
        }
        return b.append(s.substring(curr)).toString();
    }
	
	public static void main(String[] args) {
		new Solution2734().smallestString("a");
	}
}
