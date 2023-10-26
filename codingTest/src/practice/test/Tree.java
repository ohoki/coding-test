package practice.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 - Lowest Common Ancestor of a Binary Tree
 문제에서 Binary 트리 하나와 해당 트리에 속한 두 개의 노드가 주어진다.
 두 노드의 공통 조상중 가장 낮은 node 즉, the lowest common ancestor(LCA)를 찾아라.
 
 제약조건
 2 <= node 개수 <= 10^5
 -10^9 < Node.val <= 10^9
 모든 Node.val은 Unique하다.
 p != q
 p,q는 모두 주어진 Tree에 속해 있다.
 
 - tree의 깊이를 구하여라 -
*/



public class Tree {
	public static void main(String[] args) {
		ArrayList<Node> nodes = new ArrayList<>(); 
		//초기화
		for(int i=0; i<9; i++) {
			nodes.add(new Node(i));
		}
		//트리 생성
		nodes.get(3).left = nodes.get(5); //root
		nodes.get(3).right = nodes.get(1);
		nodes.get(5).left = nodes.get(6);
		nodes.get(5).right = nodes.get(2);
		nodes.get(1).left = nodes.get(0);
		nodes.get(1).right = nodes.get(8);
		nodes.get(2).left = nodes.get(7);
		nodes.get(2).right = nodes.get(4);
		
		TreeNode tree = new TreeNode(nodes.get(3));
		
		
		System.out.println(tree.lowestCommonNode(nodes.get(3), nodes.get(6), nodes.get(4)).val);
		
		System.out.println(tree.depth());
		System.out.println(tree.depthDfs(tree.root));
	}
}
class Node {
	Object val;
	Node left;
	Node right;
	
	public Node(int val) {
		this.val = val;
	}
}

class TreeNode {
	Node root;
	
	public TreeNode(Node root) {
		this.root = root;
	}
	
	//postorder
	public Node lowestCommonNode(Node root, Node p, Node q) {
		if(root == null) {
			return null;
		}
		
		Node left = lowestCommonNode(root.left, p, q);
		Node right = lowestCommonNode(root.right, p, q);
		
		if(root == p || root == q) {
			return root;
		} else if(left != null && right != null) {
			return root;
		} else {
			return left != null ? left : right; 
		}
	}
	
	//levelorder
	public int depth() {
		int maxDepth = 0;
		if(root == null) {
			return maxDepth;
		}
		
		Queue<NodeInfo> q = new LinkedList<>();
		NodeInfo nodeInfo = new NodeInfo();
		
		maxDepth = 1;
		nodeInfo.setNode(root);
		nodeInfo.setDepth(maxDepth);
		q.add(nodeInfo);
		
		while(!q.isEmpty()) {
			maxDepth = Math.max(maxDepth, q.peek().getDepth());
			Node currNode = q.poll().getNode();
			
			if(currNode.left != null) {
				NodeInfo nodeInfoLeft = new NodeInfo();
				nodeInfoLeft.setDepth(maxDepth +1);
				nodeInfoLeft.setNode(currNode.left);
				q.add(nodeInfoLeft);
			}
			
			if(currNode.right != null) {
				NodeInfo nodeInfoRight = new NodeInfo();
				nodeInfoRight.setDepth(maxDepth +1);
				nodeInfoRight.setNode(currNode.right);
				q.add(nodeInfoRight);
			}
		}
		return maxDepth;
	}
	
	//postorder
	public int depthDfs(Node root) {
		int maxDepth = 0;

		if(root == null) {
			return maxDepth;
		}
		
		int left = depthDfs(root.left);
		int right = depthDfs(root.right);
		
		maxDepth = Math.max(left, right);

		return maxDepth + 1;
	}
}

class NodeInfo {
	Node node;
	int depth;
	
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
}

