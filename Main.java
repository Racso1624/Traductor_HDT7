import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String[]> diccionario = new HashMap<Integer, String[]>();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        String[] frase = {};

        try {
            File obj = new File("Diccionario.txt");
            Scanner myReader = new Scanner(obj);
            int contador = 0;
            while (myReader.hasNextLine()) {
                contador++;
                String data = myReader.nextLine();
                String[] datasplit = data.split(","); 
                diccionario.put(contador, datasplit);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }

        for(int i = 1; i <= diccionario.size(); i++) {
            String[] llave = diccionario.get(i);
            Association<Integer, String[]> traduccion = new Association<Integer,String[]>(i, llave);
            binarySearchTree.insert(i, traduccion);
        }

        try {
            File obj = new File("Texto.txt");
            Scanner myReader = new Scanner(obj);
            String data = myReader.nextLine();
            data = data.replace(".", "");
            frase = data.split(" ");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }

        System.out.println("\nBienvenido al Traductor");
		
		boolean var = false;
        while(var == false){

            String idioma = "";
     
            System.out.println("\n\nIngrese la traduccion que desea:");
            System.out.println("1) Ingles");
            System.out.println("2) Español");
            System.out.println("3) Francés");
            System.out.println("4) Salir");

            try {
                
                int opcion = scanner.nextInt();

                if(opcion == 1){
                    idioma = "Ingles";
                }
                else if(opcion == 2){
                    idioma = "Espanol";
                }
                else if(opcion == 3){
                    idioma = "Frances";
                }
                else if(opcion == 4){
                    var = true;
                }
                else{
                    System.out.println("Opcion Incorrecta");
                    var = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("\nOpcion Incorrecta, Ingresela de Nuevo");
                scanner.nextLine();
                var = true;
            }

            binarySearchTree.inorder();
            
            for(int i = 0; i < frase.length; i++){
                System.out.println("HOLA");

                int llavearbol = 0;
                String palabra = frase[i];
                int contadorpalabras = 0;
                System.out.println("la palabra es" + palabra);
    
                for(int j = 1; j <= diccionario.size(); j++) {
                    String[] llave = diccionario.get(j);
                    for(int k = 0; k < llave.length; k++){
    
                        String traduccion = llave[k];
                        if(traduccion.equalsIgnoreCase(palabra)){
                            llavearbol = j;
                        }
                        else{
                            contadorpalabras++;
                        }
                    }
                }

                int limite = diccionario.size() * 3;
                if(contadorpalabras == limite){
                    String nuevaPalabra = "";
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
                else{
                    Node node = binarySearchTree.search(binarySearchTree.getRoot(), llavearbol);
                    String[] traducciones = node.getTraduccion();

                    int idiomanumero = -1;
                    if(idioma.equals("Ingles")){
                        idiomanumero = 0;
                    }
                    else if(idioma.equals("Espanol")){
                        idiomanumero = 1;
                    }
                    else if(idioma.equals("Frances")){
                        idiomanumero = 2;
                    }

                    frase[i] = traducciones[idiomanumero];
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
