import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
	public static final String LEFT = "LEFT";
	public static final String RIGHT = "RIGHT";
	private Node root;

	public BinaryTree() {
	}

	public void create(int currentData) {
		if (root == null) {
			root = new Node();
		}
		root.data = currentData;
	}

	public void add(Node node, int currentData, String currentPosition) {
		if (node == null) {
			return;
		}

		Node currentNode = new Node();
		currentNode.data = currentData;

		if (LEFT.equals(currentPosition)) {
			node.left = currentNode;
		} else if (RIGHT.equals(currentPosition)) {
			node.right = currentNode;
		}
	}

	public Node search(int searchData) {
		if (root == null) {
			return null;
		}

		return search(searchData, root);
	}

	private Node search(int searchData, Node node) {
		if (node == null) {
			return null;
		}

		// Level order traversal to return the node
		LinkedList<Node> queueList = new LinkedList<Node>();
		queueList.add(node);

		Node currNode = null;

		while (!queueList.isEmpty()) {
			currNode = (Node) queueList.removeFirst();

			if (currNode.data == searchData) {
				break;
			} else {
				if (currNode.left != null) {
					queueList.add(currNode.left);
				}

				if (currNode.right != null) {
					queueList.add(currNode.right);
				}
			}
		}

		return currNode;
	}

	public void printLevelOrder() {
		printLevelOrder(root);
		System.out.println();
	}

	public void printLevelOrder(Node node) {
		if (node == null) {
			return;
		}

		LinkedList<Node> queueList = new LinkedList<Node>();
		queueList.add(node);

		Node currNode = null;

		while (!queueList.isEmpty()) {
			currNode = (Node) queueList.removeFirst();
			System.out.print(currNode.data + "    ");

			if (currNode.left != null) {
				queueList.add(currNode.left);
			}

			if (currNode.right != null) {
				queueList.add(currNode.right);
			}
		}
		System.out.println();
	}

	public void printInorder() {
		printInorder(root);
		System.out.println();
	}

	public void printInorder(Node node) {
		if (node == null) {
			return;
		}

		printInorder(node.left);
		System.out.print(node.data + "    ");
		printInorder(node.right);
	}

	public void printPreorder() {
		printPreorder(root);
		System.out.println();
	}

	public void printPreorder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + "    ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	public void printPostorder() {
		printPostorder(root);
		System.out.println();
	}

	public void printPostorder(Node node) {
		if (node == null) {
			return;
		}

		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data + "    ");
	}

	public static Node constructBinaryTree(List<Integer> preOrder, List<Integer> inOrder,
			int preOrderIndex, int inOrderIndex, int length) {
		if (length == 0) {
			return null;
		}

		Node node = new Node();
		int nodeData = ((Integer) preOrder.get(preOrderIndex)).intValue();
		node.data = nodeData;

		// Need to calculate relative index where the current node data is
		// present in inOrder traversal
		int rootIndex = 0;

		for (int count = inOrderIndex; count < inOrder.size(); count++) {
			int inOrderData = ((Integer) inOrder.get(count)).intValue();

			if (inOrderData == nodeData) {
				break;
			}

			rootIndex++;
		}

		node.left = constructBinaryTree(preOrder, inOrder, preOrderIndex + 1,
				inOrderIndex, rootIndex);

		node.right = constructBinaryTree(preOrder, inOrder, preOrderIndex
				+ rootIndex + 1, inOrderIndex + rootIndex + 1, length
				- (rootIndex + 1));

		return node;
	}
	
	public static void main(String[] args)
    {
        ArrayList<Integer> preOrder = new ArrayList<Integer>();
        preOrder.add(new Integer(1));
        preOrder.add(new Integer(2));
        preOrder.add(new Integer(4));
        preOrder.add(new Integer(8));
        preOrder.add(new Integer(9));
        preOrder.add(new Integer(10));
        preOrder.add(new Integer(11));
        preOrder.add(new Integer(5));
        preOrder.add(new Integer(3));
        preOrder.add(new Integer(6));
        preOrder.add(new Integer(7));
 
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        inOrder.add(new Integer(8));
        inOrder.add(new Integer(4));
        inOrder.add(new Integer(10));
        inOrder.add(new Integer(9));
        inOrder.add(new Integer(11));
        inOrder.add(new Integer(2));
        inOrder.add(new Integer(5));
        inOrder.add(new Integer(1));
        inOrder.add(new Integer(6));
        inOrder.add(new Integer(3));
        inOrder.add(new Integer(7));
 
        /*
        Constructs following tree
                        1
                    2         3
                4       5  6     7
            8       9
                 10     11
                                                        */

        Node node = constructBinaryTree(preOrder, inOrder, 0, 0, 11);
 
        //  For Testing
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("\n Inorder Traversal of constructed tree is ");
        binaryTree.printInorder(node);
        System.out.println("\n Preorder Traversal of constructed tree is ");
        binaryTree.printPreorder(node);
        System.out.println("\n Levelorder Traversal of constructed tree is ");
        binaryTree.printLevelOrder(node);
    }

}

class Node {
	Node left;
	Node right;
	Node parent;
	int data;
}