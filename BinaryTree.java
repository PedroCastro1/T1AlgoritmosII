import java.util.ArrayList;

public class BinaryTree {
	public Node root;
	static int preIndex = 0;
	private static class Node{
		Node left;
		Node right;
		String data;
		
		Node (String newData){
			left = right = null;
			data = newData;
		}
	}
	
	public BinaryTree() {
		root = null;
	}
	
	public Node createTree(ArrayList<String> in, ArrayList<String> pre, int start, int end) {
		if(start > end) return null;
		
		Node root = new Node(pre.get(preIndex++));
		
		if(start == end) return root;
		
		int indexRoot = find(in, start, end, root.data);
		
		root.left = createTree(in, pre, start, indexRoot-1);
		root.right = createTree(in, pre, indexRoot+1, end);
		
		return root;
	}
	
	private int find(ArrayList<String> in, int start, int end, String data) {
		int i;
		for(i = start; i < end; i++) {
			if(in.get(i).equals(data)) {
				return i;
			}
		}
		return i;
	}
	
	public ArrayList<String> preFix() {
		ArrayList<String> preFix = new ArrayList<String>();
		return preFix(root, preFix);
	}
	
	private ArrayList<String> preFix(Node n, ArrayList<String> preFix) {
		if(n != null) {
			preFix.add(n.data);
			preFix(n.left, preFix);
			preFix(n.right, preFix);
		}
		return preFix;
	}
	
	public ArrayList<String> inOrder(){
		ArrayList<String> inOrder = new ArrayList<String>();
		return inOrder(root, inOrder);
	}
	
	private ArrayList<String> inOrder(Node n, ArrayList<String> inOrder){
		if(n != null){
			inOrder(n.left, inOrder);
			inOrder.add(n.data);
			inOrder(n.right, inOrder);
		}
		return inOrder;
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node n) {
		if(n == null) return 0;
		else {
			int he = height(n.left);
			int hd = height(n.right);
			
			if(he < hd) return hd + 1;
			else return he + 1;
		}
	}
}
