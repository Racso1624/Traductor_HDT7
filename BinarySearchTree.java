// Java program to demonstrate
// insert operation in binary
// search tree

//Codigo Obtenido de la Pagina Geeks for Geeks
class BinarySearchTree {

	/* Class containing left
	and right child of current node
	* and key value*/

	// Root of BST
	Node root;

	// Constructor
	public BinarySearchTree()
	{
		root = null;
	}

	// This method mainly calls insertRec()
	public void insert(int key, Association<Integer, String[]> valores)
	{
		root = insertRec(root, key, valores);
	}

	/* A recursive function to
	insert a new key in BST */
	public Node insertRec(Node root, int key, Association<Integer, String[]> valores)
	{

		/* If the tree is empty,
		return a new node */
		if (root == null)
		{
			root = new Node(key, valores);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key, valores);
		else if (key > root.key)
			root.right = insertRec(root.right, key, valores);

		/* return the (unchanged) node pointer */
		return root;
	}

	// This method mainly calls InorderRec()
	public void inorder()
	{
		inorderRec(root);
	}

	// A utility function to
	// do inorder traversal of BST
	public void inorderRec(Node root)
	{
		if (root != null) {
			inorderRec(root.left);
			inorderRec(root.right);
		}
	}

    // A utility function to search a given key in BST
	public Node search(Node root, int key)
	{
		// Base Cases: root is null or key is present at root
		if (root==null || root.key==key)
			return root;

		// Key is greater than root's key
		if (root.key < key)
		return search(root.right, key);

		// Key is smaller than root's key
		return search(root.left, key);
	}

    public Node getRoot() {
        return root;
    }
}
// This code is contributed by Ankur Narain Verma
