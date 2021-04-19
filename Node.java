/**
 * Oscar Fernando López Barrios
 * Carné 20679
 * 
 * Node
 */
//Codigo Obtenido de la Pagina Geeks for Geeks

//Se crea la Clase Node
public class Node {

	//Se hacen las instancias y las variables
	Association<Integer, String[]> traducciones;
	int key;
	Node left, right;

	//Se crea el constructor
	public Node(int item, Association<Integer, String[]> datos)
	{
		//Se guarda la llave
		key = item;
		left = right = null;
		//Se guarda el valor
		traducciones = datos;
	}

	
	/** 
	 * Pre:Se tiene el array
	 * @return String[] es array de String
	 * Post:Se regresa el String
	 */
	//Se regresa el array dentro del nodo
	public String[] getTraduccion() {
		return traducciones.getValue();
	}

}