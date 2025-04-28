package Trees;

/**
 * Binary Search Tree implementation with all standard operations
 */
public class BinarySearchTree {
    // Node class for BST
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Root of BST
    private Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Insert a new value into the BST
     * @param data value to be inserted
     */
    public void insert(int data) {
        root = insertRec(root, data);
    }

    /**
     * Recursive helper method for insertion
     * @param root current node
     * @param data value to be inserted
     * @return updated node
     */
    private Node insertRec(Node root, int data) {
        // If the tree is empty, create a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        // Return the unchanged node pointer
        return root;
    }

    /**
     * Search for a value in the BST
     * @param data value to search for
     * @return true if found, false otherwise
     */
    public boolean search(int data) {
        return searchRec(root, data);
    }

    /**
     * Recursive helper method for search
     * @param root current node
     * @param data value to search for
     * @return true if found, false otherwise
     */
    private boolean searchRec(Node root, int data) {
        // Base case: root is null or data is present at root
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }

        // Value is greater than root's data
        if (root.data < data) {
            return searchRec(root.right, data);
        }

        // Value is less than root's data
        return searchRec(root.left, data);
    }

    /**
     * Delete a value from the BST
     * @param data value to be deleted
     */
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    /**
     * Recursive helper method for deletion
     * @param root current node
     * @param data value to be deleted
     * @return updated node
     */
    private Node deleteRec(Node root, int data) {
        // Base case: If the tree is empty
        if (root == null) {
            return root;
        }

        // Recur down the tree
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    /**
     * Find the minimum value in a BST
     * @param root starting node
     * @return minimum value
     */
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    /**
     * Find the minimum value in the BST
     * @return minimum value or -1 if tree is empty
     */
    public int findMin() {
        if (root == null) {
            System.out.println("Tree is empty");
            return -1;
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    /**
     * Find the maximum value in the BST
     * @return maximum value or -1 if tree is empty
     */
    public int findMax() {
        if (root == null) {
            System.out.println("Tree is empty");
            return -1;
        }
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    /**
     * Check if the BST is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Calculate the height of the BST
     * @return height of the tree
     */
    public int height() {
        return heightRec(root);
    }

    /**
     * Recursive helper method for height calculation
     * @param root current node
     * @return height of the subtree
     */
    private int heightRec(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Perform in-order traversal of the BST
     */
    public void inOrderTraversal() {
        System.out.print("In-order Traversal: ");
        inOrderRec(root);
        System.out.println();
    }

    /**
     * Recursive helper method for in-order traversal
     * @param root current node
     */
    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    /**
     * Perform pre-order traversal of the BST
     */
    public void preOrderTraversal() {
        System.out.print("Pre-order Traversal: ");
        preOrderRec(root);
        System.out.println();
    }

    /**
     * Recursive helper method for pre-order traversal
     * @param root current node
     */
    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    /**
     * Perform post-order traversal of the BST
     */
    public void postOrderTraversal() {
        System.out.print("Post-order Traversal: ");
        postOrderRec(root);
        System.out.println();
    }

    /**
     * Recursive helper method for post-order traversal
     * @param root current node
     */
    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    /**
     * Count the number of nodes in the BST
     * @return number of nodes
     */
    public int countNodes() {
        return countNodesRec(root);
    }

    /**
     * Recursive helper method for counting nodes
     * @param root current node
     * @return number of nodes in the subtree
     */
    private int countNodesRec(Node root) {
        if (root == null) {
            return 0;
        }
        return countNodesRec(root.left) + countNodesRec(root.right) + 1;
    }

    /**
     * Main method to demonstrate BST operations
     */
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Display traversals
        bst.inOrderTraversal();    // Expected: 20 30 40 50 60 70 80
        bst.preOrderTraversal();   // Expected: 50 30 20 40 70 60 80
        bst.postOrderTraversal();  // Expected: 20 40 30 60 80 70 50

        // Search operations
        System.out.println("Search for 20: " + bst.search(20));  // Expected: true
        System.out.println("Search for 100: " + bst.search(100));  // Expected: false

        // Find min and max
        System.out.println("Minimum value: " + bst.findMin());  // Expected: 20
        System.out.println("Maximum value: " + bst.findMax());  // Expected: 80

        // Height and count
        System.out.println("Height of tree: " + bst.height());  // Expected: 3
        System.out.println("Number of nodes: " + bst.countNodes());  // Expected: 7

        // Delete operations
        System.out.println("\nAfter deleting 20:");
        bst.delete(20);
        bst.inOrderTraversal();  // Expected: 30 40 50 60 70 80

        System.out.println("After deleting 30:");
        bst.delete(30);
        bst.inOrderTraversal();  // Expected: 40 50 60 70 80

        System.out.println("After deleting 50 (root):");
        bst.delete(50);
        bst.inOrderTraversal();  // Expected: 40 60 70 80

        // Check if empty
        System.out.println("Is BST empty? " + bst.isEmpty());  // Expected: false

        // Create a new empty BST
        BinarySearchTree emptyBST = new BinarySearchTree();
        System.out.println("Is new BST empty? " + emptyBST.isEmpty());  // Expected: true
    }
}
