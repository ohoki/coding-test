package practice.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
- network delay time
주어진 네트워크에는 n개의 노드가 있으며, 이는 1부터 n까지 레이블이 붙어 있습니다. 또한 times[i] = (ui, vi, wi)리스트가 주어집니다.
이 때, ui노드에서 신호를 보내서 vi노드에 도달하는데 걸리는 시간을 wi라고 합니다.
k노드에서 신호를 보낼 때, 모든 노드에 신호가 도달하기 위한 최소 시간을 반환하시오. 하나의 노드라도 도달하지 못한다면 -1을 반환하시오.
(한 노드에서 연결된 여러 개의 edge에 신호를 동시에 전달할 수 있습니다.)

제약조건
1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
1 <= wi <= 100
모든 (ui, vi)쌍은 unique 합니다.
*/

public class NetworkDelayTime {
	public static void main(String[] args) {
		int[][] times = {{2,1,2}, {2,3,5}, {2,4,1}, {4,3,3}};
		int n = 4;
		int k = 2;
		
		System.out.println(networkDelayTime(times, n, k));
			
	}
	
	private static int networkDelayTime(int[][] times, int n, int k) {
		
		List<List<Edge>> graph = new ArrayList<List<Edge>>(n+1);
		
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<Edge>());
		}
		
		for(int[] time : times) {
			int u = time[0];
			int v = time[1];
			int w = time[2];
			graph.get(u).add(new Edge(w, v));
		}
		
		int[] dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		dis[k] = 0;
		
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.cost, p2.cost));
		priorityQueue.offer(new Edge(0, k));
		
		while(!priorityQueue.isEmpty()) {
			Edge curEdge = priorityQueue.poll();
			int u = curEdge.getVertex();
			
			for(Edge p : graph.get(u)) {
				int w = p.getCost();
				int v = p.getVertex();
				
				if(dis[u] + w < dis[v]) {
					priorityQueue.offer(new Edge(dis[u] + w, v));
					dis[v] = dis[u] + w;
				}
			}
		}
		
		int delayTime = 0;
		
		for(int i=1; i<=n; i++) {
			if(dis[i] == Integer.MAX_VALUE) {
				return -1;
			}
			delayTime = Math.max(delayTime, dis[i]);
		}
		
		return delayTime;
	}
}

class Edge{
	Integer cost;
	Integer vertex;
	
	public Edge(Integer cost, Integer vertex) {
		this.cost = cost;
		this.vertex = vertex;
	}
	
	public Integer getCost() {
		return this.cost;
	}
	
	public Integer getVertex() {
		return this.vertex;
	}
}
