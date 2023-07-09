package math;

import java.util.HashMap;
import java.util.LinkedList;

class Fancy {

    LinkedList<Integer> opers;
    LinkedList<Integer> vals;
    HashMap<Integer, HashMap<Integer, Integer>> outMap;

    public Fancy() {
    	opers = new LinkedList<>();
    	vals = new LinkedList<>();
    	outMap = new HashMap<>();
    }
    
    public void append(int val) {
        opers.add(1);
        vals.add(val);
    }
    
    public void addAll(int inc) {
        opers.add(2);
        vals.add(inc);
    }
    
    public void multAll(int m) {
        opers.add(3);
        vals.add(m);
    }
    
    public int getIndex(int idx) {
    	int valSize = vals.size();
        HashMap<Integer, Integer> iterMap = outMap.getOrDefault(valSize, new HashMap<>());
        if(!iterMap.isEmpty()) {
        	
        }
        else {
        	int curr = 0;
        	int i=0;
        	while(vals.get(i)!=1) {
        		i++;
        	}
        	while(i<valSize) {
        		i++;
        	}
        }
        return -1;
    }
}
