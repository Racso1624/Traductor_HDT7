/**
 * Oscar Fernando López Barrios
 * Carné 20679
 * 
 * BinarySearchTree
 */

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

	
	/** 
	 * Pre:Se tiene el BST
	 * @param key es la llave que se ingresa
	 * @param valores son los valores de association
	 * Post:Se ingresan los valores al BST
	 */
	// This method mainly calls insertRec()
	public void insert(int key, Association<Integer, String[]> valores)
	{
		root = insertRec(root, key, valores);
	}

	
	/** 
	 * Pre:Se tiene el BST
	 * @param root es el root del BST
	 * @param key es la llave que se ingresa
	 * @param valores son los valores de association
	 * @return Node es el nodo que se regresa
	 * Pre:Se ingresa un nuevo valor
	 */
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

	/** 
	 * Pre:Se tiene el BST
	 * Post:Se ordena el BST
	 */
	// This method mainly calls InorderRec()
	public void inorder()
	{
		inorderRec(root);
	}

	
	/** 
	 * Pre:Se tiene el BST
	 * @param root es root del BST
	 * Post:Se ordena el BST
	 */
	// A utility function to
	// do inorder traversal of BST
	public void inorderRec(Node root)
	{
		if (root != null) {
			inorderRec(root.left);
			inorderRec(root.right);
		}
	}

    
	/** 
	 * Pre:Se tiene el BST
	 * @param root es el root del BST
	 * @param key es la llave que se busca
	 * @return Node es el nodo
	 * Post:Se regresa el nodo deseado del BST
	 */
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

    
	/** 
	 * Pre:Se tiene el root
	 * @return Node se regresa el root del Nodo
	 * Post:Se regresa el root del Nodo
	 */
	public Node getRoot() {
        return root;
    }
}
// This code is contributed by Ankur Narain Verma
