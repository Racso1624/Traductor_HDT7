import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        String[] frasecompleta = {};
        int cantidadPalabras = 0;

        try {
            File obj = new File("Diccionario.txt");
            Scanner myReader = new Scanner(obj);
            int contador = 0;
            while (myReader.hasNextLine()) {
                contador++;
                String data = myReader.nextLine();
                String[] datasplit = data.split(","); 
                Association<Integer, String[]> traduccion = new Association<Integer,String[]>(contador, datasplit);
                binarySearchTree.insert(contador, traduccion);
            }
            cantidadPalabras = contador;
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }

        try {
            File obj = new File("Texto.txt");
            Scanner myReader = new Scanner(obj);
            String data = myReader.nextLine();
            data = data.replace(".", "");
            frasecompleta = data.split(" ");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }

        System.out.println("\nBienvenido al Traductor");
        	
		boolean var = false;
        a: while(var == false){

            int idiomanumero = 0;
            String[] frase = frasecompleta;
     
            boolean var2 = false;
            while(var2 == false){
                System.out.println("\n\nIngrese la traduccion que desea:");
                System.out.println("1) Ingles");
                System.out.println("2) Español");
                System.out.println("3) Francés");
                System.out.println("4) Salir\n");

                try {
                    
                    int opcion = scanner.nextInt();

                    if(opcion == 1){
                        idiomanumero = 0;
                        var2 = true;
                    }
                    else if(opcion == 2){
                        idiomanumero = 1;
                        var2 = true;
                    }
                    else if(opcion == 3){
                        idiomanumero = 2;
                        var2 = true;
                    }
                    else if(opcion == 4){
                        System.out.println("Saliendo del Programa");
                        break a;
                    }
                    else{
                        System.out.println("Opcion Incorrecta");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("\nOpcion Incorrecta, Ingresela de Nuevo");
                    scanner.nextLine();
                }
            }

            binarySearchTree.inorder();
            
            for(int i = 0; i < frase.length; i++){

                String palabra = frase[i];
                int contadorpalabras = 0;
    
                for(int j = 1; j <= cantidadPalabras; j++) {
                    Node nodo = binarySearchTree.search(binarySearchTree.getRoot(), j);
                    String[] llave = nodo.getTraduccion();

                    for(int k = 0; k < llave.length; k++){
    
                        String traduccion = llave[k];
                        if(traduccion.equalsIgnoreCase(palabra)){
                            frase[i] = llave[idiomanumero];
                        }
                        else{
                            contadorpalabras++;
                        }
                    }
                }

                int limite = cantidadPalabras * 3;
                if(contadorpalabras == limite){
                    String nuevaPalabra = "";
                    if(palabra.charAt(0) != '*' && palabra.charAt(palabra.length() - 1) != '*'){
                        for(int j = -1; j < (palabra.length() + 1); j++){
                            if(j == -1 || j == palabra.length()){
                                nuevaPalabra += "*";
                            }
                            else{
                                nuevaPalabra += palabra.charAt(j);
                            }
                        }
                        frase[i] = nuevaPalabra;  
                    }
                }
            }

            String frasefinal = "";
            for(int i = 0; i < frase.length; i++){
                frasefinal += frase[i];
                frasefinal += " ";
            }
            System.out.println("La traduccion es: " + frasefinal);
        }
        
    }
}
