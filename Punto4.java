import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Punto4 {

    private static ArrayList<String> datos = new ArrayList<>();

    private static ArrayList<ArrayList<Integer>> arreglos = new ArrayList<>();

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

    public static void cargarArreglos() {
        int i = 0;

        while (i < datos.size()) {

            String linea = datos.get(i);
            int n = Integer.parseInt(linea);
            // System.out.println(n);
            ArrayList<Integer> subArray = new ArrayList<>();

            String[] numeros = datos.get(i + 1).split(",");
            String[] numeros2 = datos.get(i + 2).split(",");

            for (int j = 0; j < n; j++) {
                subArray.add(Integer.parseInt(numeros[j]));
                subArray.add(Integer.parseInt(numeros2[j]));

            }
            arreglos.add(subArray);
            i = i + 3;

        }

    }

    public static String masFrecuente(ArrayList<Integer> arreglo) {

        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for (int i = 0; i < arreglo.size(); i++) {
            int k = arreglo.get(i);
            if (hash.containsKey(k)) {
                int f = hash.get(k);
                f++;
                hash.put(k, f);
            } else {
                hash.put(k, 1);
            }
        }

        int max = 0;
        String masRepetido = "";

        for (Entry<Integer, Integer> val : hash.entrySet()) {
            if (max < val.getValue()) {
                masRepetido = Integer.toString(val.getKey());
                max = val.getValue();
            } else if (max == val.getValue()) {
                masRepetido = "nohay";
            } else {

            }

        }

        return masRepetido;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            cargarDatos();

        } catch (Exception e) {
            // TODO: handle exception
        }
        cargarArreglos();

        for (int i = 0; i < arreglos.size(); i++) {
            ArrayList<Integer> array = arreglos.get(i);
            String respuesta = masFrecuente(array);
            System.out.println(respuesta);
        }

    }

}