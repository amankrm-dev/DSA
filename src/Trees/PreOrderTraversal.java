package Trees;

class node {
    int data;
    node left, right;

    node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class PreOrderTraversal {

    // Method for pre-order traversal
    public void preOrder(node root) {
        if (root == null) {
            return;
        }
        // Visit the root Trees.node
        System.out.print(root.data + " ");
        // Traverse the left subtree
        preOrder(root.left);
        // Traverse the right subtree
        preOrder(root.right);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);

        PreOrderTraversal traversal = new PreOrderTraversal();
        System.out.print("Pre-order Traversal: ");
        traversal.preOrder(root); // Output: 1 2 4 5 3
    }
}