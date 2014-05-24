

public class BiNodeBSTToDLL {
	static class BiNode {
		public BiNode node1;
		public BiNode node2;
		public int data; 
		public BiNode(int d) {
			data = d;
		}
		
		static BiNode head=null;
		
		static BiNode convert (BiNode root, boolean left){
			if(root == null){
				return null;
			}
			BiNode n1 = convert(root.node1, true);
			BiNode n2 = convert(root.node2, false);
			
			setLink(n1, root);
			setLink(root, n2);
			
			if (left){
				if(n1==null && head==null){
					head = root;
				}
				return (n2!=null)? n2 : root;
			}
			else{
				return (n1!=null)? n1 : root;
			}
			 
		}
		
		static void setLink(BiNode n1, BiNode n2){
			if(n1!=null) n1.node2 = n2;
			if(n2!=null) n2.node1 = n1;
		}
		
		public static void printLinkedListTree(BiNode root) {
			for (BiNode node = root; node != null; node = node.node2) {
				if (node.node2 != null && node.node2.node1 != node) {
					System.out.print("inconsistent node: " + node);
				}
				System.out.print(node.data + "->");
			}
			System.out.println();
		}

		public static BiNode createTree() {
			BiNode[] nodes = new BiNode[7];
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = new BiNode(i);
			}
			nodes[4].node1 = nodes[2];
			nodes[4].node2 = nodes[5];
			nodes[2].node1 = nodes[1];
			nodes[2].node2 = nodes[3];
			nodes[5].node2 = nodes[6];
			nodes[1].node1 = nodes[0];
			//nodes[1].node1 = nodes[0];
			//nodes[1].node2 = nodes[2];
			return nodes[4];
		}

		public static void printAsTree(BiNode root, String spaces) {
			if (root == null) {
				System.out.println(spaces + "- null");
				return;
			}
			System.out.println(spaces + "- " + root.data);
			printAsTree(root.node1, spaces + "   ");
			printAsTree(root.node2, spaces + "   ");
		}

		public static void main(String[] args) {
			BiNode root = createTree();
			//printAsTree(root, "");
			convert(root, false);
			printLinkedListTree(head);
		}
	}
}
