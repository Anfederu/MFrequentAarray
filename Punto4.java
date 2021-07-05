package MFrequentAarray;

public class Punto4 {

    private static ArrayList<String> datos = new ArrayList<>();

    private static ArrayList<ArrayList<Integer>> arreglo = new ArrayList<>();

    public static void cargarDatos() throws IOException {

        FileReader fr = new FileReader("./data/input.txt");
        
        BufferedReader br = new BufferedReader(fr);
    
        String lin;
        while ((lin = br.readLine()) != null && !"0".equals(lin)) {
            Scanner scanner = new Scanner(lin);

            int j = 0;

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
    
    
    public static void cargarArreglos(){
    	int i = 0;
		
		while(i<datos.size()){
			
			String linea = datos.get(i);
			int n = Integer.parseInt(linea);
			//System.out.println(n);
			ArrayList<Integer> subArray = new ArrayList<>();
						
			String[] numeros = datos.get(i+1).split(",");
			String[] numeros2 =datos.get(i+2).split(",");
			
			for(int j = 0; j<n;j++){
				subArray.add(Integer.parseInt(numeros[j]));
				subArray.add(Integer.parseInt(numeros2[j]));
				
			}			
			arreglo.add(subArray);
			i=i+3;		
			
		}			
			
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            cargarDatos();

        } catch (Exception e) {
            // TODO: handle exception
        }
        cargarArreglos();
        System.out.println(arreglo.size());
        for (int i = 0; i < arreglo.size(); i++) {
            System.out.println(arreglo.get(i));
        }
       
    }

}