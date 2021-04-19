/**
 * Oscar Fernando López Barrios
 * Carné 20679
 * 
 * Pruebas Unitarias
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class PruebasUnitarias {
    
    BinarySearchTree binarySearchTree = new BinarySearchTree();

    @Test
    public void insertar(){
        String[] lista = {"HOLA"};
        Association<Integer, String[]> association = new Association<Integer,String[]>(1, lista);
        binarySearchTree.insert(1, association);
        Node node = binarySearchTree.search(binarySearchTree.getRoot(), 1);

        assertEquals(lista, node.getTraduccion());//Se verifica si la lista que regresa es la mismas
    }

    @Test
    public void buscar(){
        String[] lista = {"HOLA", "A", "TODOS"};
        Association<Integer, String[]> association = new Association<Integer,String[]>(1, lista);
        binarySearchTree.insert(1, association);
        Node node = binarySearchTree.search(binarySearchTree.getRoot(), 1);

        assertEquals(association, node.getTraducciones());//Se verifica si la association que regresa es la mismas
    }
}
