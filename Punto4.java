
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

            }
            for (int j = 0; j < n; j++) {

                subArray.add(Integer.parseInt(numeros2[j]));

            }
            arreglos.add(subArray);
            i = i + 3;

        }

    }

    public static String masFrecuente(ArrayList<Integer> arreglo) {

        Map<Integer, Integer> hashPrimerArray = new HashMap<Integer, Integer>();
        Map<Integer, Integer> hashSegundoArray = new HashMap<Integer, Integer>();

        int n = arreglo.size();
        System.out.println(arreglo);
        for (int i = 0; i < n / 2; i++) {
            int k = arreglo.get(i);
            if (hashPrimerArray.containsKey(k)) {
                int f = hashPrimerArray.get(k);
                f++;
                hashPrimerArray.put(k, f);

            } else {
                hashPrimerArray.put(k, 1);

            }
        }

        for (int i = n / 2; i < arreglo.size(); i++) {

            int k = arreglo.get(i);
            if (hashSegundoArray.containsKey(k)) {
                int f = hashSegundoArray.get(k);
                f++;
                hashSegundoArray.put(k, f);

            } else {
                hashSegundoArray.put(k, 1);

            }
        }

        int maxFrecuencia = 0;
        String masRepetido = "nohay";

        for (Entry<Integer, Integer> val : hashPrimerArray.entrySet()) {
            int key = val.getKey();

            if (hashSegundoArray.containsKey(key)) {

                int sumaFrecuencia = hashPrimerArray.get(key) + hashSegundoArray.get(key);

                if (sumaFrecuencia > maxFrecuencia) {
                    int numero = val.getKey();
                    masRepetido = Integer.toString(numero);
                    maxFrecuencia = sumaFrecuencia;
                }
            }

        }

        return masRepetido;

    }

    public static boolean estanAmbos(Map<Integer, Integer> hash, Map<Integer, Integer> hash2, int n) {

        boolean res = false;
        if (hash.containsKey(n) && hash2.containsKey(n)) {
            res = true;
        }
        return res;

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