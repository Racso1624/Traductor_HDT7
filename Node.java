/**
 * Node
 */
//Codigo Obtenido de la Pagina Geeks for Geeks
public class Node {

	Association<Integer, String[]> traducciones;
	int key;
	Node left, right;

	public Node(int item, Association<Integer, String[]> datos)
	{
		key = item;
		left = right = null;

		traducciones = datos;
	}

	public String[] getTraduccion() {
		return traducciones.getValue();
	}

}