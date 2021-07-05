package MFrequentAarray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Punto4 {

    private static ArrayList<String> datos = new ArrayList<>();

    private static ArrayList<int[]> arreglos = new ArrayList<>();

    public static void cargarDatos() throws IOException {

        FileReader fr = new FileReader("./data/input.txt");
        
        BufferedReader br = new BufferedReader(fr);
    
        String lin;
        while ((lin = br.readLine()) != null && !"0".equals(lin)) {
            Scanner scanner = new Scanner(lin);
            String dato = "";
            int j = 0;
            while (scanner.hasNextInt()) {
                if (j == 0) {
                    dato = dato + scanner.next();
                } else {
                    dato = dato + "," + scanner.next();
                }

                j++;
            }
            datos.add(dato);

        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            cargarDatos();

        } catch (Exception e) {
            // TODO: handle exception
        }

        for (int i = 0; i < datos.size(); i++) {
            System.out.println(datos.get(i));
        }
        System.out.println("holaaaa");
        System.out.println(datos.size());
        System.out.println(datos.get(0));
    }

}
