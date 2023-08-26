import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Histograma {
    public static void main(String[] args) {

        BufferedReader br = null;

        try{

            br = new BufferedReader(new FileReader("src/divina_comedia_sp.txt"));
            String leerLinea = br.readLine();

            int[] histograma = new int[11];

            while (leerLinea != null){

                String[] palabras = leerLinea.split("\\s+");

                for (String s : palabras
                     ) {

                    s.replaceAll("[^a-zA-Z]", "");

                    if (s.length() >= 2 && s.length() <=10){

                        int longitud = s.length();

                        histograma[longitud]++;

                    }

                }
                leerLinea = br.readLine();
            }

            for (int i = 2; i <= 10 ; i++) {

                int frecuencia = histograma[i];

                 System.out.println("Palabras con " + i + " letras: " + frecuencia);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}