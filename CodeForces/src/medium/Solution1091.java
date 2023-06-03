package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.GraphNode;

class Solution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
    	GraphNode rootNode = new GraphNode(0, 0);
    	ArrayDeque<GraphNode> toVisitNodes = new ArrayDeque<>();
    	Set<GraphNode> visitedNodes = new HashSet<>();
    	int pathLen = -1;
    	rootNode.level=1;
    	visitedNodes.add(rootNode);
    	int n = grid.length;
    	if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
    	if(n==1) return 1;
    	toVisitNodes.add(rootNode);
    	while(!toVisitNodes.isEmpty()) {
    		GraphNode node = toVisitNodes.poll();
    		Set<GraphNode> neighbours = getNeighbours(node.x, node.y, n, grid, visitedNodes);
    		for(GraphNode nNode : neighbours) {
    			nNode.level = node.level+1;
    			toVisitNodes.add(nNode);
    			node.connectedNodes.add(nNode);
    			if(nNode.x==n-1 && nNode.y==n-1) {
    				toVisitNodes.clear();
    				pathLen = nNode.level;
    				break;
    			}
    		}
    	}
    	System.out.println(rootNode);
        return pathLen;
    }
    
    public Set<GraphNode> getNeighbours(int x, int y, int n, int[][] grid, Set<GraphNode> visitedNodes){
    	Set<GraphNode> neighbours = new HashSet<>();
    	List<GraphNode> possNeigh = Arrays.asList( 
    		new GraphNode(x-1, y-1),
    		new GraphNode(x-1, y),
    		new GraphNode(x-1, y+1),
    		new GraphNode(x, y-1),
    		new GraphNode(x, y+1),
    		new GraphNode(x+1, y-1),
    		new GraphNode(x+1, y),
    		new GraphNode(x+1, y+1)
    	);
    	for(GraphNode node : possNeigh) {
    		if(node.x>=0 && node.x<n && node.y>=0 && node.y<n && grid[node.x][node.y]==0 && !visitedNodes.contains(node)) {
    			neighbours.add(node);
    			visitedNodes.add(node);
    		}
    	}
    	return neighbours;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution1091().shortestPathBinaryMatrix(new int[][] {
			new int[] {0,0,0,0,0},
			new int[] {0,1,0,0,0},
			new int[] {0,0,0,0,0},
			new int[] {0,0,0,0,0},
			new int[] {0,0,0,0,0}
		}));;
	}
}