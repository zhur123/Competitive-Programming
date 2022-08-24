import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
 
public class hikegraph {
	
	// Private Static Methods Starts Here
	public static class Node implements Comparable<Node>{
		int camp;
		int day;
		int length;
		Node(int node, int day, int length){
			this.camp = node;
			this.day = day;
			this.length = length;
		}
		
		@Override
		public int compareTo(Node other) {
			if(this.day != other.day) {
				return this.day - other.day;
			}else {
				return other.length - this.length;
			}
		}
		
		@Override
		public String toString() {
			return "Camp " + this.camp + "|Day " + this.day + "|Length " + this.length;
		}
	}
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		int goalNode = sc.nextInt()-1;
		ArrayList<ArrayList<Entry<Integer, Integer>>> adjList = new ArrayList<>();
		for(int i = 0; i < nodes; i++) {
			adjList.add(new ArrayList<>());
		}
		for(int a = 0; a < edges; a++) {
			int i = sc.nextInt()-1;
			int k = sc.nextInt()-1;
			int v = sc.nextInt();
			adjList.get(i).add(new SimpleEntry<>(k, v));
			adjList.get(k).add(new SimpleEntry<>(i, v));
		}
		PriorityQueue<Node> pq = new PriorityQueue<>(); 
		HashMap<Integer, Node> history = new HashMap<>(); // (camp, (day, length))
		pq.add(new Node(0, 0, 0)); 
		history.put(0, new Node(-1, 0, 0));
		int bestDay = -1;
		int bestLength = -1;
		while(pq.size() > 0) {
			Node node = pq.poll();
			if(node.camp == goalNode 
					&& history.get(node.camp).day == node.day 
					&& history.get(node.camp).length == node.length) {
				bestDay = node.day;
				bestLength = node.length;
				continue;
			}
			for(Map.Entry<Integer, Integer> entry : adjList.get(node.camp)) {
				int nextCamp = entry.getKey();
				int length = entry.getValue();
				if(!history.containsKey(nextCamp) 
						|| history.get(nextCamp).day > node.day+1 
						|| (history.get(nextCamp).day == node.day+1 && history.get(nextCamp).length < node.length+length)) {
					pq.add(new Node(nextCamp, node.day+1, node.length+length));
					history.put(nextCamp, new Node(-1, node.day+1, node.length+length));
				}
			}
		}
		System.out.println(bestDay + " " + bestLength);
	}
 
}